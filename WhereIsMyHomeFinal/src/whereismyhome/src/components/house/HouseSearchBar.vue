<template>
  <v-app>
    <v-row>
      <v-col class="sm-3">
        <v-tabs>
          <v-tab>아파트정보</v-tab>
          <v-tab>매매정보</v-tab>
        </v-tabs>
      </v-col>
      <v-col class="sm-3">
        <v-select v-model="sidoCode" :items="sidos" @change="searchApt"></v-select>
      </v-col>
      <v-col class="sm-3">
        <v-select v-model="gugunCode" :items="guguns" @change="searchApt"></v-select>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      items: ["Foo", "Bar", "Fizz", "Buzz"],
      sidoCode: null,
      gugunCode: null,
    };
  },
  computed: {
    ...mapState(["sidos", "guguns", "houses"]),

    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    this.CLEAR_SIDO_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_APT_LIST"]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    searchApt() {
      if (this.gugunCode) this.getHouseList(this.gugunCode);
    },
  },
};
</script>

<style></style>
