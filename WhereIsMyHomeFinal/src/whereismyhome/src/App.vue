<template>
  <div id="app">
    <the-header-navbar></the-header-navbar>
    <router-view></router-view>
    <the-footer></the-footer>
  </div>
</template>

<script>
import TheHeaderNavbar from "@/components/TheHeaderNavbar";
import TheFooter from "./components/TheFooter.vue";
export default {
  name: "App",
  components: {
    TheHeaderNavbar,
    TheFooter,
  },
  data: () => ({
    //
  }),
};
</script>
