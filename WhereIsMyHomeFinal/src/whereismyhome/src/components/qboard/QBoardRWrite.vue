<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show variant="secondary"><h3>답변 작성</h3></b-alert>
      </b-col>
    </b-row>
    <q-board-r-input-item :id="qnaId" />
  </b-container>
</template>

<script>
import QBoardRInputItem from "@/components/qboard/item/QBoardRInputItem";

export default {
  name: "QBoardRWrite",
  data() {
    return {
      // qnaId: ${ this.$route.params.qnaId };
      qnaId: this.$route.params.qnaId,
    };
  },
  components: {
    QBoardRInputItem,
  },
};
</script>

<style></style>
