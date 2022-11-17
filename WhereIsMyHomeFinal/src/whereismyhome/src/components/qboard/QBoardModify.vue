<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글수정</h3></b-alert>
      </b-col>
    </b-row>
    <q-board-input-item type="modify" />
  </b-container>
</template>

<script>
import QBoardInputItem from "@/components/qboard/item/QBoardInputItem";

export default {
  name: "QBoardModify",
  components: {
    QBoardInputItem,
  },
};
</script>

<style></style>
