<template>
  <el-container>
    <!-- head -->
  <el-header>山东大学</el-header>
  <el-container>
    <!-- aside -->
    <el-aside width="200px">
    <el-menu :default-openeds="['1']">
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>管理系统</template>
          <router-link to="/container/studentList" style="text-decoration:none"><el-menu-item index="1-1">学生管理</el-menu-item></router-link>
          <router-link to="/container/teacherList" style="text-decoration:none"><el-menu-item index="1-2">教师管理</el-menu-item></router-link>
          <router-link to="/container/courseList" style="text-decoration:none"><el-menu-item index="1-3">课程管理</el-menu-item></router-link>
      </el-submenu>
    </el-menu>
    </el-aside>
    <!-- main -->
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-container>
</template>
<script>
export default {
   methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>
<style>
.el-header {
   display: flex;  
    justify-content: center;  
    align-items: center;
    height: 100%;
    background: #cf2525;  
    color: #ffffff;  
    font-size: 30px;  
 
  }
  
</style>