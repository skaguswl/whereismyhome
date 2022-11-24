import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/qboard",
    name: "qboard",
    component: () => import("@/views/AppBoard"),
    redirect: "/qboard/list",
    children: [
      {
        path: "list",
        name: "qboardlist",
        component: () => import("@/components/qboard/QBoardList"),
      },
      {
        path: "write",
        name: "qboardwrite",
        component: () => import("@/components/qboard/QBoardWrite"),
      },
      {
        path: "view/:qnaId",
        name: "qboardview",
        component: () => import("@/components/qboard/QBoardView"),
      },
      {
        path: "modify",
        name: "qboardmodify",
        component: () => import("@/components/qboard/QBoardModify"),
      },
      {
        path: "delete/:qnaId",
        name: "qboarddelete",
        component: () => import("@/components/qboard/QBoardDelete"),
      },
      {
        path: "delete/:qnaId",
        name: "qboarddelete",
        component: () => import("@/components/qboard/QBoardDelete"),
      },
      {
        path: "rwrite",
        name: "qboardrwrite",
        component: () => import("@/components/qboard/QBoardRWrite"),
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: () => import("@/views/AppHouse"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser"),
    children: [
      {
        path: "join",
        name: "join",
        component: () => import("@/components/user/UserRegister"),
      },
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/UserLogin"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
