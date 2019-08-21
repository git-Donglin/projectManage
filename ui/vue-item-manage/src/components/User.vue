<template>
  <div id = "user">
    <el-button id="saveUser" v-on:click="openSaveUser" type="primary" plain class="saveUser">添加</el-button>
      <el-table :data="ogjs" class="el-table1" @expand-change = "rowClick" ref="table" row-key="moid" :row-key='getRowKeys'
          :expand-row-keys="expands">

          <!-- 功能子级 -->
         <el-table-column type="expand" width="80">
           <!-- <el-button id="saveFunction" v-on:click="openFunction" type="primary" plain class="saveFunction">添加</el-button> -->
            <template slot-scope="scope1">
          <el-table
            :data="functions"
             ref="multipleTable"
            style="width: 100%; left:158px; top: -20px;" size="mini">

            <el-table-column
              label="功能简介"
              width="130">
              <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.name }}</span>
              </template>
            </el-table-column>

            <el-table-column
              label="周期"
              width="180" >
              <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.period }}</span>
              </template>
            </el-table-column>

            <el-table-column
              label="波及"
              width="180">
              <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.affect }}</span>
              </template>
            </el-table-column>

            <el-table-column
              label="负责人"
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
              label="日期"
              width="180">
              <template slot-scope="scope">
                <i class="el-icon-time"></i>
                <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
              </template>
            </el-table-column>

            <el-table-column label="操作" width="150">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="openUpdate(scope.$index, scope.row)">查看</el-button>
                <!-- <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button> -->
              </template>
            </el-table-column>
          </el-table>
            </template>
        </el-table-column>

        <el-table-column
          label="项目姓名"
          width="180">
          <template slot-scope="scope">
             <span style="margin-left: 10px">{{ scope.row.name }}</span>
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
export default {
    components: {  
        testComponent:require('./putUser.vue').default ,
        Putuser,
        testComponent:require('./putFunction.vue').default ,
        PutFunction
    }, 

    data () {
        return {
            info:"",
            msg: 7,
            ogjs: [],
            functions: [],
            users: {},
            putbln : false,
            dialogTableVisible: false,
            dialogTableVisible1:false,
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
        getFunctionAll : function(itemMoid){
           this.$http.get(
                this.baseUrl + '/functionApi/getFunctionByItemMoid/{moid}?moid=' + itemMoid
            )
            .then((res) => {   //成功的回调
                this.msg = this.msg + 1;
                this.functions = res.data;
                console.log(this.functions);
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
          this.getUserAll();
        },
        //添加用户信息
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
        // 获取用户信息(修改)
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
        // 删除用户信息
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

      //添加功能信息
        openFunction : function(){
          this.dialogTableVisible1 = true;
          this.user = {};
          this.type = "save";
           this.info = "新增功能";
            this.$notify({
              title: '消息',
              message: '添加功能',
              type: 'info'
            });
            //this.$refs.mychildFunction.setItemMoid(index, row);
             this.$refs.multipleTable.setCurrentRow(row);
              console.log(row.moid);
        },
        // 获取用户信息(修改)
         openUpdate : function(index, row){
           this.info = "功能编辑";
            this.$notify({
              title: '消息',
              message: '功能编辑',
              type: 'info'
            });
            this.dialogTableVisible = true;
            this.$http.get(
              this.baseUrl + '/functionApi/getFunctionById/' + row.moid
            )
            .then((res) => {   //成功的回调
             this.$refs.PutFunction.getDepts();
              this.$refs.PutFunction.getUser(index, row, type);
            })
            .catch((res) => {  //失败的回调
              this.msg = this.msg - 1;
              console.log(res);
            });
        },
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
.cell{
  width: 100%;
}

</style>
