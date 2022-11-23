<template>
  <v-card>
    <v-img
      alt="city"
      class="image shrink mr-2"
      contain
      :src="require('@/assets/city.jpg')"
      transition="scale-transition"
    />
  </v-card>
</template>

<script>
export default {
  name: "HomeView",

  components: {},
};
</script>

<style>
.image {
  /* position: absolute; */
  width: 100%;
  height: 40%;
  top: 0;
  left: 0;
}
.cardtitle {
  position: absolute;
  z-index: 999;
  top: 0;
  left: 50%;
}
</style>
