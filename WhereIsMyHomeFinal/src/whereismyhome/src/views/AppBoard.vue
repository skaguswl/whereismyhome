<template>
  <v-main class="bv-example-row mt-3 text-center">
    <h3 class="underline-gray"><b-icon icon="question-lg"></b-icon> QnA 서비스</h3>
    <router-view></router-view>
  </v-main>
</template>
<script>
export default {
  name: "AppBoard",
};
</script>
<style scoped>
.underline-hotpink {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, rgba(231, 27, 139, 0.3) 30%);
}
.content {
  height: 100%;
}
</style>
