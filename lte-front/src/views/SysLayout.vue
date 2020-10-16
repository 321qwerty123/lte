<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider v-model="collapsed" collapsible>
      <div class="logo">
        <p style="text-align: center;color: white">TEST</p>
      </div>
      <a-menu theme="dark" :default-selected-keys="['1']" mode="inline">
        <!--    1层菜单    -->
        <a-menu-item key="1">
          <a-icon type="pie-chart"/>
          <span>Option 1</span>
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
          <a-button style="margin-right: 5px">
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

export default {
  name: 'SysLayout',
  components: {
    TimeOut
  },
  data() {
    return {

      timer: undefined,
      collapsed: false,
    };
  },
  methods: {
    logoutSys() {
      this.$router.push({path: '/'});
      sessionStorage.clear();
    },
    getLoginAccountName(){
     let loginInfoStr = sessionStorage.getItem('loginInfo');
     if (loginInfoStr !== undefined){
       return JSON.parse(loginInfoStr).userName;
     }else {
       return "Personal";
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
