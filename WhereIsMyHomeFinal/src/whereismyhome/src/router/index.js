import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
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
        path: "view/:articleno",
        name: "qboardview",
        component: () => import("@/components/qboard/QBoardView"),
      },
      {
        path: "modify",
        name: "qboardmodify",
        component: () => import("@/components/qboard/QBoardModify"),
      },
      {
        path: "delete/:articleno",
        name: "qboarddelete",
        component: () => import("@/components/qboard/QBoardDelete"),
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router