<template>
  <v-row>
    <!-- <v-col class="sm-3">
      <v-card>
        <v-tabs v-model="tab">
          <v-tabs-slider></v-tabs-slider>
          <v-tab>아파트정보</v-tab>
          <v-tab>매매정보</v-tab>
        </v-tabs>
      </v-card>
    </v-col> -->
    <v-col class="sm-3">
      <v-select v-model="sidoCode" :items="sidos" @change="gugunList"></v-select>
    </v-col>
    <v-col class="sm-3">
      <v-select v-model="gugunCode" :items="guguns" @change="dongList"></v-select>
    </v-col>
    <v-col class="sm-3">
      <v-select v-model="dongCode" :items="dongs" @change="searchApt"></v-select>
    </v-col>
  </v-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      tap: null,
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(["sidos", "guguns", "dongs", "houses"]),
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    this.CLEAR_SIDO_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getDong", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_DONG_LIST", "CLEAR_APT_LIST"]),
    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      // console.log(this.sidoCode);
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchApt() {
      if (this.dongCode) this.getHouseList(this.dongCode);
    },
  },
};
</script>

<style></style>
