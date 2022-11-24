<template>
  <!-- <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>회원가입</h3></b-alert>
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
            <b-form-group label="이름:" label-for="username">
              <b-form-input
                id="username"
                v-model="user.username"
                required
                placeholder="이름 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="user.userid"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="email">
              <b-form-input
                type="email"
                id="email"
                v-model="user.email"
                required
                placeholder="이메일 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1" @click="confirm"
              >회원가입</b-button
            >
            <b-button type="button" variant="success" class="m-1" @click="movePage"
              >로그인</b-button
            >
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container> -->
  <v-card class="mx-auto my-4 text-center joinform" max-width="720">
    <v-card-title><h3>회원가입</h3></v-card-title>

    <v-card-text>
      <form>
        <v-text-field
          id="username"
          v-model="user.username"
          label="이름"
          required
          :rules="nameRules"
        ></v-text-field>
        <v-text-field
          id="userid"
          v-model="user.userid"
          label="아이디"
          required
          :rules="idRules"
        ></v-text-field>
        <v-text-field
          id="password"
          v-model="user.userpwd"
          type="password"
          label="비밀번호"
          required
          :rules="pwdRules"
        ></v-text-field>
        <v-text-field
          id="email"
          v-model="user.email"
          type="email"
          label="E-mail"
          required
          :rules="emailRules"
        ></v-text-field>
        <v-btn class="mr-4" @click="confirm"> 회원가입 </v-btn>
        <v-btn @click="movePage"> 로그인 </v-btn>
      </form>
    </v-card-text>
  </v-card>
</template>

<script>
import http from "@/api/http";
export default {
  name: "UserRegister",
  data() {
    return {
      isLoginError: false,
      user: {
        username: null,
        userid: null,
        userpwd: null,
        email: null,
      },
      nameRules: [(v) => !!v || "Name is required"],
      idRules: [(v) => !!v || "ID is required"],
      pwdRules: [(v) => !!v || "Password is required"],
      emailRules: [
        (v) => !!v || "E-mail is required",
        (v) => /.+@.+/.test(v) || "E-mail must be valid",
      ],
    };
  },

  methods: {
    confirm() {
      http
        .post(`/user/register`, {
          name: this.user.username,
          username: this.user.userid,
          password: this.user.userpwd,
          email: this.user.email,
        })
        .then((response) => {
          let msg = "회원가입 처리시 문제가 발생했습니다.";
          if (response.status === 200) {
            msg = "회원가입 되었습니다.";
          }
          alert(msg);
          this.moveHome();
        });
      // alert("로그인!!!");
    },
    movePage() {
      this.$router.push({ name: "login" });
    },
    moveHome() {
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style>
.joinform {
  padding: 5%;
}
</style>
