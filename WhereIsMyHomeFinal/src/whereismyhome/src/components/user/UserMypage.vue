<template>
  <v-card class="mx-auto my-4 text-center loginform" max-width="720">
    <v-card-title><h1>마이페이지</h1></v-card-title>

    <v-form ref="form">
      <v-text-field v-model="user.name" label="이름"></v-text-field>
      <v-text-field v-model="user.username" label="ID"></v-text-field>
      <v-text-field v-model="user.email" label="이메일"></v-text-field>
    </v-form>

    <v-row justify="space-around">
      <v-col><v-btn depressed> 수정 </v-btn></v-col>
      <v-col><v-btn depressed> 삭제 </v-btn></v-col>
    </v-row>
    <v-card-title><h3>찜해둔 아파트</h3></v-card-title>

    <v-list>
      <v-list-item v-for="apt in aptlist" :key="apt.bookmarkId">
        <v-list-item-title>
          {{ apt.apartmentName }}
        </v-list-item-title>
        <v-list-item-icon>
          <v-btn icon @click="removeApt(apt.bookmarkId)">
            <v-icon> mdi-delete </v-icon>
          </v-btn>
        </v-list-item-icon>
      </v-list-item>
    </v-list>
  </v-card>
</template>

<script>
import http from "@/api/http.js";
export default {
  name: "UserMypage",
  data() {
    return {
      user: {
        username: null,
        name: null,
        email: null,
      },
      aptlist: [],
    };
  },
  created() {
    http.get(`/user`).then(({ data }) => {
      console.log(this.user);
      this.user.username = data.username;
      this.user.name = data.name;
      this.user.email = data.email;
    });
    http
      .get(`/bookmark/get`)
      .then(({ data }) => {
        console.log("aptlist = " + data);
        this.aptlist = data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
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
