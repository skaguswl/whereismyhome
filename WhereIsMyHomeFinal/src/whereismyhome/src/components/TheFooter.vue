<template>
  <div>
    <v-footer dark padless>
      <v-card text tile class="black lighten-1 white--text text-center">
        <v-row>
          <v-col>
            <v-img
              alt="Logo"
              class="shrink mr-2"
              contain
              :src="require('@/assets/logo-white.png')"
              transition="scale-transition"
              width="100"
            />
          </v-col>
          <v-col>
            <v-card>
              <v-card-text class="white--text pt-5">
                본 사이트의 콘텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
        <v-row> </v-row>
        <v-row> </v-row>
        <!-- <v-divider></v-divider> -->
      </v-card>
    </v-footer>
  </div>
</template>

<script>
export default {
  name: "TheFooter",

  data() {
    return {};
  },

  mounted() {},

  methods: {},
};
</script>

<style lang="scss" scoped></style>
