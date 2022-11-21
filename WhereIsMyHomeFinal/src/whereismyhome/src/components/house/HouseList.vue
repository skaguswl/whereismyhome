<template>
  <!-- <b-container v-if="houses && houses.length != 0" class="bv-example-row mt-3">
    <house-list-item v-for="(house, index) in houses" :key="index" :house="house" />
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>주택 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container> -->
  <v-card class="mx-auto my-12" max-width="374">
    <!-- <v-img height="250" src="https://cdn.vuetifyjs.com/images/cards/cooking.png"></v-img> -->

    <v-card-title>아파트정보</v-card-title>

    <v-card-text>
      <!-- <house-list-item v-for="(house, index) in houses" :key="index" :house="house" /> -->
    </v-card-text>

    <!-- <v-divider class="mx-4"></v-divider> -->
  </v-card>
</template>

<script>
// import HouseListItem from "@/components/house/HouseListItem";
import { mapState } from "vuex";

export default {
  name: "HouseList",
  components: {
    // HouseListItem,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(["houses"]),
    // houses() {
    //   return this.$store.state.houses;
    // },
  },
};
</script>

<style></style>
