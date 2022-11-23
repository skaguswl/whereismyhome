<template>
  <v-card max-width="374">
    <template slot="progress">
      <v-progress-linear color="deep-purple" height="10" indeterminate></v-progress-linear>
    </template>
    <div class="expansion">
      <!-- <v-img height="250" src="https://cdn.vuetifyjs.com/images/cards/cooking.png"></v-img> -->
      <!-- <house-roadview :lat="item.lat" :lng="item.lng" :key="item.lng"></house-roadview> -->
      <house-roadview :lat="item.lat" :lng="item.lng"></house-roadview>
      <v-card-title>{{ item.apartmentName }}아파트 </v-card-title>
      <v-card-subtitle class="grey--text">{{ item.buildYear }}년 건축</v-card-subtitle>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div class="grey--text">
            <b-icon icon="geo-alt-fill" font-scale="1"></b-icon>{{ item.dong }} {{ item.jibun }}번지
          </div>
        </v-row>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>

      <v-expansion-panels class="mb-6">
        <v-expansion-panel>
          <v-expansion-panel-header expand-icon="mdi-menu-down">
            매매정보
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-data-table
              :headers="headers"
              :items="this.house"
              :items-per-page="5"
              class="elevation-1"
            ></v-data-table
          ></v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </div>
  </v-card>
</template>

<script>
// import HouseListItem from "@/components/house/HouseListItem";
import { mapState } from "vuex";
import HouseRoadview from "@/components/house/HouseRoadview.vue";
export default {
  name: "HouseList",
  components: {
    HouseRoadview,
  },
  props: {
    house: Array,
  },
  data() {
    return {
      headers: [
        {
          text: "거래년",
          value: "dealYear",
        },
        { text: "거래월", value: "dealMonth" },
        { text: "거래일", value: "dealDay" },
        { text: "거래금액", value: "dealAmount" },
      ],

      item: { ...this.house[0] },
    };
  },
  computed: { ...mapState(["sidos", "guguns", "dongs"]) },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style>
.expansion {
  height: 600px;
  overflow-y: scroll;
}
</style>
