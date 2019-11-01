<template>
  <div id = "login">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号" prop="account">
            <el-input v-model="ruleForm.account">孙东林</el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" autocomplete="off">kd123456</el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
        </el-form>
      
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
export default {
    data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('账号不能为空'));
        }
      };
      var validatePass = (rule, value, callback) => {
         if (!value) {
          return callback(new Error('密码不能为空'));
        }
      };
      return {
        ruleForm: {
            account: '123',
            password: '123'
        },
        userToken: '',
        rules: {
          password: [
            { required: true, message: '密码不能为空', trigger: 'change' }
          ],
          account: [
              { required: true, message: '账号不能为空', trigger: 'change' }
          ]
        }
      };
    },
    methods: {
      ...mapMutations(['changeLogin']),
      submitForm(formName) {
        let _this = this;
        this.$refs[formName].validate((valid) => {
            var then = this;
          if (valid) {
                var qs = require('qs');
                var params = new URLSearchParams();
                params.append('account', this.ruleForm.account);
                params.append('password', this.ruleForm.password);
                this.$http.post(
                    this.baseUrl + '/login',
                    params
                    )
                    .then((res) => {   //成功的回调
                        var mess = "登录成功";                     
                        this.$notify({
                            title: '成功',
                            message: mess,
                            type: 'success'
                        });
                        // 将用户token保存到vuex中
                        _this.changeLogin({ Authorization: res.data.data});
                        _this.$router.push('/home');
                    })
                    .catch((res) => {  //失败的回调
                        this.msg = this.msg - 1;
                        console.log(res.response);
                    });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style>

#login{
    
    width: 400px;
    position: absolute;
    top: 352px;
    left: 624px;
   
    /* background: url("C:\Users\admin\Desktop\11.jpeg") no-repeat 0 0; */
}
body{
     background-color: bisque;
}
</style>
