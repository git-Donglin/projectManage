<template>
    <div >
        <el-form :model="itemDemand" :rules="rules" ref="itemDemand" label-width="100px" class="demo-ruleForm">
            
            <el-form-item label="标题" prop="title">
                <el-input v-model="itemDemand.title"></el-input>
            </el-form-item>

            <el-form-item label="开始时间" prop="startDate">
              <el-col :span="11">
                <el-date-picker type="date" placeholder="选择日期" v-model="itemDemand.startDate" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>

            <el-form-item label="结束时间" prop="entDate">
              <el-col :span="11">
                <el-date-picker type="date" placeholder="选择日期" v-model="itemDemand.entDate" style="width: 100%;"></el-date-picker>
              </el-col>
            </el-form-item>

            <el-form-item label="负责人" prop="principal">
                <!-- <el-input v-model="itemDemand.principal"></el-input> -->
                <el-select v-model="principalArray" 
                      style="position: relative;   left: -218px;"
                    multiple
                    filterable
                    remote
                    reserve-keyword
                    placeholder="请输入负责人"
                    :remote-method="remoteMethod"
                    :loading="loading">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>


            </el-form-item>

            <el-form-item label="描述" prop="describe">
                <el-input type="textarea" v-model="itemDemand.describe"></el-input>
            </el-form-item> 
            
            <el-form-item label="状态" prop="state" >
                <el-select v-model="itemDemand.state" style="position: relative;   left: -218px;">
                    <!-- <el-option v-for="(dept, index) in depts" :label="dept.name" :value="dept.name" /> -->
                     <el-option label="新建" value="0"></el-option>
                     <el-option label="处理中" value="1"></el-option>
                     <el-option label="已完成" value="2"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('itemDemand')">保存</el-button>
                <el-button @click="resetForm('itemDemand')">重置</el-button>
            </el-form-item>
        </el-form>

    </div>
    
</template>




<script>

export default {
name: "saveDemand",
data () {
    return {
            itemDemand:{
                id:"",
                moid:"",
                state:"",
                title:"",
                describe:"",
                createDate:"",
                startDate:"",
                entDate:"",
                create:"",
                principal:"",
                itemMoid:""
                
            },
            /*添加 or 修改**/ 
            saveOrpdate:true,
            /*下拉框**/
            options: [],
            principalArray: [],
            list: [],
            loading: false,
            states: [],
            rules: {
                    title: [
                        { required: true, message: '请输入标题', trigger: 'blur' }
                    ],
                    startDate: [
                        { required: true, message: '请输入开始时间', trigger: 'blur' }
                    ],
                    entDate: [
                        { required: true, message: '请输入结束时间', trigger: 'blur' }
                    ],
                    principal: [
                        { required: true, message: '请输入负责人', trigger: 'blur' }
                    ]
                }
        }
    },
    props: {},
    mounted : function(){
      //加载用户信息；
      //this.getAlluser();
     
 this.list = this.states.map(item => {
        return { value: item, label: item };
      });

    },
    
    methods: {
      inintData(itemMoid){
        this.itemDemand.itemMoid = itemMoid;
        this.getAlluser();
        this.getDemand(itemMoid);
      },
      submitForm(formName) {
        this.checkData();
        this.$refs[formName].validate((valid) => {
          if (valid) {

            this.$http.post(
                    this.baseUrl + '/itemDemandApi/saveItemDemand',
                    this.itemDemand
                    )
                    .then((res) => {   //成功的回调
                        var mess = "添加成功";
                        if(!this.saveOrpdate){
                          mess = "修改成功";
                        }
                        this.$notify({
                            title: '成功',
                            message: mess,
                            type: 'success'
                        });
                        this.$emit("closesaveDemand","");
                    })
                    .catch((res) => {  //失败的回调
                        this.msg = this.msg - 1;
                        console.log(res.response);
                    });
            this.$emit("closePutUser","");
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      checkData(){
        var principalArray = this.itemDemand.principal;
        for(var principal in principalArray){
          this.itemDemand.principal = "," + principal;
        }
        this.itemDemand.principal = this.itemDemand.principal.substring(1,this.itemDemand.principal.length);
      },
      getDemand : function(itemMoid){
        this.saveOrpdate = false;
        this.$http.get(
                this.baseUrl + '/itemDemandApi/getItemDemandByMoid/' + itemMoid
            )
            .then((res) => {   //成功的回调
                this.itemDemand.id = res.data.id;
                this.itemDemand.moid = res.data.moid;
                this.itemDemand.state = res.data.state + "";
                this.itemDemand.title = res.data.title;
                this.itemDemand.describe = res.data.describe;
                this.itemDemand.createDate = res.data.createDate;
                this.itemDemand.startDate = res.data.startDate;
                this.itemDemand.entDate = res.data.entDate;
                this.itemDemand.principal = res.data.principal + "";
                this.itemDemand.itemMoid = res.data.itemMoid;

                this.principalArray = res.data.principal.split(',');
                //return this.ogjs;
                console.log(this.ogjs);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
    
        },

        /*初始化负责人信息**/
        getAlluser: function(){
           this.$http.get(
                this.baseUrl + '/queryAll'
            )
            .then((res) => {   //成功的回调
                this.ogjs = res.data;
                this.states = res.data;
                this.list = res.data.map(item => {
                  return { value: item.userId, label: item.name };
                });
                console.log(this.states);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
        },
        
      resetForm : function(formName) {
        this.principalArray = [];
        this.$refs[formName].resetFields();
      },
      remoteMethod(query) {
        if (query !== '') {
          this.loading = true;
          setTimeout(() => {
            this.loading = false;
            this.options = this.list.filter(item => {
              return item.label.toLowerCase()
                .indexOf(query.toLowerCase()) > -1;
            });
          }, 200);
        } else {
          this.options = [];
        }
      }
    }
  }
</script>

