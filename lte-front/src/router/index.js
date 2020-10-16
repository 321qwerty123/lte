import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Personal from "@/views/Personal";
import SysLayout from "@/views/SysLayout";
import TimeOut from "@/views/TimeOut";
import DefaultHome from "@/views/DefaultHome";
import Error from "@/views/Error";
import UserManage from "@/views/UserManage";
Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home
  // },
  // {
  //   path: '/timeout',
  //   name: 'TimeOut',
  //   component: TimeOut
  // },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // },
  {
    path: '/',
    name: 'Auth',
    component: () => import(/* webpackChunkName: "about" */ '../views/Auth.vue')
  },
  // {
  //   path: '/personal',
  //   name: 'Personal',
  //   component: Personal
  // },
  {
    path: '/defaultHome',
    name: 'SysLayout',
    component: SysLayout,
    children:[
      {
        path:'/',
        name:'defaultHome',
        component:DefaultHome
      },
      {
        path: '/personal',
        name: 'Personal',
        component: Personal
      },
      {
        path: '/userManage',
        name: 'UserManage',
        component: UserManage
      },

    ]
  },
  // {
  //   path: '*',
  //   name: 'error',
  //   component:Error
  // }
]

const router = new VueRouter({
  routes
})
//全局前置守卫
router.beforeEach((to, from, next) => {
  // console.log('即将要进入的目标 路由对象')
  // console.log(to);
  // console.log('当前导航正要离开的路由')
  // console.log(from);

  if (to.path === '/' ){
    //任何情况均可访问login页面
    next();
  }else {
    let loginInfoStr = sessionStorage.getItem('loginInfo');
    if (loginInfoStr !== undefined && loginInfoStr !== null){
      let token = JSON.parse(loginInfoStr).token;
      if (token !== undefined && token !== null){
        //有token表示已登录
        next();
      }else {
        //回去login页
        next({ path: '/' });
      }
    }else {
      //回去login页
      next({ path: '/' });
    }
  }



  //next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
  //
  // next(): 进行管道中的下一个钩子。如果全部钩子执行完了，则导航的状态就是 confirmed (确认的)。
  //
  // next(false): 中断当前的导航。如果浏览器的 URL 改变了 (可能是用户手动或者浏览器后退按钮)，那么 URL 地址会重置到 from 路由对应的地址。
  //
  // next('/') 或者 next({ path: '/' }): 跳转到一个不同的地址。当前的导航被中断，然后进行一个新的导航。你可以向 next 传递任意位置对象，且允许设置诸如 replace: true、name: 'home' 之类的选项以及任何用在 router-link 的 to prop 或 router.push 中的选项。
  //
  // next(error): (2.4.0+) 如果传入 next 的参数是一个 Error 实例，则导航会被终止且该错误会被传递给 router.onError() 注册过的回调

});

//全局后置钩子
//全局后置钩子，然而和守卫不同的是，这些钩子不会接受 next 函数也不会改变导航本身：
router.afterEach((to, from) => {
  console.log('=============================')
  console.log('即将要进入的目标 路由对象')
  console.log(to);
  console.log('当前导航正要离开的路由')
  console.log(from);
});
export default router
