<template>
  <div id = "user">
    <el-button id="saveUser" v-on:click="openSaveFunction" type="primary" plain class="saveUser">添加</el-button>
      <el-table :data="ogjs" class="el-table1">

        <el-table-column
          label="功能简介"
          width="180">
          <template slot-scope="scope">
             <span style="margin-left: 10px">{{ scope.row.name }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="功能周期"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.period }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="所属项目"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.itemName }}</span>
          </template>
        </el-table-column>

        
        <el-table-column
          label="功能波及"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.affect }}</span>
          </template>
        </el-table-column>

        <el-table-column
          label="功能负责人"
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
            <PutFunction ref="mychild" v-on:closePutFunction="closePutFunction"/>
        </el-dialog>
      
  </div>
</template>

<script>
import PutFunction from './putFunction';
export default {
    components: {  
        testComponent:require('./putFunction.vue').default ,
        PutFunction
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
       this.getUserAll();
    },
    methods:{
      // 获取所有的用户信息
        getUserAll : function(){
            this.$http.get(
                this.baseUrl + '/functionApi/queryAll'
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
        closePutFunction: function(index, row){
          this.dialogTableVisible = false;
          this.getUserAll();
        },
        //添加功能信息
        openSaveFunction : function(){
          this.dialogTableVisible = true;
          this.user = {};
          this.type = "save";
           this.info = "新增功能";
            this.$notify({
              title: '消息',
              message: '添加功能',
              type: 'info'
            });
            this.$refs.mychild.getDepts();
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
             this.$refs.mychild.getDepts();
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
                this.baseUrl + '/functionApi/delFunction/{moid}?moid=' + row.moid
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
