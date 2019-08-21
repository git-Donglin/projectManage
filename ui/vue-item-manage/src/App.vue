<template>
  <div id="app">
  <!-- <span class="">swagger</span> -->
    <div class="from">
        <el-form :model="user" :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
            
            <el-form-item label="账号" prop="name">
                <el-input v-model="user.name"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="age">
                <el-input v-model="user.age"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('user')">立即创建</el-button>
                <el-button @click="resetForm('user')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {

data () {
  const httpUrl = 'http://39.105.17.99:8080/';
    return {
    
      user: {
        name: "",
        age: ""
      } 
    }
  },
  methods:{

    putUser : function(){
      this.$router.push('/putUser')
      //window.location.href = "/putUser";
    },
    getUserAll : function(){
         
      this.$http.get(
            'http://localhost:8081/queryAll'
          )
          .then((res) => {   //成功的回调
            this.msg = this.msg + 1;
            this.ogjs = res.data;
            this.$message({
              message: '登录成功！',
              type: 'success'
            });
            console.log(this.ogjs);
          })
          .catch((res) => {  //失败的回调
            this.msg = this.msg - 1;
            console.log(res);
          });
 
    },
     getUser : function(index, row){
         
      this.$http.get(
            'http://localhost:8081/getUserById/' + row.userId
          )
          .then((res) => {   //成功的回调
            this.$message({
              message: '获取用户成功！',
              type: 'success'
            });
            console.log(this.ogjs);
          })
          .catch((res) => {  //失败的回调
            this.msg = this.msg - 1;
            console.log(res);
          });
 
    },
    delUser : function(index, row){
        this.$http.delete(
            'http://localhost:8081/delUser/2'

          )
          .then((res) => {   //成功的回调
            this.$message({
              message: '删除成功！',
              type: 'success'
            });
          })
          .catch((res) => {  //失败的回调
            this.msg = this.msg - 1;
            console.log(res);
          });
    }
  }
}
</script>

<style>
#app{
  width: 100%;
  height:100%;
  /* background-image:url(./assets/bj.jpg); background-repeat:no-repeat; background-size:100% 100%;-moz-background-size:100% 100%; */
}
.from{
  display: none;
  width: 350px;
}
html,body{margin: 0;}
html,body{height:100%;width: 100%;}

</style>
