<template>
  <div class="login-container">
    <div class="login-background"></div>
    <div class="login-box">
      <h2 class="login-title">欢迎登录</h2>
      <el-form
        :model="loginForm"
        :rules="rules"
        ref="loginForm"
        label-width="100px"
        class="login-form"
      >
        <el-form-item label="用户名" prop="username">
          <el-input
            v-model="loginForm.username"
            prefix-icon="el-icon-user"
            autocomplete="off"
            class="input-with-focus"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="loginForm.password"
            prefix-icon="el-icon-lock"
            autocomplete="off"
            class="input-with-focus"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            @click="submitForm('loginForm')"
            class="login-button">登录
            </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>  
  
<script>
import axios from "axios";
export default {
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .post("http://localhost:8080/login", this.loginForm)
            .then((e) => {
              if (e.data.code === 1) {
                this.$alert("登陆成功","" ,{confirmButtonText: "确定",})
                this.$store.commit('setJwt',e.data.data)
                this.$router.push('/container/studentList')
                console.log(e.data);
              } else {
                this.$alert("用户名或密码错误", "", {confirmButtonText: "确定",});
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>  
  
<style scoped>
.login-container {
  position: relative;
  width: 100%;
  height: 100vh;
  overflow: hidden;
}

.login-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: center;
  z-index: -1;
  filter: blur(8px);
}

.background-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 360px;
  padding: 40px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  background-color: rgba(
    255,
    255,
    255,
    0.9
  );
  border-radius: 12px;
  text-align: center;
  z-index: 1;
}

.login-title {
  margin-bottom: 24px;
  font-size: 28px;
  font-weight: bold;
  color: #333;
}

.login-form .el-form-item {
  margin-bottom: 24px;
}

.input-with-focus {
  transition: box-shadow 0.3s;
}

.input-with-focus:focus {
  box-shadow: 0 0 5px rgba(82, 192, 255, 0.6);
}

.login-button {
  width: 100%;
  font-size: 18px;
  border-radius: 6px;
  background-color: #409eff;
  border-color: #409eff;
  transition: background-color 0.3s, border-color 0.3s;
}

.login-button:hover {
  background-color: #66b1ff; 
  border-color: #66b1ff;
}

.extra-links {
  margin-top: 24px;
  text-align: center;
}

.register-link {
  color: #409eff;
  text-decoration: none;
  transition: color 0.3s;
}

.register-link:hover {
  color: #66b1ff;
}
</style>