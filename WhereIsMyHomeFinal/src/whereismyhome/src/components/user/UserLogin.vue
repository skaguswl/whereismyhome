<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>로그인</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError"
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="username">
              <b-form-input
                id="username"
                v-model="user.username"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="password">
              <b-form-input
                type="password"
                id="password"
                v-model="user.password"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1" @click="confirm">로그인</b-button>
            <b-button type="button" variant="success" class="m-1" @click="movePage"
              >회원가입</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import axios from "axios";
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
    };
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
          }
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

<style></style>
