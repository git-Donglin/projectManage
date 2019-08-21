<template>
    <div >
        <el-form :model="dz_function" :rules="rules" ref="dz_function" label-width="100px" class="demo-ruleForm">
            
            <el-form-item label="功能名称" prop="name">
                <el-input v-model="dz_function.name" placeholder="请输入功能名称"></el-input>
            </el-form-item>

            <el-form-item label="功能波及" prop="affect">
                <el-input v-model="dz_function.affect" placeholder="请输入功能地址"></el-input>
            </el-form-item>

            <el-form-item label="功能周期" prop="period">
                <el-input v-model="dz_function.period" placeholder="请输入功能周期（天）"></el-input>
            </el-form-item>

            <el-form-item label="功能负责人" prop="principal">
                <el-input v-model="dz_function.principal" placeholder="请输入功能负责人"></el-input>
            </el-form-item> 
            <!-- <el-form-item v-if="item.moid != ''" label="项目完成内容" prop="2">
                <el-input v-model="item.pwd" type="textarea" :rows="2" placeholder="请输出项目内容"></el-input>
            </el-form-item>  -->
            <el-form-item label="功能描述" prop="describe">
                <el-input v-model="dz_function.describe" type="textarea" :rows="2" placeholder="请输入功能描述"></el-input>
            </el-form-item> 
            
            <el-form-item  label="项目状态" prop="state" style="display: inline-block;">
                <el-select v-model="dz_function.state">
                    <el-option  :label="'创建'" :value="0"/>
                    <el-option  :label="'开发中'" :value="1"/>
                    <el-option  :label="'测试中'" :value="2"/>
                    <el-option  :label="'完成'" :value="3"/>
                </el-select>
            </el-form-item>

             <el-form-item  label="所属项目" prop="itemName" style="display: inline-block;">
                <el-select v-model="dz_function.itemName">
                     <el-option v-for="(item, index) in items"  :label="item.name" :value="item.moid"/>
                </el-select>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('dz_function')">保存</el-button>
                <el-button @click="resetForm('dz_function')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>


<script>
    export default {
        name: "putFunction",
        data () {
            return {
                dz_function:{
                    id:"",
                    moid:"",
                    itemMoid:"",
                    state:"",
                    name:"",
                    period:"",
                    principal:"",
                    content:"",
                    describe:"", 
                    createTime:"",
                    affect:""  ,
                    itemName:""           
                },
                saveOrpdate:"",
                items:[],
                rules: {
                    name: [
                        { required: true, message: '请输入功能名称', trigger: 'blur' }
                    ],
                    // affect: [
                    //     { required: true, message: '请输入功能波及', trigger: 'blur' }
                    // ],
                    // version: [
                    //     { required: true, message: '请输入项目版本', trigger: 'blur' } 
                    // ],
                    principal: [
                        { required: true, message: '请输入功能负责人', trigger: 'blur' }
                    ]
                }
            }
        },
        props: {},
        mounted : function(){
        //加载用户信息；
        this.getDepts();
        },
        methods: {
            setItemMoid(index, row){
                this.dz_function.itemMoid = row.itemMoid;
            },
            // 添加或修改
            submitForm(formName) {
                 this.dz_function.itemMoid =  this.dz_function.itemName;
                this.$refs[formName].validate((valid) => {
                if (valid) {
                    if(this.dz_function.moid == ""){
                        this.$http.post(
                        this.baseUrl + '/functionApi/saveFunction',
                        this.dz_function
                        )
                        .then((res) => {   //成功的回调
                            this.$notify({
                                title: '成功',
                                message: '添加成功！',
                                type: 'success'
                            });
                            this.$emit("closePutFunction","");
                        })
                        .catch((res) => {  //失败的回调
                            this.msg = this.msg - 1;
                            console.log(res);
                        });
                    }else if(this.saveOrpdate != ""){
                    this.$http.put(
                        this.baseUrl + '/functionApi/putFunction/?Id=' + this.dz_function.moid,
                        this.dz_function
                        )
                        .then((res) => {   //成功的回调
                            this.$notify({
                                title: '成功',
                                message: '修改成功！',
                                type: 'success'
                            });
                            this.$emit("closePutFunction","");
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
            getUser : function(index, row, type){
                if(type == 1){
                    
                }
                this.$http.get(
                     this.baseUrl + '/functionApi/getFunctionById/' + row.moid
                )
                .then((res) => {   //成功的回调
                    this.dz_function.id = res.data.id;
                    this.dz_function.moid = res.data.moid;
                    this.dz_function.name = res.data.name;
                    this.dz_function.state = res.data.state;
                    this.dz_function.period = res.data.period;
                    this.dz_function.principal = res.data.principal;
                    this.dz_function.affect = res.data.affect;
                    this.dz_function.content = res.data.content;
                    this.dz_function.describe = res.data.describe;
                    this.dz_function.createTime = res.data.createTime;
                    this.dz_function.itemMoid = res.data.itemMoid;
                    this.dz_function.itemName = res.data.itemName;
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
                if(this.items.length > 0){
                    for(var key in this.user){
                        this.user[key] = '';
                    }
                    this.saveOrpdate = "save";
                    this.resetForm('dz_function');
                    this.dz_function.deptName = this.items[0].name;
                    return;
                }
                this.$http.get(
                   this.baseUrl + '/itemApi/queryAll'
                )
                .then((res) => {   //成功的回调
                    this.items = res.data;
                    this.user.deptName = res.data[0].name;
                })
                .catch((res) => {  //失败的回调
                    console.log(res);
                });
            },
            // 重置
            resetForm : function(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

