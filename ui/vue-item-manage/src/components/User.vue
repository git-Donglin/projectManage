<template>
  <div id = "user" style="background-color: white;">
    <div style="height: 100px;">
      <el-button id="saveUser" v-on:click="openSaveUser" type="primary" plain class="saveUser">添加</el-button>
    </div>
      <el-table
    :data="ogjs"
    style="width: 100%">
     <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="项目名称">
                <span>{{ props.row.name }}</span>
              </el-form-item>
              <el-form-item label="项目周期">
                <span>{{ props.row.period }}</span>
              </el-form-item>
              <el-form-item label="项目版本">
                <span>{{ props.row.version }}</span>
              </el-form-item>
              <el-form-item label="项目代码流">
                <span>{{ props.row.address }}</span>
              </el-form-item>
              <el-form-item label="项目负责人">
                <span>{{ props.row.principal }}</span>
              </el-form-item>
              <el-form-item label="状态">
                <span>{{ props.row.state }}</span>
              </el-form-item>
              <el-form-item label="开始时间">
                <span>{{ props.row.state }}</span>
              </el-form-item>
              <el-form-item label="结束时间">
                <span>{{ props.row.state }}</span>
              </el-form-item>
              <el-form-item label="创建时间">
                <span>{{ props.row.createTime }}</span>
              </el-form-item>
              <el-form-item label="项目描述" >
                <el-input
                  type="textarea"
                  style="width: 1000px;"
                  :autosize="{ minRows: 20, maxRows: 20 }"
                  placeholder="请输入内容"
                  v-model="props.row.describe">
                </el-input>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <div style="top:100px"></div>
    <el-table-column
          label="项目姓名"
          width="180">
          <template slot-scope="scope">
             <el-button  size="mini" @click="getItemDemandAll(scope.row.moid)" type="primary" style="margin-left: 16px;">
  {{ scope.row.name }}
</el-button>
          </template>
        </el-table-column>

        <el-table-column
          label="项目周期"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.period }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="项目版本"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.version }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="项目负责人"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.principal }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="状态"
          width="180">
          <template slot-scope="scope">
             <span style="margin-left: 10px">{{ scope.row.state }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="创建时间"
          width="180">
          <template slot-scope="scope">
             <i class="el-icon-time"></i>
             <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
          </template>
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit" circle
              @click="openUpdate(scope.$index, scope.row)"></el-button>
              <el-button type="danger"
               icon="el-icon-delete" circle
               @click="delUserOpen(scope.$index, scope.row)"></el-button>
          </template>
        </el-table-column>
  </el-table>


<el-drawer
  title="我是外面的 Drawer"
  :visible.sync="drawer"
  size="70%">
  <div>
   <el-button @click="innerDrawer = true">打开里面的!</el-button>

    
<el-button id="saveDemand1" size="mini" v-on:click="openSaveDemand(null,true)" type="primary" plain >添加</el-button>

<template>
  
  <el-table
    :data="itemDemands"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="createDate"
      label="创建日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="title"
      label="标题"
      style="width:auto;">
    </el-table-column>
    <el-table-column
      prop="startDate"
      label="开始时间"
      width="120">
    </el-table-column>
    <el-table-column
      prop="entDate"
      label="结束时间"
      width="120">
    </el-table-column>
    <el-table-column
      prop="principal"
      label="负责人"
      width="300">
    </el-table-column>
    <el-table-column
      prop="state"
      label="状态"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="300">
      <template slot-scope="scope">
        <el-button label="ltr" @click="openFunctionList(scope.row)"  type="text" size="small">功能查看</el-button>
        <el-button  @click="openSaveDemand(scope.row,false)" type="text" size="small">编辑</el-button>
        <el-button  @click="deleteDemand(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>





   <el-drawer
   size="50%"
   direction="ltr"
     title="我是里面的"
     :append-to-body="true"
     :before-close="handleClose"
     :visible.sync="innerDrawer">
     <p>_(:зゝ∠)_</p>
<el-button id="savefunction" size="mini" v-on:click="openSaveFunction()" type="primary" plain >添加</el-button>

      <el-table
    :data="functions"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="标题">
            <span>{{ props.row.name }}</span>
          </el-form-item>
          <el-form-item label="波及">
            <span>{{ props.row.affect }}</span>
          </el-form-item>
          <el-form-item label="负责人">
            <span>{{ props.row.principal }}</span>
          </el-form-item>
          <el-form-item label="状态">
            <span>{{ props.row.state }}</span>
          </el-form-item>
          <el-form-item label="开始时间">
            <span>{{ props.row.startData }}</span>
          </el-form-item>
          <el-form-item label="结束时间">
            <span>{{ props.row.entData }}</span>
          </el-form-item>
          <el-form-item label="创建时间">
            <span>{{ props.row.createTime }}</span>
          </el-form-item>
           <el-form-item label="内容">
            <span>{{ props.row.content }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column
      label="标题"
      prop="name">
    </el-table-column>
    <el-table-column
      label="波及"
      prop="affect">
    </el-table-column>
    <el-table-column
      label="负责人"
      prop="principal">
    </el-table-column>
    <el-table-column
      label="状态"
      prop="state">
    </el-table-column>
    <el-table-column
      label="开始时间"
      prop="startData">
    </el-table-column>
    <el-table-column
      label="结束时间"
      prop="endData">
    </el-table-column>
    <el-table-column
      label="创建时间"
      prop="createTime">
    </el-table-column>
    
  </el-table>

     
   </el-drawer>
  </div>
</el-drawer>



 <!-- 添加页面 -->
        <el-dialog :title="this.info" :visible.sync="saveDemandTableVisible">
            <SaveDemand ref="mychildDemand" v-on:closesaveDemand="closesaveDemand"/>
        </el-dialog>

        <!-- 修改页面 -->
        <el-dialog :title="this.info" :visible.sync="dialogTableVisible">
            <Putuser ref="mychild" v-on:closePutUser="closePutUser"/>
        </el-dialog>

        <!-- 查看页面 -->
        <el-dialog :title="this.info" :visible.sync="dialogTableVisible1">
            <PutFunction ref="mychildFunction" v-on:closePutFunction="closePutFunction"/>
        </el-dialog>

       
      
  </div>
</template>

<script>
import Putuser from './putUser';
import PutFunction from './putFunction';
import SaveDemand from './Item/saveDemand';
export default {
    components: {  
        testComponent:require('./putUser.vue').default ,
        Putuser,
        testComponent:require('./putFunction.vue').default ,
        PutFunction,
        testComponent:require('./Item/saveDemand.vue').default ,
        SaveDemand
    }, 

    data () {
        return {
          tableData: [{
          id: '12987122',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987123',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987125',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }, {
          id: '12987126',
          name: '好滋好味鸡蛋仔',
          category: '江浙小吃、小吃零食',
          desc: '荷兰优质淡奶，奶香浓而不腻',
          address: '上海市普陀区真北路',
          shop: '王小虎夫妻店',
          shopId: '10333'
        }],
            drawer: false,
            innerDrawer: false,
            info:"",
            msg: 7,
            ogjs: [],
            /**功能集合 */
            functions: [],
            /**用户集合 */
            users: {},
            /**需求集合 */
            itemDemands:[],
            /**项目集合 */
            itemMoid:"",
            /**需求moId */
            itemDemandMoid:"",
            putbln : false,
            dialogTableVisible: false,
            dialogTableVisible1:false,
            saveDemandTableVisible:false,
            dialogFormVisible: false,
            formLabelWidth: '120px',
            rowMoid:"",
            expands: [],
            getRowKeys (row) {
              return row.id
            },

            
           
        }
    },
    mounted : function(){


      //加载用户信息；
       this.getUserAll();
    },
    methods:{
      // 获取所有的用户信息
        getUserAll : function(){
            this.$http.get(
                this.baseUrl + '/itemApi/queryAll'
            )
            .then((res) => {   //成功的回调
                this.msg = this.msg + 1;
                this.ogjs = res.data;
                console.log(this.ogjs);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
    
        },
        deleteRow(index, rows) {
        rows.splice(index, 1);
      },
        over :function () {
                        alert(123123);   //弹出鼠标从我上面滑过,事件是[object MouseEvent]
        },
        rowClick : function(row, expandedRows){

          this.rowMoid = row.moid;
          this.getFunctionAll( row.moid);

          var that = this
            if (expandedRows.length) {
              that.expands = []
              if (row) {
                that.expands.push(row.id)
              }
            } else {
              that.expands = []
            }
        },
        //获取对应项目的需求
        getItemDemandAll : function(itemMoid){
          this.drawer = true;
          this.itemMoid = itemMoid;
           this.$http.get(
                this.baseUrl + '/itemDemandApi/listItemDemandByMoid/' + itemMoid
            )
            .then((res) => {   //成功的回调
                this.msg = this.msg + 1;
                this.itemDemands = res.data;
                console.log(this.itemDemands);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
        },
         //获取对应需求的功能
        openFunctionList : function(row){
          this.innerDrawer = true
          this.itemDemandMoid = row.moid;
          this.getFunctionAll(this.itemDemandMoid);
        },
        /**
         * 根据需求Id获取功能列表
         */
        getFunctionAll : function(demandMoid){
            this.$http.get(
                this.baseUrl + '/functionApi/getFunctionByItemMoid/' + demandMoid
            )
            .then((res) => {   //成功的回调
                this.msg = this.msg + 1;
                this.functions = res.data;
                console.log(this.itemDemands);
            })
            .catch((res) => {  //失败的回调
                this.msg = this.msg - 1;
                console.log(res);
            });
        },
        // 子级回调，关闭修改框并重新加载用户信息
        closePutUser: function(index, row){
          this.dialogTableVisible = false;
          this.getUserAll();
        },
        closePutFunction: function(index, row){
          this.dialogTableVisible1 = false;
          this.getFunctionAll(this.itemDemandMoid);
        },
        // 子级回调，需求列表加载
        closesaveDemand: function(index, row){
          this.saveDemandTableVisible = false;
          this.getItemDemandAll(this.itemMoid);
        },
        //添加项目信息
        openSaveUser : function(){
          this.dialogTableVisible = true;
          this.user = {};
          this.type = "save";
           this.info = "新增项目";
            this.$notify({
              title: '消息',
              message: '添加项目',
              type: 'info'
            });
            this.$refs.mychild.resetForm("item");
        },
        // 获取项目信息(修改)
         openUpdate : function(index, row){
           this.info = "项目编辑";
            this.$notify({
              title: '消息',
              message: '项目编辑',
              type: 'info'
            });
            this.dialogTableVisible = true;
            this.$http.get(
              this.baseUrl +'/getUserById/' + row.moid
            )
            .then((res) => {   //成功的回调
              this.$refs.mychild.getUser(index, row);
            })
            .catch((res) => {  //失败的回调
              this.msg = this.msg - 1;
              console.log(res);
            });
        },
        // 删除项目信息
        delUser : function(index, row){
            this.$http.delete(
                this.baseUrl + '/itemApi/delItem/{moid}?moid=' + row.moid
            )
            .then((res) => {   //成功的回调
                this.$notify({
                  title: '成功',
                  message: '删除成功',
                  type: 'success'
                });
                this.getUserAll();
            })
            .catch((res) => {  //失败的回调
                 this.$notify.error({
                  title: '错误',
                  message: res.state
                });
            });
        },

        delUserOpen(index, row) {
            this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {

              this.delUser(index, row);           
            }).catch(() => {
              this.$notify.info({
                title: '消息',
                message: '已取消删除'
              });         
            });
      },

      /**打开需求编辑页面 */
       openSaveDemand : function(row, demandBtl){
          this.saveDemandTableVisible = true;
          this.user = {};
          this.type = "save";
          if(demandBtl){
            this.info = "新增需求";
            this.$notify({
              title: '消息',
              message: '添加需求',
              type: 'info'
            });
          }else{
            this.info = "编辑需求";
            this.$notify({
              title: '消息',
              message: '编辑需求',
              type: 'info'
            });
          }

          this.$refs.mychildDemand.resetForm("itemDemand");
            if(null == row){
              this.$refs.mychildDemand.inintData(this.itemMoid, 0);
            }else{
              this.$refs.mychildDemand.inintData(row.moid, 1);
            }
           
//           setTimeout(() => {

//             this.$refs.mychildDemand.resetForm("itemDemand");
//             if(null == row){
//               this.$refs.mychildDemand.inintData(this.itemMoid, 0);
//             }else{
//               this.$refs.mychildDemand.inintData(row.moid, 1);
//             }
// 　　　　   }, 0)
        },

        deleteDemand : function(row){
           this.$confirm('此操作将永久删除该需求, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {

               this.$http.delete(
                this.baseUrl + '/itemDemandApi/deleteItemDemand/' + row.moid
            )
            .then((res) => {   //成功的回调
                this.$notify({
                  title: '成功',
                  message: '删除成功',
                  type: 'success'
                });
                this.getItemDemandAll(this.itemMoid);
            })
            .catch((res) => {  //失败的回调
                 this.$notify.error({
                  title: '错误',
                  message: res.state
                });
            });           
            }).catch(() => {
              this.$notify.info({
                title: '消息',
                message: '已取消删除'
              });         
            });
        },

      //添加功能信息
        openSaveFunction : function(){
          this.dialogTableVisible1 = true;
          this.user = {};
          this.type = "save";
           this.info = "新增功能";
            this.$notify({
              title: '消息',
              message: '新增功能',
              type: 'info'
            });
            setTimeout(() => {
              this.$refs.mychildFunction.resetForm("dz_function");
              this.$refs.mychildFunction.setItemMoid(this.itemDemandMoid);
　　　　     }, 0)
             //this.$refs.multipleTable.setCurrentRow(row);
              console.log(row.moid);
        },
        // 获取用户信息(修改)
         openUpdate : function(index, row){
           this.info = "项目编辑";
            this.$notify({
              title: '消息',
              message: '项目编辑',
              type: 'info'
            });
            this.dialogTableVisible = true;
            setTimeout(() => {
              this.$refs.mychild.getUser(index, row);
　　　　     }, 0)
        },
        putDemand(row) {

          console.log(row);
        }
    }
}
</script>

<style>

.el-dialog__header{
  line-height: 0px; 
}
.el-dialog{
  width: 800px;
}
#putUser{
      margin: 0 auto;
          width: 70%;
}

.saveDemand{
    position: absolute;
    top: 24px;
    left: 1449px;
    z-index: 1;
}

.demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
    font-size: 1px;
    display: block;
  }
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 0px;
}

</style>
