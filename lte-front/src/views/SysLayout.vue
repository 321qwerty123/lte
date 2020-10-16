<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <div class="logo">
        <p style="text-align: center;color: white">TEST</p>
      </div>
      <a-menu theme="dark" :default-selected-keys="['1']" mode="inline">
        <!--    1层菜单    -->
        <a-menu-item  @click="test1" key="defaultHome">
          <a-icon type="home" />
          <span>Home</span>
        </a-menu-item>


        <!-- 2层菜单-->
        <a-sub-menu key="sub1">
          <span slot="title"><a-icon type="user"/><span>User</span></span>
          <a-menu-item key="3">
            Tom
          </a-menu-item>
          <a-menu-item key="4">
            Bill
          </a-menu-item>
          <a-menu-item key="5">
            Alex
          </a-menu-item>
        </a-sub-menu>

      </a-menu>
    </a-layout-sider>

    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <div style="float: right">
          <TimeOut style="display: inline-block"></TimeOut>
          <a-button style="margin-right: 5px">
            <a-icon type="user"/>
            {{getLoginAccountName()}}
          </a-button>

          <a-button @click="screenfullBtn()" style="margin-right: 5px">
            <a-icon type="fullscreen"/>
            全屏
          </a-button>

          <a-button @click="logoutSys()" type="primary" style="margin-right: 5px">
            <a-icon type="logout"/>
            退出
          </a-button>
        </div>
      </a-layout-header>

      <a-layout-content style="margin: 0 16px">
        <a-breadcrumb style="margin: 16px 0">
<!--          <a-breadcrumb-item>User</a-breadcrumb-item>-->
          <a-breadcrumb-item>{{ this.$route.name }}</a-breadcrumb-item>
        </a-breadcrumb>
        <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">

          <router-view/>

        </div>
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        Ant Design ©2018 Created by Ant UED
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
import TimeOut from "@/views/TimeOut";
import screenfull from 'screenfull'
export default {
  name: 'SysLayout',
  components: {
    TimeOut
  },
  data() {
    return {
      collapsed: false,
    };
  },
  methods: {
    test1(v1){
      console.log(v1)


    },
    //退出按钮事件
    logoutSys() {
      this.$router.push({path: '/'});
      sessionStorage.clear();
    },
    //显示登陆账户中文名
    getLoginAccountName(){
     let loginInfoStr = sessionStorage.getItem('loginInfo');
     if (loginInfoStr !== undefined){
       return JSON.parse(loginInfoStr).userName;
     }else {
       return "Personal";
     }
    },
    //全屏按钮事件
    screenfullBtn(){
      if (!screenfull.isEnabled) {
        this.$message.warning('浏览器不支持全屏!');
        return false;
      }
      screenfull.toggle();
      console.log(screenfull.isFullscreen)
      if (screenfull.isFullscreen){
        this.$message.success('页面已退出全屏!');
      }else {
        this.$message.success('页面已全屏显示!');
      }
    }

  },
  mounted() {


  },
  beforeDestroy() {


  }
};
</script>

<style>
#components-layout-demo-side .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
  line-height: 32px;
}
</style>
