<template>
<div class="wrap">
    <div class="right">
      <img :src="back" style="width: 700px ;height:850px">
    </div>
    <div class="left">
      <img :src="logo" style="width:100px" id="logo">
      <span id="txt"><font size="6" color="green">注册</font></span>
      <div id="line">
        <hr style="width:600px; height:3px; green"/>
      </div>
      <div id="loginform" style="width:500px;" >
        <el-form :model="registerForm" :rules="registermRules" ref="registerForm">
          <el-form-item style="margin-bottom:50px">
            <el-input prefix-icon="el-icon-user" placeholder="账号" v-model="registerForm.phonenumber">
            </el-input>
          </el-form-item>
          <el-form-item prop="password" style="margin-bottom:50px">
            <el-input
              placeholder="密码"
              prefix-icon="el-icon-lock"
              v-model="registerForm.password"
            ></el-input>
          </el-form-item>
          <el-form-item  prop="confirmPwd">
            <el-input type="password" placeholder="确认密码" v-model="registerForm.confirmPwd">
            </el-input>

          </el-form-item>
          <el-button style="width:500px;" type="success" @click="register('registerForm')">
            立即注册
          </el-button>
        </el-form>

      </div>

    </div>
</div>
</template>

<script>
export default {
  data () {
    var checkPwd = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('密码不能为空'))
        //! !!传入后台比对部分待填写
      } else {
        if (value.length < 6 || value.length > 15) {
          callback(new Error('密码的长度为6-12位'))
        } else {
          callback()
        }
      }
    }
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else if (value.length < 6 || value.length > 15) {
        callback(new Error('密码的长度为6-12位'))
      } else {
        if (this.registerForm.confirmPwd !== '') {
          this.$refs.registerForm.validateField('confirmPwd')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.registerForm.newPwd) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      back: require('../../assets/login.jpg'),
      logo: require('../../assets/logo.png'),
      registerForm: {
        phonenumber: '',
        password: '',
        confirmPwd: ''
      },
      registermRules: {
        newPwd: [{ validator: validatePass, trigger: 'blur' }],
        confirmPwd: [{ validator: validatePass2, trigger: 'blur' }],
        oldPwd: [{ validator: checkPwd, trigger: 'blur' }]
      }

    }
  },
  methods: {
    register () {
    }
  }
}

</script>

<style>
*{
    padding: 0;
    margin: 0;
}
.left{
    margin-right: 100px;
    height: 100px;
}
.right{
    position: absolute;
    right: 0px;
}
#line{
  position: absolute;
  top:200px;
  left: 200px;
}
#logo{
    position: absolute;
    top: 85px;
    left: 200px;
}
#txt{
    position: absolute;
    left: 325px;
    top: 125px;

}
#loginform{
    width: 400px;
    position: absolute;
    top: 275px;
    left: 250px;
}

.el-form-item {
    margin-bottom: 35px;
}
#register{
    position: relative;
    top: 400px;
    left:-70px;
}

    </style>
