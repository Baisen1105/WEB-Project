<template>
<div class="wrap">
    <div class="right">
      <img :src="back" style="width: 700px ;height:850px">
    </div>
    <div class="left">
      <img :src="logo" style="width:100px" id="logo">
      <span id="txt"><font size="6" color="green">登录</font></span>
      <div id="line">
        <hr style="width:600px; height:3px; green"/>
      </div>
      <div id="loginform" style="width:500px;" >
        <el-form :model="loginForm" :rules="loginFormRules" ref="loginFormRef">
          <el-form-item style="margin-bottom:50px">
            <el-input prefix-icon="el-icon-user" placeholder="账号" v-model="loginForm.phonenumber">
            </el-input>
          </el-form-item>
          <el-form-item prop="password" style="margin-bottom:50px">
            <el-input
              placeholder="密码"
              prefix-icon="el-icon-lock"
              v-model="loginForm.password"
            ></el-input>
          </el-form-item>
          <el-button style="width:500px;" type="success" @click="login('loginForm')">
            登录
          </el-button>
        </el-form>

      </div>
      <div id="register">
        <span id="txt"><font size="3">还未注册？</font><font size="3" color="green" @click="register()">立即注册</font></span>
      </div>

    </div>
</div>
</template>

<script>
export default {
  data () {
    return {
      back: require('../../assets/login.jpg'),
      logo: require('../../assets/logo.png'),
      loginForm: {
        phonenumber: '',
        password: ''
      },
      loginFormRules: {
        phonenumber: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {
            required: true,
            min: 3,
            max: 11,
            trigger: 'change'
          }
        ],
        password: [
          { min: 6, max: 15, message: '请输入6-15位的密码', trigger: 'change' },
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }

    }
  },
  methods: {
    login () {
      this.$refs.loginFormRef.validate((valid) => {
        console.log(valid)
        sessionStorage.setItem('isLogin', 'true')
        sessionStorage.setItem('account', this.loginForm.phonenumber)
        this.$router.push('/home')
        // sessionStorage.setItem('username', res.data.readername)
        /* if (valid) {
          const params = new URLSearchParams()
          params.append('account', this.loginForm.phonenumber)
          params.append('password', this.loginForm.password)
          this.$axios
            .post('http://39.105.26.66:8888/reader/login', params)
            .then((res) => {
              console.log(res)
              if (res.data.code == '001') {
                sessionStorage.setItem('isLogin', 'true')
                sessionStorage.setItem('account', this.loginForm.phonenumber)
                sessionStorage.setItem('username', res.data.readername)
                this.isLogin = sessionStorage.getItem('isLogin')
              } else {
                switch (res.data.code) {
                  case '000':
                    alert('用户不存在')
                    break
                  case '002':
                    alert('密码错误')
                    break
                  case '003':
                    alert('后台服务异常')
                    break
                  case '004':
                    alert('获取用户名异常')
                }
              }
            })
            .catch(function (error) {
              console.log(error)
            })
        } else {
          alert('请输入正确格式的账号密码')
        } */
      })
    },
    register () {
      this.$router.push('/register')
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
