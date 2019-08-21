<template>
    <div >
        <el-form :model="item" :rules="rules" ref="item" label-width="100px" class="demo-ruleForm">
            
            <el-form-item label="项目名称" prop="name">
                <el-input v-model="item.name" placeholder="请输出项目名称"></el-input>
            </el-form-item>

            <el-form-item label="项目地址" prop="address">
                <el-input v-model="item.address" placeholder="请输出项目地址"></el-input>
            </el-form-item>

            <!-- <el-form-item label="项目周期" prop="period">
                <el-input v-model="item.period" placeholder="请输出项目周期（天）"></el-input>
            </el-form-item> -->

            <el-form-item label="项目负责人" prop="principal">
                <el-input v-model="item.principal" placeholder="请输出项目负责人"></el-input>
            </el-form-item> 
            <!-- <el-form-item v-if="item.moid != ''" label="项目完成内容" prop="2">
                <el-input v-model="item.pwd" type="textarea" :rows="2" placeholder="请输出项目内容"></el-input>
            </el-form-item>  -->
            <el-form-item label="项目描述" prop="describe">
                <el-input v-model="item.describe" type="textarea" :rows="2" placeholder="请输出项目描述"></el-input>
            </el-form-item> 
            
            <!-- <el-form-item  label="项目状态" prop="state" style="display: inline-block;">
                <el-select v-model="item.state">
                    <el-option  :label="'创建'" :value="0"/>
                    <el-option  :label="'开发中'" :value="1"/>
                    <el-option  :label="'测试中'" :value="2"/>
                    <el-option  :label="'完成'" :value="3"/>
                </el-select>
            </el-form-item> -->
            <el-form-item  label="项目版本" prop="version" style="display: inline-block;">
                <el-select v-model="item.version">
                    <el-option  :label="'5.0Sp3'" :value="'5.0Sp3'"/>
                    <el-option  :label="'5.1Sp2'" :value="'5.1Sp2'"/>
                    <el-option  :label="'5.1Sp3'" :value="'5.1Sp3'"/>
                    <el-option  :label="'5.1Sp4'" :value="'5.1Sp4'"/>
                    <el-option  :label="'5.2Sp2'" :value="'5.2Sp2'"/>
                    <el-option  :label="'5.2Sp4'" :value="'5.2Sp4'"/>
                    <el-option  :label="'6.0Sp2'" :value="'6.0Sp2'"/>
                </el-select>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('item')">保存</el-button>
                <el-button @click="resetForm('item')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>


<script>
    export default {
        name: "putUser",
        data () {
            return {
                item:{
                    id:"",
                    moid:"",
                    name:"",
                    address:"",
                    state:"",
                    period:"",
                    principal:"",
                    content:"",
                    describe:"", 
                    createTime:"",
                    version:""             
                },
                saveOrpdate:"",
                depts:[],
                rules: {
                    name: [
                        { required: true, message: '请输入项目名称', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请输入项目地址', trigger: 'blur' }
                    ],
                    // version: [
                    //     { required: true, message: '请输入项目版本', trigger: 'blur' } 
                    // ],
                    principal: [
                        { required: true, message: '请输入项目负责人', trigger: 'blur' }
                    ]
                }
            }
        },
        props: {},
        mounted : function(){
        //加载用户信息；
        //this.getDepts();
        },
        methods: {
            // 添加或修改
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                if (valid) {
                    if(this.item.id == ""){
                        this.$http.post(
                        this.baseUrl + '/itemApi/saveItem',
                        this.item
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
                    }else if(this.saveOrpdate != ""){
                    this.$http.put(
                        this.baseUrl + '/itemApi/putItem/?Id=' + this.item.moid,
                        this.item
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
                    }
                

                } else {
                    console.log('error submit!!');
                        return false;
                    }
                });
            },
            // 获取修改的数据
            getUser : function(index, row){
                this.item.id = row.id;
                this.$http.get(
                    this.baseUrl + '/itemApi/getItemById/' + row.moid
                )
                .then((res) => {   //成功的回调
                    this.item.id = res.data.id;
                    this.item.moid = res.data.moid;
                    this.item.name = res.data.name;
                    this.item.state = res.data.state;
                    this.item.period = res.data.period;
                    this.item.principal = res.data.principal;
                    this.item.address = res.data.address;
                    this.item.content = res.data.content;
                    this.item.describe = res.data.describe;
                    this.item.createTime = res.data.createTime;
                    this.item.version = res.data.version;
                    this.saveOrpdate = "update";


                    console.log(this.ogjs);
                })
                .catch((res) => {  //失败的回调
                    this.msg = this.msg - 1;
                    console.log(res);
                });
        
            },
            // 加载部门信息
            getDepts : function(){

                this.saveOrpdate = "save";
                this.resetForm('item');
                // this.$http.get(
                //     'http://localhost:8081/dept/getAllDept'
                // )
                // .then((res) => {   //成功的回调
                //     this.depts = res.data;
                //     this.user.deptName = res.data[0].name;
                // })
                // .catch((res) => {  //失败的回调
                //     console.log(res);
                // });
            },
            // 重置
            resetForm : function(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

