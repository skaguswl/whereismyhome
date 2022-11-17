<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table striped hover :items="articles" :fields="fields" @row-clicked="viewArticle">
          <template #cell(subject)="data">
            <router-link :to="{ name: 'qboardview', params: { qnaId: data.item.qnaId } }">
              {{ data.item.subject }}
            </router-link>
          </template>
        </b-table>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";

export default {
  name: "QBoardList",
  data() {
    return {
      articles: [
        // {
        //   qnaId: "1",
        //   subject: "aaaa",
        //   userid: "a",
        //   regtime: "111",
        //   hit: 1,
        //   replystate: "미답변",
        // },
      ],
      fields: [
        { key: "replyState", label: "답변상태", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "createdDate", label: "작성일", tdClass: "tdClass" },
      ],
    };
  },
  created() {
    http.get(`/qna`).then(({ data }) => {
      this.articles = data.content;
    });
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "qboardwrite" });
    },
    viewArticle(article) {
      this.$router.push({
        name: "qboardview",
        params: { qnaId: article.qnaId },
      });
    },
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
