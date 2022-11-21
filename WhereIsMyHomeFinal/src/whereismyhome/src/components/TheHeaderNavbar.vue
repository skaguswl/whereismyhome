<template>
  <div>
    <v-app-bar app absolute dark color="primary">
      <v-btn text color="white"
        ><router-link :to="{ name: 'home' }">
          <v-img
            alt="Logo"
            class="shrink mr-2"
            contain
            :src="require('@/assets/logo-white.png')"
            transition="scale-transition"
            width="100"
          /> </router-link
      ></v-btn>
      <v-btn>
        <router-link :to="{ name: 'qboard' }" class="m-2 link">
          <b-icon icon="question-lg" font-scale="2"></b-icon>QnA게시판
        </router-link>
      </v-btn>
      <v-btn>
        <router-link :to="{ name: 'house' }" class="m-2 link"
          ><b-icon icon="house" font-scale="2"></b-icon> 아파트정보
        </router-link>
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        ><router-link :to="{ name: 'join' }" class="link">
          <b-icon icon="person-circle"></b-icon> 회원가입
        </router-link></v-btn
      >
      <v-btn
        ><router-link :to="{ name: 'login' }" class="link"> <b-icon icon="key"></b-icon> 로그인 </router-link></v-btn
      >
    </v-app-bar>
  </div>
</template>
<script>
export default {
  name: "TheHeaderNavbar",
  data() {
    return {};
  },
};
</script>

<style scoped>
#logo {
  width: 120px;
}

.link {
  text-decoration: none;
  color: aliceblue;
}
</style>
