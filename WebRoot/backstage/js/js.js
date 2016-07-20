function addQuestion(qno,no){
	if(confirm("是否确认添加？")){
		location.href="/user/addQ.action?questionaire.qno="+qno+"&questionaire.no="+no;
	}
}
function deletegoodsmany(){
	if(confirm("是否确认删除？")){
		document.deletegoodsmanyform.submit();
	}
}
function changegoodsIds(){
	var dgmbox = document.getElementById("dgmbox");
	var goodsIds = document.getElementsByName("goodsIds");
	for(var i=0 ; i < goodsIds.length ; i++){
		goodsIds[i].checked = dgmbox.checked;
	}
}