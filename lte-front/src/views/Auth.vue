<template>

  <div class="content">
    <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" @submit="handleSubmit">
      <a-form-item label="Account">
        <a-input
                v-decorator="['account', { rules: [{ required: true, message: 'Please input your account!' }] }]"
        />
      </a-form-item>
      <a-form-item label="Pwd">
        <a-input
                v-decorator="['pwd', { rules: [{ required: true, message: 'Please input your pwd!' }] }]"
        />
      </a-form-item>
      <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
        <a-button type="primary" html-type="submit">
          Submit
        </a-button>
      </a-form-item>
    </a-form>
  </div>

</template>

<script>
export default {
  name: "Auth",
  data() {
    return {
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'coordinated' }),
    };
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values);
        }
      });
    },

  },
}
</script>

<style scoped>
html,body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}


.content {
  width: 500px;
  height: 300px;
  background: orange;
  margin: 0 auto;
  top: 100px;
  position: relative;
}

</style>
