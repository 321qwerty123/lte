<template>

  <div class="content">
    <a-card>

    <a-form
            id="components-form-demo-normal-login"
            :form="form"
            class="login-form"
            @submit="handleSubmit"
    >
      <a-form-item>
        <a-input :allowClear="allowClear"
                v-decorator="[
          'account',
          { rules: [{ required: true, message: 'Please input your account!' }] },
        ]"
                placeholder="account"
        >
          <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input  :allowClear="allowClear"
                v-decorator="[
          'pwd',
          { rules: [{ required: true, message: 'Please input your Password!' }] },
        ]"
                type="password"
                placeholder="Password"
        >
          <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-checkbox
                v-decorator="[
          'remember',
          {
            valuePropName: 'checked',
            initialValue: true,
          },
        ]"
        >
          Remember me
        </a-checkbox>
        <a class="login-form-forgot" href="">
          Forgot password
        </a>
        <a-button type="primary" html-type="submit" class="login-form-button">
          Log in
        </a-button>
        Or
        <a href="">
          register now!
        </a>
      </a-form-item>
    </a-form>
    </a-card>

  </div>

</template>

<script>
  import {loginReq} from "../api/backend-req/login";

  export default {
  name: "Auth",

  data() {
    return {
      allowClear:true,
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'normal_login' })
    };
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
          let reqParam = values;
          loginReq(reqParam).then(res=>{
            console.log('login res ---',res)
            sessionStorage.setItem('loginInfo',JSON.stringify(res.data.data));
            // this.$router.push({path:'/defaultHome',query:{auth:'123'}})
            this.$router.push({path:'/defaultHome',query:res.data.data})

          }).catch(err=>{

          })
        }
      });
    },

  },
}
</script>

<style scoped>


.content {
  width: 400px;
  height: 300px;
  margin: 0 auto;
  top: 190px;
  position: relative;
}
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100%;
}
</style>
