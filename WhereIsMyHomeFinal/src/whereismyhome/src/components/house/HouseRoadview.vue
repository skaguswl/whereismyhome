<template>
  <div
    id="roadview"
    style="width: 100%; height: 250px"
    class="p-3 d-flex justify-content-between"
  ></div>
</template>

<script>
export default {
  name: "HouseRoadview",
  //   props: ["lat", "lng"],
  props: { lat: String, lng: String },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=ea07304fed72af84205aefbab8af45d7";
      document.head.appendChild(script);
    }
  },

  methods: {
    initMap() {
      var roadviewContainer = document.getElementById("roadview"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
      console.log(this.lat + " " + this.lng);
      var position = new kakao.maps.LatLng(this.lat, this.lng);
      //   var position = new kakao.maps.LatLng(33.450701, 126.570667);
      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      if (this.lat != null && this.lng != null) {
        roadviewClient.getNearestPanoId(position, 50, function (panoId) {
          if (panoId == null) {
            alert("로드뷰가 없는 지역입니다.");
            return;
          } else roadview.setPanoId(panoId, position);
        });
      }
    },
  },
};
</script>

<style></style>
