<template>
  <div>
    <div id="map">
      <div class="aptlist">
        <house-list></house-list>
      </div>
    </div>
  </div>
</template>

<script>
import HouseList from "@/components/house/HouseList.vue";
import http from "@/api/http.js";
import { mapState } from "vuex";
export default {
  name: "HouseMap",
  data() {
    return {
      markers: [],
      house: {},
    };
  },
  components: {
    HouseList,
  },
  computed: {
    ...mapState(["houses"]),
  },
  watch: {
    houses: "displayMarker", // 대상 속성과 메서드 함수를 매칭
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=ea07304fed72af84205aefbab8af45d7";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    changeSize(size) {
      const container = document.getElementById("map");
      container.style.width = `${size}px`;
      container.style.height = `${size}px`;
      this.map.relayout();
    },
    displayMarker() {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = this.houses.map((position) => new kakao.maps.LatLng(...position));

      if (positions.length > 0) {
        this.markers = positions.map((position, idx) => {
          const marker = new kakao.maps.Marker({
            map: this.map,
            position,
            clickable: true,
          });
          const houses = this.houses;
          kakao.maps.event.addListener(marker, "click", function () {
            const params = { lat: houses[idx][0], lng: houses[idx][1] };
            http.get(`/map/apt`, { params }).then(({ data }) => {
              this.house = data;
              console.log(this.house);
            });
          });
          return marker;
        });

        const bounds = positions.reduce((bounds, latlng) => bounds.extend(latlng), new kakao.maps.LatLngBounds());

        this.map.setBounds(bounds);
        // 마커에 클릭이벤트를 등록합니다
        // this.markers.forEach((marker) =>
        //   kakao.maps.event.addListener(marker, "click", function () {
        //     // const params = { lat: this.houses[idx][0], lng: this.houses[idx][1] };
        //     console.log(this.houses);
        //     // http.get(`/map/apt`)
        //     console.log(marker);
        //   })
        // );
      }
    },
    displayInfoWindow() {
      if (this.infowindow && this.infowindow.getMap()) {
        //이미 생성한 인포윈도우가 있기 때문에 지도 중심좌표를 인포윈도우 좌표로 이동시킨다.
        this.map.setCenter(this.infowindow.getPosition());
        return;
      }

      var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(33.450701, 126.570667), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

      this.infowindow = new kakao.maps.InfoWindow({
        map: this.map, // 인포윈도우가 표시될 지도
        position: iwPosition,
        content: iwContent,
        removable: iwRemoveable,
      });

      this.map.setCenter(iwPosition);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: ;
  height: 600px;
  position: relative;
}
.aptlist {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 999;
}
.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
