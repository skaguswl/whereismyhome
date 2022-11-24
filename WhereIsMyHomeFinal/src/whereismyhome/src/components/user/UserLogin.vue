<template>
  <v-card class="mx-auto my-4 text-center loginform" max-width="720">
    <v-card-title><h3>로그인</h3></v-card-title>

    <v-card-text>
      <form>
        <v-text-field
          id="username"
          v-model="user.username"
          label="아이디"
          :rules="nameRules"
          required
        ></v-text-field>
        <v-text-field
          id="password"
          v-model="user.password"
          type="password"
          label="비밀번호"
          :rules="pwdRules"
          required
        ></v-text-field>
        <v-btn class="mr-4" @click="confirm"> 로그인 </v-btn>
        <v-btn @click="movePage"> 회원가입 </v-btn>
      </form>
    </v-card-text>
  </v-card>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";
// import http from "@/api/http";
export default {
  name: "UserLogin",
  data() {
    return {
      isLoginError: false,
      user: {
        username: null,
        password: null,
      },
      nameRules: [(v) => !!v || "ID is required"],
      pwdRules: [(v) => !!v || "Password is required"],
    };
  },

  computed: {
    ...mapState(["isLogin", "username"]),
  },
  methods: {
    confirm() {
      const form = new FormData();
      form.append("username", this.user.username);
      form.append("password", this.user.password);
      axios
        .post(`http://localhost:8080/login`, form, { withCredentials: true })
        .then((response) => {
          let msg = "로그인 처리시 문제가 발생했습니다.";
          if (response.status === 200) {
            msg = "로그인 되었습니다.";
            this.$store.commit("SET_LOGIN_STATE", this.user.username);
          }
          // console.log(this.isLogin);
          alert(msg);
          this.moveHome();
        });
      // (await axios.post(`${myData.domain}/login`, form, { withCredentials: true })).status;
    },
    movePage() {
      this.$router.push({ name: "join" });
    },
    moveHome() {
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style>
.loginform {
  padding: 5%;
}
</style>
