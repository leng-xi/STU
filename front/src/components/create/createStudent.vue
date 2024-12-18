<template>
    <el-form ref="form" :model="form" label-width="80px">

        <el-form-item label="姓名">
            <el-input v-model="form.person.name"></el-input>
        </el-form-item>
        <el-form-item label="学号">
            <el-input v-model="form.user.username"></el-input>
        </el-form-item>
        <el-form-item label="学院">
            <el-select v-model="form.person.dept" placeholder="请选择学院">
                <el-option label="软件学院" value="软件学院"></el-option>
                <el-option label="集成电路学院" value="集成电路学院"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item v-if="form.person.dept == '软件学院'" label="专业">
            <el-select v-model="form.major" placeholder="请选择专业">
                <el-option label="软件工程" value="软件工程"></el-option>
                <el-option label="工业软件" value="工业软件"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item v-if="form.person.dept == '集成电路学院'" label="专业">
            <el-select v-model="form.major" placeholder="请选择专业">              
                <el-option label="微电子" value="1"></el-option>
                <el-option label="集成电路" value="2"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="班级">
            <el-select v-model="form.className" placeholder="请选择班级">
                <el-option label="1班" value="1"></el-option>
                <el-option label="2班" value="2"></el-option>
                <el-option label="菁英班" value="2"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="身份证号">
            <el-input v-model="form.person.card"></el-input>
        </el-form-item>
        <el-form-item label="邮件地址">
            <el-input v-model="form.person.addresss"></el-input>
        </el-form-item> 
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
    </el-form-item>
    </el-form>

</template>
<script>
import { addStudent } from '../../api/studenttable.ts'
export default {
    name: "creatStudent",
    data() {
      return {
        form: {
        major: '',
        className: '',
        person: {
          name: '',
          type: 1,
          dept: '',
          card: null,
          gender: null,
          birthday: null,
          email: null,
          phone: null,
          address: null
        },
        user: {
          password: '12345',
          username: ''
        }          
        }
      }
    },
    methods: {
      onSubmit() {
        //console.log('submit!');
        addStudent( this.form ).then((res) =>{
            if(res.data.data=="添加成功"){
                this.$message.success('添加成功')
                this.$router.push('/container/teacherList')
            }else{
                this.$message.error('添加失败')
            }
            console.log(res)
        })
      }
    }
  }
</script>