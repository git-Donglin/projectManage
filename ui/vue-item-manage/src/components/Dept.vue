<template>
  <div id = "user">
    <el-button id="saveUser" v-on:click="openSaveUser" type="primary" plain >添加</el-button>
      <el-table :data="ogjs" class="el-table1">
         <el-table-column
          label="部门编号"
          width="600">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>编号: {{ scope.row.id }}</p>
              <p>名称: {{ scope.row.name }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.id }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="部门名称"
          width="600">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>编号: {{ scope.row.id }}</p>
              <p>名称: {{ scope.row.name }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.name }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
            <!-- <el-button
              size="mini"
              @click="getUser(scope.$index, scope.row)">编辑</el-button> -->
              <el-button type="primary" icon="el-icon-edit" circle
              @click="openUpdate(scope.$index, scope.row)" disabled></el-button>
            <!-- <el-button
              size="mini"
              type="danger"
              @click="delUserOpen(scope.$index, scope.row)">删除</el-button> -->
              <el-button type="danger"
               icon="el-icon-delete" circle
               @click="delDeptOpen(scope.$index, scope.row)" disabled></el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog :title="this.info" :visible.sync="dialogTableVisible">
    
          <PutDept ref="mychild" v-on:closePutUser="closePutUser"/>
      
      </el-dialog>
      
  </div>
</template>

<script>
import PutDept from './putDept';
export default {
    components: {  
        // testComponent:require('./putUser.vue').default ,
        // Putuser
        PutDept
    }, 

    data () {
        return {
            info:"",
            msg: 7,
            ogjs: [],
            users: {},
            putbln : false,
            dialogTableVisible: false,
            dialogFormVisible: false,
            formLabelWidth: '120px'
        }
    },
    mounted : function(){


      //加载用户信息；
       this.getDeptAll();
    },
    methods:{
      // 获取所有的用户信息
        getDeptAll : function(){
          console.log( this.baseUrl + '/dept/getAllDept');
            this.$http.get(
                this.baseUrl+'/dept/getAllDept'
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
        // 子级回调，关闭修改框并重新加载用户信息
        closePutUser: function(index, row){
          this.dialogTableVisible = false;
          this.getDeptAll();
        },
        //添加用户信息
        openSaveUser : function(){
          this.dialogTableVisible = true;
          this.user = {};
          this.type = "save";
           this.info = "添加部门";
            this.$notify({
              title: '消息',
              message: '添加部门',
              type: 'info'
            });
        },
        // 获取用户信息(修改)
         openUpdate : function(index, row){
           this.info = "部门编辑";
            this.$notify({
              title: '消息',
              message: '部门编辑',
              type: 'info'
            });
            this.dialogTableVisible = true;
            this.$http.get(
               this.baseUrl + '/getUserById/' + row.userId
            )
            .then((res) => {   //成功的回调
              this.$refs.mychild.getUser(index, row);
              // this.user = res.data;
              // this.optionDefault = res.data.deptname;
              // console.log( this.user);
            })
            .catch((res) => {  //失败的回调
              this.msg = this.msg - 1;
              console.log(res);
            });
        },
        // 删除用户信息
        delDept : function(index, row){
            this.$http.delete(
                 this.baseUrl + '/delUser/{Id}?Id=' + row.userId
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

        delDeptOpen(index, row) {
            this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {

              delDept(index, row);           
            }).catch(() => {
              this.$notify.info({
                title: '消息',
                message: '已取消删除'
              });         
            });
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
/* .cell{
  width: 147px;
} */
</style>
