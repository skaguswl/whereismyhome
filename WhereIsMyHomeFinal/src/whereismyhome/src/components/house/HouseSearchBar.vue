<template>
  <v-row>
    <v-col class="sm-3 selector">
      <v-select v-model="sidoCode" :items="sidos" @change="gugunList"></v-select>
    </v-col>
    <v-col class="sm-3 selector">
      <v-select v-model="gugunCode" :items="guguns" @change="dongList"></v-select>
    </v-col>
    <v-col class="sm-3 selector">
      <v-select v-model="dongCode" :items="dongs" @change="searchApt"></v-select>
    </v-col>
    <v-col class="sm-3 selector my-4">
      <div class="text-center">
        <v-menu transition="fade-transition">
          <template v-slot:activator="{ on, attrs }">
            <v-btn class="btn" dark v-bind="attrs" v-on="on" @click="getApt"> 찜한 아파트 </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="apt in aptlist" :key="apt.bookmarkId">
              <v-list-item-title>
                <v-btn @click="showAptInfo(apt)">{{ apt.apartmentName }}</v-btn>
              </v-list-item-title>
              <v-list-item-icon>
                <v-btn icon @click="removeApt(apt.bookmarkId)">
                  <v-icon> mdi-delete </v-icon>
                </v-btn>
              </v-list-item-icon>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>
    </v-col>
  </v-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import http from "@/api/http.js";
export default {
  name: "HouseSearchBar",
  data() {
    return {
      tap: null,
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      aptlist: [],
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
    ...mapActions(["getSido", "getGugun", "getDong", "getHouseList", "setMarker"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_DONG_LIST", "CLEAR_APT_LIST"]),
    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      // console.log(this.sidoCode);
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
    showAptInfo(element) {
      this.setMarker([[element.lat, element.lng]]);
    },
    removeApt(id) {
      const params = { bookmarkId: id };
      // console.log("remove: " + id);
      http
        .delete(`/bookmark/delete`, { params })
        .then(() => {})
        .catch((error) => {
          console.log(error);
        });
    },
    getApt() {
      http
        .get(`/bookmark/get`)
        .then(({ data }) => {
          // console.log(commit, response);
          this.aptlist = data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style>
.selector {
  z-index: 9999;
}
.btn {
  padding: 20px;
}
</style>
