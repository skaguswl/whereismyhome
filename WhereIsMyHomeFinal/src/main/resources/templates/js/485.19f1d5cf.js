"use strict";(self["webpackChunkwhereismyhome"]=self["webpackChunkwhereismyhome"]||[]).push([[485],{9485:function(e,t,s){s.r(t),s.d(t,{default:function(){return d}});var a=function(){var e=this,t=e._self._c;return t("b-container",{staticClass:"bv-example-row mt-3"},[t("b-row",[t("b-col",[t("b-alert",{attrs:{show:""}},[t("h3",[e._v("글목록")])])],1)],1),t("b-row",{staticClass:"mb-1"},[t("b-col",{staticClass:"text-right"},[t("b-button",{attrs:{variant:"outline-primary"},on:{click:function(t){return e.moveWrite()}}},[e._v("글쓰기")])],1)],1),t("b-row",[t("b-col",[t("b-table",{attrs:{striped:"",hover:"",items:e.articles,fields:e.fields},on:{"row-clicked":e.viewArticle},scopedSlots:e._u([{key:"cell(subject)",fn:function(s){return[t("router-link",{attrs:{to:{name:"qboardview",params:{articleno:s.item.articleno}}}},[e._v(" "+e._s(s.item.subject)+" ")])]}}])})],1)],1)],1)},l=[],r=(s(7658),s(1780)),i={name:"QBoardList",data(){return{articles:[],fields:[{key:"articleno",label:"글번호",tdClass:"tdClass"},{key:"subject",label:"제목",tdClass:"tdSubject"},{key:"userid",label:"작성자",tdClass:"tdClass"},{key:"regtime",label:"작성일",tdClass:"tdClass"},{key:"hit",label:"조회수",tdClass:"tdClass"}]}},created(){r.Z.get("/qna").then((({data:e})=>{this.articles=e}))},methods:{moveWrite(){console.log("dkdkdkd"),this.$router.push({name:"qboardwrite"}),console.log("aaaaa")},viewArticle(e){this.$router.push({name:"qboardview",params:{articleno:e.articleno}})}}},o=i,n=s(1001),c=(0,n.Z)(o,a,l,!1,null,null,null),d=c.exports}}]);
//# sourceMappingURL=485.19f1d5cf.js.map