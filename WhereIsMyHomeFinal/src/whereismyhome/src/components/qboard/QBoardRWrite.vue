<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>답변 작성</h3></b-alert>
      </b-col>
    </b-row>
    <q-board-r-input-item />
  </b-container>
</template>

<script>
import QBoardRInputItem from "@/components/qboard/item/QBoardRInputItem";

export default {
  name: "QBoardRWrite",
  components: {
    QBoardRInputItem,
  },
};
</script>

<style></style>
