<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show variant="secondary"><h3>글보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="moveList">목록</b-button>
      </b-col>
      <b-col class="text-right">
        <b-button variant="outline-info" size="sm" @click="moveModifyArticle" class="mr-2"
          >글수정</b-button
        >
        <b-button variant="outline-danger" size="sm" @click="deleteArticle">글삭제</b-button>
        <b-button variant="outline-secondary" size="sm" @click="moveWriteReply">답변작성</b-button>
        <b-button variant="outline-danger" size="sm" @click="deleteReply">답변삭제</b-button>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.qnaId}.
          ${article.subject} </h3><div><h6>${article.username}</div><div>${article.createdDate}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
          <b-list-group flush>
            <b-list-group-item><div v-html="replycontent"></div></b-list-group-item>
          </b-list-group>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import moment from "moment";
import http from "@/api/http";

export default {
  name: "QBoardDetail",
  data() {
    return {
      article: {
        qnaId: "",
      },
      // article: {
      //   qnaId: "1",
      //   subject: "제목",
      //   userid: "ID",
      //   regtime: "20111111",
      //   hit: 1,
      //   replystate: "미답변",
      //   reply: "답변내용ㅇ요요요",
      //   content: "내용내용내용",
      // },
    };
  },
  computed: {
    message() {
      if (this.article.content) return this.article.content.split("\n").join("<br>");
      return "";
    },
    replycontent() {
      if (this.article.replyState == "답변 완료")
        return this.article.reply.split("\n").join("<br>");
      return "답변이 아직 작성되지 않았습니다.";
    },
  },
  created() {
    http.get(`/qna/${this.$route.params.qnaId}`).then(({ data }) => {
      this.article = data;
    });
  },
  methods: {
    moveModifyArticle() {
      this.$router.replace({
        name: "qboardmodify",
        params: { qnaId: this.article.qnaId },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.qnaId}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "qboarddelete",
          params: { qnaId: this.article.qnaId },
        });
      }
    },
    moveList() {
      this.$router.push({ name: "qboardlist" });
    },
    moveWriteReply() {
      this.$router.push({ name: "qboardrwrite", params: { qnaId: this.article.qnaId } });
    },
    deleteReply() {
      let params = { qnaId: this.article.qnaId };
      http.delete(`qna/reply`, { params }).then((response) => {
        if (response.status === 200) {
          alert("답변이 삭제 되었습니다.");
          this.$router.push({ name: "qboardlist" });
        }
      });
    },
  },
  // filters: {
  //   dateFormat(regtime) {
  //     return moment(new Date(regtime)).format("YY.MM.DD hh:mm:ss");
  //   },
  // },
};
</script>

<style></style>
