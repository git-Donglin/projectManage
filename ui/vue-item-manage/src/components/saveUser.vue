<template>
    <div >
        <el-form :model="user" :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
            
            <el-form-item label="名称" prop="name">
                <el-input v-model="user1.name"></el-input>
            </el-form-item>

            <el-form-item label="年龄" prop="age">
                <el-input v-model="user1.age"></el-input>
            </el-form-item>

            <el-form-item label="手机号" prop="phone">
                <el-input v-model="user1.phone"></el-input>
            </el-form-item>

            <el-form-item label="地址" prop="address">
                <el-input v-model="user1.address"></el-input>
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
                <el-input v-model="user1.email"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="pwd">
                <el-input v-model="user1.pwd"></el-input>
            </el-form-item> 
            
            <el-form-item label="活动区域" prop="deptName">
                <el-select v-model="user1.deptName" placeholder="请选择活动区域">
                    <el-option v-for="(dept, index) in depts" :label="dept.name" :value="dept.name"/>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('user')">保存</el-button>
                <el-button @click="resetForm('user')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
    
</template>




<script>

export default {
name: "putUser",
data () {
    return {
            user1:{
                id:"",
                name:"123",
                age:"",
                address:"",
                phone:"",
                email:"",
                pwd:"",
                create:"",
                deptName:""
                
            },
            dept:{
                id : "",
                name : ""
            },
            depts:[],
        }
    },
    props: {user:{}},
    mounted : function(){
      //加载用户信息；
      // this.getDepts();
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.put(
            this.baseUrl + '/putUser/?Id=' + this.user.userId,
            this.user
          )
          .then((res) => {   //成功的回调
            this.$notify({
                  title: '成功',
                  message: '修改成功！',
                  type: 'success'
                });
            this.$emit("closePutUser","");
          })
          .catch((res) => {  //失败的回调
            this.msg = this.msg - 1;
            console.log(res);
          });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      getUser : function(index, row){
        this.user.id = row.userId;
        this.$http.get(
                this.baseUrl + '/getUserById/' + row.userId
            )
            .then((res) => {   //成功的回调
                this.$message({
                message: '获取用户成功！',
                type: 'success'
                });
                user.name = res.data.name;
                this.user.age = res.data.age;
                this.user.phone = res.data.phone;
                this.user.pwd = res.data.pwd;
                this.user.email = res.data.email;
                this.user.address = res.data.address;
                //return this.ogjs;
                console.log(this.ogjs);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
    
        },
        getDepts : function(){
            this.$http.get(
                this.baseUrl + '/dept/getAllDept'
            )
            .then((res) => {   //成功的回调
                this.depts = res.data;
            })
            .catch((res) => {  //失败的回调
                console.log(res);
            });
        },
      resetForm : function(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

