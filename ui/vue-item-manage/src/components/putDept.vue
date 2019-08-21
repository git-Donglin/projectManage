<template>
    <div >
        <el-form :model="dept" :rules="rules" ref="dept" label-width="100px" class="demo-ruleForm">
            <el-form-item label="部门名称" prop="name">
                <el-input v-model="dept.name"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('dept')">保存</el-button>
                <el-button @click="resetForm('dept')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>


<script>
    export default {
        name: "putDept",
        data () {
            return {
                dept:{
                    id : "",
                    name : ""
                },
                saveOrpdate:"",
                depts:[],
                rules: {
                    name: [
                        { required: true, message: '请输入部门名称', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$http.post(
                    this.baseUrl + '/dept/saveDept',
                    this.dept
                    )
                    .then((res) => {   //成功的回调
                        this.$notify({
                            title: '成功',
                            message: '添加成功！',
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
            // 重置
            resetForm : function(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

