<template>
  <div>
    <v-footer class="footer" dark padless fixed>
      <v-img
        alt="Logo"
        class="shrink mr-2"
        contain
        :src="require('@/assets/logo-white.png')"
        transition="scale-transition"
        width="100"
      />

      <div>WhereIsMyHouse 남현지 이지용</div>
    </v-footer>
  </div>
</template>

<script>
export default {
  name: "TheFooter",

  data() {
    return {};
  },

  mounted() {},

  methods: {},
};
</script>

<style lang="scss" scoped>
.footer {
  width: 100%;
  height: 80px;
}
</style>
