<template>
  <v-card max-width="374">
    <template slot="progress">
      <v-progress-linear color="deep-purple" height="10" indeterminate></v-progress-linear>
    </template>
    <div class="expansion">
      <!-- <v-img height="250" src="https://cdn.vuetifyjs.com/images/cards/cooking.png"></v-img> -->
      <!-- <house-roadview :lat="item.lat" :lng="item.lng" :key="item.lng"></house-roadview> -->
      <house-roadview :lat="item.lat" :lng="item.lng"></house-roadview>
      <v-row justify="space-between">
        <v-col cols="auto">
          <v-card-title>{{ item.apartmentName }}아파트 </v-card-title>
        </v-col>
        <v-col cols="auto" sm="3">
          <v-btn icon :color="btnColor" @click="likeClick">
            <v-icon>mdi-heart</v-icon>
          </v-btn>
        </v-col>
      </v-row>

      <v-card-subtitle class="grey--text">{{ item.buildYear }}년 건축</v-card-subtitle>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div class="grey--text">
            <b-icon icon="geo-alt-fill" font-scale="1"></b-icon>{{ item.dong }} {{ item.jibun }}번지
          </div>
        </v-row>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>
      <house-chart :clabels="labels" :cdata="chartdata"></house-chart>
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
import HouseChart from "@/components/house/HouseChart.vue";
import http from "@/api/http.js";
export default {
  name: "HouseList",
  components: {
    HouseRoadview,
    HouseChart,
  },
  props: {
    house: Array,
  },
  created() {
    this.house.forEach((element) => {
      let temp = element.dealYear + "." + element.dealMonth;
      this.labels.push(temp);
      // console.log(parseInt(element.dealAmount));
      this.chartdata.push(parseInt(element.dealAmount) * 1000);
    });
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
      btnColor: "",

      item: { ...this.house[0] },
      labels: [],
      chartdata: [],
    };
  },
  computed: { ...mapState(["sidos", "guguns", "dongs"]) },
  methods: {
    likeClick() {
      this.btnColor = "pink";
      const params = { aptCode: this.item.aptCode };
      http
        .get(`/bookmark/register`, { params })
        .then((response) => {
          console.log("status" + response.status);
        })
        .catch((error) => {
          if (error.response.status === 400) {
            alert("이미 등록되어 있는 아파트입니다.");
          } else {
            console.log(error.response);
          }
        });
    },
  },
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
