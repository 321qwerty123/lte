const proxy = require('http-proxy-middleware');
const webpack = require('webpack');
const path = require('path');
const myMockData = require("./mock/list.json");
module.exports = {

    //编译打包存放的目录默认dist
    outputDir: 'dist',

    // 如果你不需要使用eslint，把lintOnSave设为false即可
    lintOnSave: false,

    // 设为false打包时不生成.map文件
    productionSourceMap: false,

    //node服务器开发环境配置,(实际上线时host,port 以 nginx 服务器配置来生效)
    devServer: {
        //---------Mock 数据来模拟接口的实现----------------
        before(app) {
            app.get("/goods/list", (req, res) => {
                res.json({
                    data: myMockData
                });
            });
        },

        //------node.js启动配置----------------
        //设置node启动后自动打开浏览器访问本项目
        open: true,
        // 配置'0.0.0.0'时,可以按照本机局域网真实IP访问 即 Network: http://192.168.25.12:8088/
        //若配置为localhost，则只能按照localhost访问
        host: '0.0.0.0',
        // 端口号
        port: 8083,
        //------nodeJs代理转发配置(可实现跨域请求后台接口)-----------------------
        //proxy:{'/api':{}},代理器中设置/api,项目中请求路径为/api的替换为target
        proxy: {

            /**
             *  在组件中访问 /lte/login?account=lhc&pwd=123456
             *  proxy 自动代理转发到 GET http://localhost:8081/lte/login?account=lhc&pwd=123456

             *  以下为转发规则
             */
            '/lte': {
                target: 'http://localhost:8081',//代理地址，这里设置的地址会代替axios中设置的baseURL
                changeOrigin: true,// 如果接口跨域，需要进行这个参数配置
                secure: false, // https协议才设置
                //ws: true, // proxy websockets
                //pathRewrite方法重写url
                pathRewrite: {
                    '^/lte': '/lte'
                    //pathRewrite: {'^/api': '/'} 重写之后url为 http://192.168.1.16:8085/xxxx
                    //pathRewrite: {'^/api': '/api'} 重写之后url为 http://192.168.1.16:8085/api/xxxx
                }
            }
        }
    },



}
