<template>
  <div>
      <el-container>
          <el-header><template>

    <div class="demo-type">
<div
        <div id="aaa">
            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        </div>
       
    </div>
</template></el-header>
          <el-main>
              <template>
                  <el-carousel :interval="4000" type="card" height="200px">
                      <el-carousel-item v-for="item in 6" :key="item">
                          <h3 class="medium">{{ item }}</h3>
                      </el-carousel-item>
                  </el-carousel>
              </template>
          </el-main>
          <el-footer>Footer</el-footer>
      </el-container>

  </div>
</template>

<style>
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }

</style>
