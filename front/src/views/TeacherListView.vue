s<template>
  <div>
    <div>
      <el-button @click="$router.push('/container/studentList/createStudent')">添加学生</el-button>
    </div>
    <el-table :data="studentList" border style="width: 100%">
      <el-table-column fixed prop="person.name" label="姓名" width="100">
      </el-table-column>
      <el-table-column prop="user.username" label="用户名" width="100">
      </el-table-column>
      <el-table-column prop="major" label="专业" width="100"> </el-table-column>
      <el-table-column prop="className" label="班级" width="100">
      </el-table-column>
      <el-table-column prop="person.dept" label="学院" width="100">
      </el-table-column>
      <el-table-column prop="person.card" label="身份证号" width="100">
      </el-table-column>
      <el-table-column prop="person.gender" label="性别" width="100">
      </el-table-column>
      <el-table-column prop="person.birthday" label="出生日期" width="100">
      </el-table-column>
      <el-table-column prop="person.email" label="邮箱" width="100">
      </el-table-column>
      <el-table-column prop="person.phone" label="联系电话" width="100">
      </el-table-column>
      <el-table-column prop="person.address" label="地址" width="100">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template  slot-scope="scoped">
          <el-button @click="deleteClick(scoped.row)" type="danger" size="mini"
            >删除</el-button>
          <el-button  @click="$router.push('/container/studentList/createStudent')"  size="mini"
            >编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import { getStudentList,deleteStudent } from '../api/studenttable.ts';

export default {
  data() {
    return {
      studentList: []
    }
  },
  methods: {
    async getAllStudentList() {
      try {
        const res = await getStudentList();
        this.studentList = res.data.data.rows;
        console.log(res);
      } catch (error) {
        console.error('获取学生列表出错:', error);
      }
    },
    deleteClick(row){
      console.log(row.person.id)
      this.$confirm('是否确认删除此学生','删除提示').then(() =>{
        deleteStudent(row.person).then(res =>{
          console.log(res)
        })
      })
      console.log(deleteStudent)
    }
  },
  created() {
    this.getAllStudentList();
  }
}

</script>