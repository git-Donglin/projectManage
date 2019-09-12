<template>
    <div id = "home">
    <el-container class = "hieght100">
      <el-header>

        <transition enter-active-class="animated fadeInLeft" leave-active-class="animated fadeOutRight"> 
           <div id="header" style="">
            <span class="swagger" id = "swagger">定</span>
            <span class="swagger" id = "swagger1">制</span>
            <span class="swagger" id = "swagger2">管</span>
            <span class="swagger" id = "swagger3">理</span>
            <!-- <span class="swagger" id = "swagger4">g</span>
            <span class="swagger" id = "swagger5">e</span>
            <span class="swagger" id = "swagger6">r</span> -->
          </div>
        </transition>
           <button @click="flag=!flag">点击</button>
         
       
      </el-header>
      <el-container >

        <el-aside width="201px" id = "leftMenu">
            <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
              <el-radio-button :label="true">收起</el-radio-button>
              <el-radio-button :label="false">展开</el-radio-button>
            </el-radio-group>
            <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
              <el-submenu index="1" >
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span slot="title">报表统计</span>
                </template>
                <el-menu-item-group>
                  <!-- <span slot="title">分组一</span> -->
                  <el-menu-item index="1-1" @click = "openDeptList">周报列表</el-menu-item>
                </el-menu-item-group>
              </el-submenu>

              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span slot="title">项目管理</span>
                </template>
                <el-menu-item-group>
                  <!-- <span slot="title">分组一</span> -->
                  <el-menu-item index="1-1" @click = "getUser">项目列表</el-menu-item>
                </el-menu-item-group>
                 <el-menu-item-group>
                  <!-- <span slot="title">分组一</span> -->
                  <el-menu-item index="1-2" @click = "getFunction">功能列表</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          
        </el-aside>
        <el-main id="mainMenu">

          <!-- 部门列表 -->
          <div v-if="deptbln === true" id = "userCss"><DeptChild ref="mychild"></DeptChild></div>

          <!-- 用户列表 -->
          <div v-if="userbln === true" id = "userCss"><userChild ref="mychild"></userChild></div>

          <!-- 项目列表 -->
          <div v-if="functionln === true" id = "userCss"><FunctionChild ref="mychild"></FunctionChild></div>

        </el-main>
      </el-container>
    </el-container>


    </div>
</template>




<script>
  import UserChild from './User';
  import DeptChild from './Dept';
  import FunctionChild from './Function';
export default {
    components: {
        UserChild,DeptChild,FunctionChild
    }, 
name: "home",
 data() {
      return {
        isCollapse : false,
        userbln : false,
        deptbln : true,
        functionln : false,
        putUserbln : false,
        dialogTableVisible: false,
        flag:false
      };
    },
    methods: {
      // 部门列表

      openDeptList(){
        this.deptbln = true;
        this.userbln = false;
        this.functionln = false;
      },

      // 用户列表
      getUser(){
        this.deptbln = false;
        this.userbln = true;
        this.functionln = false;
      },
      hrefPut(){
        this.userbln = false;
        this.putUserbln = true;
      },
      getDept(){
        this.deptbln = true;
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      //功能列表
      getFunction(){
        this.deptbln = false;
        this.userbln = false;
        this.functionln = true;
      },

    }
  }
</script>
<style>
#header{
      margin-top: 14px;
}
#swagger{
    background-color: rgb(66, 142, 228);
    box-shadow: rgba(66, 142, 228, 0.5) 0px 6px 20px;
}

#swagger1{
        background-color: rgb(81, 147, 132);
    box-shadow: rgba(81, 147, 132, 0.5) 0px 6px 20px;
}
#swagger2{
      background-color: rgb(64, 33, 166);
    box-shadow: rgba(64, 33, 166, 0.5) 0px 6px 20px;
}
#swagger3{
      background-color: rgb(196, 79, 192);
    box-shadow: rgba(196, 79, 192, 0.5) 0px 6px 20px;
}
/* #swagger4{
    background-color: rgb(113, 0, 87);
    box-shadow: rgba(113, 0, 87, 0.5) 0px 6px 20px;
}
#swagger5{
      background-color: rgb(15, 36, 205);
    box-shadow: rgba(15, 36, 205, 0.5) 0px 6px 20px;
}
#swagger6{
      background-color: rgb(105, 17, 127);
    box-shadow: rgba(105, 17, 127, 0.5) 0px 6px 20px;
} */
.swagger{
    width: 50px;
    display: inline-block;
    height: 40px;
    border-radius: 10px;
    margin: 0 auto;
    color: rgb(243, 243, 243);
}

/* user */

#saveUser{
  position: absolute;
  top: 110px;
  left: 1784px;
  z-index: 1;
}
.saveUser{
  position: absolute;
  top: 110px;
  left: 1784px;
  z-index: 1;
}
.saveFunction{
  position: absolute;
    top: 42px;
    right: 40px;
  z-index: 1;
}
/* main居中 */
.el-table1{
  width: 100%;  height: 100%;
  margin:  0 auto;
}
.cell{
    text-align: center;
    margin:  0 auto;
}
/* 设置高度 */
  #home{
    height: 100%;
  }
  #leftMenu{
    height: 100%;
    height:100%;
  }
  #mainMenu{
    height: 100%;
    height:100%;
  }
  .hieght100{
    height: 100%;
  }
  .hieght100>* {
    height: 100%;
  }
   #userCss{
    height: 100%;
  }
  #user{
    height: 100%;
  }

  /* header */
  .el-header, .el-footer {
   background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 42px;
    font-weight: bold;
  }
  
  /* left */
  .el-aside {
   background-color: #E9EEF3;
    color: #333;
    text-align: center;
    /* line-height: 200px; */
  }
  
  /* main */
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

    .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    /* min-height: 400px; */
  }
</style>



