<template>
  <b-tr>
    <b-td>{{ replystate }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'qboardview', params: { qnaId: qnaId } }">{{ subject }}</router-link>
    </b-th>
    <b-td>{{ hit }}</b-td>
    <b-td>{{ userid }}</b-td>
    <b-td>{{ regtime | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";

export default {
  name: "QBoardListItem",
  props: {
    qnaId: Number,
    userId: String,
    subject: String,
    hit: Number,
    createdDate: String,
    replyState: String,
  },
  filters: {
    dateFormat(regtime) {
      return moment(new Date(regtime)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
