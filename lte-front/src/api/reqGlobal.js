import axios from 'axios';

/**
 * https://blog.csdn.net/zqy_009/article/details/81021347
 * https://www.jianshu.com/p/a0c67f4e145e
 *  vue cli+axios 拦截器使用
 */

const reqGlobal = axios.create({
    // api的base_url  process.env.BASE_URL相当于 /
    baseURL: process.env.BASE_URL,
    // 请求超时时间
    timeout: 5000,
    // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
    // 如果请求话费了超过 `timeout` 的时间，请求将被中断


    // `withCredentials` 表示跨域请求时是否需要使用凭证
    withCredentials: false, // 默认的

    // `maxContentLength` 定义允许的响应内容的最大尺寸
    maxContentLength: 5000,


})

/**
 * 拦截请求
 */
reqGlobal.interceptors.request.use(reqConfig=>{
    console.log('before sending')
    console.log(reqConfig)

    // const token = sessionStorage.getItem('token')
    // if (token ) { // 判断是否存在token，如果存在的话，则每个http header都加上token
    //     config.headers.authorization = token  //请求头加上token
    // }


    return reqConfig;
},error => {
    // Do something with request error
    return Promise.reject(error);

    //return Promise.resolve(err);
    // 请求错误时，不会直接结束，将会继续传到then里面,无论请求成功还是失败，在成功的回调中都能收到通知
});

/**
 * 拦截响应
 */
reqGlobal.interceptors.response.use(res=>{
    console.log('before res')
    console.log(res)
    return res;
},error => {

    if (error.response) {
        switch (error.response.status) {
            case 400: error.message = '请求错误(400)' ; break;
            case 401:
                // 这里写清除token的代码
                error.message = '未授权，请重新登录(401)';
                // router.replace({
                //     path: 'login',
                //     query: {redirect: router.currentRoute.fullPath}//登录成功后跳入浏览的当前页面
                // })

                break;
            case 403: error.message = '拒绝访问(403)'; break;
            case 404: error.message = `请求出错(404)`; break;
            case 408: error.message = '请求超时(408)'; break;
            case 500: error.message = '服务器错误(500)'; break;
            case 501: error.message = '服务未实现(501)'; break;
            case 502: error.message = '网络错误(502)'; break;
            case 503: error.message = '服务不可用(503)'; break;
            case 504: error.message = '网络超时(504)'; break;
            case 505: error.message = 'HTTP版本不受支持(505)'; break;
            default: error.message = `连接出错(${error.response.status})!`;

        }
    }




    //请求错误时，直接结束
    return Promise.reject(error)


    // 请求错误时，不会直接结束，将会继续传到then里面,无论请求成功还是失败，在成功的回调中都能收到通知
    //return Promise.resolve(error);

});




export default reqGlobal
