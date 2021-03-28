<template>
  <div>
   <el-container>
     <el-header>
        <h2 style="margin-top:-5px;">商品交易</h2>


        </el-header>
     <el-main>
         <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
             <el-form-item label="账号：" prop="username">
                 <el-input v-model="ruleForm.username"></el-input>
             </el-form-item>
             <el-form-item label="密码：" prop="password">
                 <el-input type="password" v-model="ruleForm.password"></el-input>
             </el-form-item>
             <el-form-item label="验证码：" prop="msg">
                 <el-input  v-model="ruleForm.msg"></el-input>
             </el-form-item>
             <el-form-item>
                 <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                 <el-button @click="resetForm('ruleForm')">注册</el-button>
             </el-form-item>
         </el-form>
    </el-main>
</el-container>
  </div>
</template>
<script>
export default{
    name:"Login",

 data() {
      return {
        ruleForm: {
          username: 'q1q',
          password: '123',
              msg:'asxsd'
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'change' }
          ],
          
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            const _this = this
              alert('submit!');
              //跳转页面
              _this.$router.push("/Detali")         //跳转页面
              this.$axios.post('/user/login', this.ruleForm)
                  .then(res => {
                      alert('1111111111111111!');
                     
            console.log(res);
    //获取当前网页的jwt和userinfo信息、
    const jwt = res.headers['authorization']
    const userinfo = res.data.data

    //共享（存储）数据到公用
            _this.$store.commit("SET_TOKEN",jwt)
             _this.$store.commit("SET_USERINFO",userinfo)
        
          })
          } else {
              console.log('12312312321');
            console.log('desb');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
}
</script>
<style>

    .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

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
   .demo-ruleForm{max-width:500px;margin:0 auto}
</style>
