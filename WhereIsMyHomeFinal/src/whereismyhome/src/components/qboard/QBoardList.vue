<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>글목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
      </b-col>
    </b-row>
    <!-- <b-row>
      <b-col>
        <b-table striped hover :items="articles" :fields="fields" @row-clicked="viewArticle">
          <template #cell(subject)="data">
            <router-link :to="{ name: 'qboardview', params: { qnaId: data.item.qnaId } }">
              {{ data.item.subject }}
            </router-link>
          </template>
        </b-table>
      </b-col>
    </b-row> -->
    <template>
      <v-data-table :headers="headers" :items="articles" :items-per-page="10" @click:row="moveView">
      </v-data-table>
    </template>
  </b-container>
</template>

<script>
import http from "@/api/http";

export default {
  name: "QBoardList",
  data() {
    return {
      articles: [],
      // pageable: [],
      headers: [
        { text: "답변상태", value: "replyState" },
        { text: "제목", value: "subject" },
        { text: "작성자", value: "username" },
        { text: "작성일", value: "createdDate" },
      ],
      // page: 1,
      // pageLen: 10,
    };
  },
  created() {
    http.get(`/qna`).then(({ data }) => {
      this.articles = data;
    });
  },
  watch: {
    page: "getArticle",
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "qboardwrite" });
    },
    moveView(event, { item }) {
      // console.log(item.qnaId);
      this.$router.push({ name: "qboardview", params: { qnaId: item.qnaId } });
    },
    viewArticle(article) {
      this.$router.push({
        name: "qboardview",
        params: { qnaId: article.qnaId },
      });
    },
    // getArticle() {
    //   let params = { page: this.page - 1 };
    //   // console.log(this.page);
    //   http.get(`/qna`, { params }).then(({ data }) => {
    //     this.articles = data.content;
    //     this.pageable = data.pageable;
    //   });
    // },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
