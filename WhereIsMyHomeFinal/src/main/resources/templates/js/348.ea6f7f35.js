"use strict";(self["webpackChunkwhereismyhome"]=self["webpackChunkwhereismyhome"]||[]).push([[348],{3348:function(e,t,r){r.r(t),r.d(t,{default:function(){return h}});var a=function(){var e=this,t=e._self._c;return t("b-container",{staticClass:"bv-example-row mt-3"},[t("b-row",[t("b-col",[t("b-alert",{attrs:{show:""}},[t("h3",[e._v("글목록")])])],1)],1),t("b-row",[t("b-col",[t("b-alert",{attrs:{show:"",variant:"danger"}},[e._v("삭제처리중...")])],1)],1)],1)},s=[],l=(r(7658),r(1780)),n={name:"QBoardDelete",created(){l.Z["delete"](`/qna/${this.$route.params.articleno}`).then((({data:e})=>{let t="삭제 처리시 문제가 발생했습니다.";"success"===e&&(t="삭제가 완료되었습니다."),alert(t),this.$router.push({name:"qboardlist"})}))}},o=n,u=r(1001),c=(0,u.Z)(o,a,s,!1,null,null,null),h=c.exports}}]);
//# sourceMappingURL=348.ea6f7f35.js.map