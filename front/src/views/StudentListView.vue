<template>
  <div>
    <div>
      <el-button type="primary" plain>新增</el-button>
    </div>
    <div></div>
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
        <template slot-scope="scope">
          <el-button @click="deleteClick(scope.row)" type="text" size="small"
            >删除</el-button
          >
          <el-button @click="updateClick(scope.row)" type="text" size="small"
            >编辑</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage2"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="10"
        layout="sizes, prev, pager, next"
        :total="1000"
      >
      </el-pagination>
    </div>
  </div>
</template>


<script>
import axios from "axios";
export default {
  methods: {
    deleteClick(row) {
      axios
        .post(
          "http://localhost:8080/student/deleteStudent",
          {
            id: row.person.id,
          },
          {
            headers: {
              token: this.$store.state.jwt,
            },
          }
        )
        .then((e) => {
          if(e.data.code === 1){
             this.$alert("删除成功","" ,{confirmButtonText: "确定",})
          }
        });
    },
    updateClick(row) {
      console.log(row);
    },
    handleSizeChange(val) {
      this.pageSize = val;
      axios
        .get("http://localhost:8080/student/getStudentList", {
          params: {
            page: this.page,
            pageSize: this.pageSize,
          },
          headers: {
            token: this.$store.state.jwt,
          },
        })
        .then((result) => {
          this.studentList = result.data.data.rows;
        });
    },
    handleCurrentChange(val) {
      this.page = val;
      axios
        .get("http://localhost:8080/student/getStudentList", {
          params: {
            page: this.page,
            pageSize: this.pageSize,
          },
          headers: {
            token: this.$store.state.jwt,
          },
        })
        .then((result) => {
          this.studentList = result.data.data.rows;
        });
    },
  },
  data() {
    return {
      studentList: [],
      page: 1,
      pageSize: 10,
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/student/getStudentList", {
        params: {
          page: this.page,
          pageSize: this.pageSize,
        },
        headers: {
          token: this.$store.state.jwt, // 添加认证头
        },
      })
      .then((result) => {
        this.studentList = result.data.data.rows;
      });
  },
};
</script>