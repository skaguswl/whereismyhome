"use strict";(self["webpackChunkwhereismyhome"]=self["webpackChunkwhereismyhome"]||[]).push([[223],{3223:function(t,e,s){s.r(e),s.d(e,{default:function(){return u}});var r=function(){var t=this,e=t._self._c;return e("b-container",{staticClass:"bv-example-row mt-3"},[e("b-row",[e("b-col",[e("b-alert",{attrs:{show:""}},[e("h3",[t._v("글수정")])])],1)],1),e("q-board-input-item",{attrs:{type:"modify"}})],1)},i=[],a=s(9118),n={name:"QBoardModify",components:{QBoardInputItem:a.Z}},c=n,l=s(1001),o=(0,l.Z)(c,r,i,!1,null,null,null),u=o.exports},9118:function(t,e,s){s.d(e,{Z:function(){return u}});var r=function(){var t=this,e=t._self._c;return e("b-row",{staticClass:"mb-1"},[e("b-col",{staticStyle:{"text-align":"left"}},[e("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[e("b-form-group",{attrs:{id:"userid-group",label:"작성자:","label-for":"userid",description:"작성자를 입력하세요."}},[e("b-form-input",{attrs:{id:"userid",disabled:t.isUserid,type:"text",required:"",placeholder:"작성자 입력..."},model:{value:t.article.userid,callback:function(e){t.$set(t.article,"userid",e)},expression:"article.userid"}})],1),e("b-form-group",{attrs:{id:"subject-group",label:"제목:","label-for":"subject",description:"제목을 입력하세요."}},[e("b-form-input",{attrs:{id:"subject",type:"text",required:"",placeholder:"제목 입력..."},model:{value:t.article.subject,callback:function(e){t.$set(t.article,"subject",e)},expression:"article.subject"}})],1),e("b-form-group",{attrs:{id:"content-group",label:"내용:","label-for":"content"}},[e("b-form-textarea",{attrs:{id:"content",placeholder:"내용 입력...",rows:"10","max-rows":"15"},model:{value:t.article.content,callback:function(e){t.$set(t.article,"content",e)},expression:"article.content"}})],1),"register"===this.type?e("b-button",{staticClass:"m-1",attrs:{type:"submit",variant:"primary"}},[t._v("글작성")]):e("b-button",{staticClass:"m-1",attrs:{type:"submit",variant:"primary"}},[t._v("글수정")]),e("b-button",{staticClass:"m-1",attrs:{type:"reset",variant:"danger"}},[t._v("초기화")])],1)],1)],1)},i=[],a=(s(7658),s(1780)),n={name:"QBoardInputItem",data(){return{article:{qnaId:0,userid:"",subject:"",content:""},isUserid:!1}},props:{type:{type:String}},created(){"modify"===this.type&&(a.Z.get(`/qna/${this.$route.params.qnaId}`).then((({data:t})=>{this.article=t})),this.isUserid=!0)},methods:{onSubmit(t){t.preventDefault();let e=!0,s="";!this.article.userid&&(s="작성자 입력해주세요",e=!1,this.$refs.userid.focus()),e&&!this.article.subject&&(s="제목 입력해주세요",e=!1,this.$refs.subject.focus()),e&&!this.article.content&&(s="내용 입력해주세요",e=!1,this.$refs.content.focus()),e?"register"===this.type?this.registArticle():this.modifyArticle():alert(s)},onReset(t){t.preventDefault(),this.article.qnaId=0,this.article.subject="",this.article.content="",this.moveList()},registArticle(){a.Z.post("/qna",{userid:this.article.userid,subject:this.article.subject,content:this.article.content}).then((t=>{let e="등록 처리시 문제가 발생했습니다.";200===t.status&&(e="등록이 완료되었습니다."),alert(e),this.moveList()}))},modifyArticle(){a.Z.put("/qna",{qnaId:this.article.qnaId,userid:this.article.userid,subject:this.article.subject,content:this.article.content}).then((({data:t})=>{let e="수정 처리시 문제가 발생했습니다.";"success"===t&&(e="수정이 완료되었습니다."),alert(e),this.moveList()}))},moveList(){this.$router.push({name:"qboardlist"})}}},c=n,l=s(1001),o=(0,l.Z)(c,r,i,!1,null,null,null),u=o.exports}}]);
//# sourceMappingURL=223.d61cb21f.js.map