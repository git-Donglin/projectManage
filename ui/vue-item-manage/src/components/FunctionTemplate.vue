<template>
  <div class="hello">
          <el-table
            :data="ogjs"
             ref="multipleTable"
            style="width: 100%" size="mini">

            <el-table-column
              label="功能简介"
              width="130">
              <template slot-scope="scope">
                <span style="margin-left: 10px">{{ scope.row.name }}</span>
              </template>
            </el-table-column>

            <el-table-column
              label="周期"
              width="180">
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
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
       ogjs: []
    }
  },
  props: {},
  mounted : function(){
        //加载用户信息；
        //this.getAllFunction(itemMoid);
        },
        methods: {
          getAllFunction : function(itemMoid){
            this.$http.get(
                'http://localhost:8081/functionApi/getFunctionByItemMoid/{moid}?moid=' + itemMoid
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
          }
        }
}
</script>

<style scoped>
</style>
