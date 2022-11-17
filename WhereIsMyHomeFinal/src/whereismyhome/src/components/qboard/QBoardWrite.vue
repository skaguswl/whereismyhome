<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글작성</h3></b-alert>
      </b-col>
    </b-row>
    <q-board-input-item type="register" />
  </b-container>
</template>

<script>
import QBoardInputItem from "@/components/qboard/item/QBoardInputItem";

export default {
  name: "QBoardWrite",
  components: {
    QBoardInputItem,
  },
};
</script>

<style></style>
