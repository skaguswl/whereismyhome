const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: [
    'vuetify'
  ],
  publicPath: '/',

  // outputDir: '../main/resources/static', // 빌드경로

  outputDir: '../main/resources/templates', // 빌드경로

  chainWebpack(config) { //빌드 시 빌드되어 나오는 js파일을 js폴더 아래로 묶어 빌드한다

    config.output.filename("js/[name].js"); 

  },
})
