<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<form id="toolbar_form" method="post" style="display: none">
	<c:forEach var="item" items="${query.items}">
		<input type="hidden" name="${item.name}" value="${item.value}"/>
	</c:forEach>
</form>
<c:if test="${param.addData !=null}">
  <input onclick="javascript:location.href='${param.addData}'" type="button" class="btn" name="_action_create" value="${param.addDataName}">
</c:if>
<c:if test="${param.delete !=null}">
  <input type="button" class="btn" onclick="javascript:doWithMultiItem('${param.delete}','确认删除？')" name="_action_delete"  value="${param.deleteName}">
</c:if>
<c:if test="${param.update !=null}">
  <input type="button" class="btn" onclick="javascript:doWithMultiItem('${param.update}')" name="_action_update"  value="${param.updateName}">
</c:if>
<script>
var toolbar_form=document.getElementById("toolbar_form");
function getIds(){
	var id="";
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked)
			id+=ids[i].value+"-"; 
	}
	if(id!="")
		id=id.substring(0,id.length-1);
	return id;
}
function getId(){
	var id=-1;
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			if(id==-1) 
				id=ids[i].value; 
			else 
				return -2;
		}
	} 
	return id;
}
function doWithMultiItem(path, confirmMsg){
    var ids=selectMultiItems(confirmMsg);
    if(ids){
        toolbar_form.action=path+"/"+ids;
      //  setQueryString();
        toolbar_form.submit();
    }
}
function doWitSingleItem(path){
    var id=selectSingleItem();
    if(id){
        toolbar_form.action=path+"/"+id;
      //  setQueryString();
        toolbar_form.submit();
    }
}

function selectMultiItems(confirmMsg){
    var ids=getIds();
    if(ids==""){
        alert("please select the items!");
        return;
    }
    if(confirmMsg && !confirm(confirmMsg)){
        return;
    }
    return ids;
}
function selectSingleItem(){
    var id=getId();
    if(id==-1){
    	alert("please select one item to update!");
        return;
    }else if(id==-2){
    	alert("you can only select one item!");
        return;
    }
    return id;
}
function setQueryString(){
    var queryString="";
    $.each($("#search_form input"), function(i,param){
        if(param.type!="submit" && param.value!="")
            queryString+=param.name+"="+param.value+"&";
    });
    $.each($("#search_form select"), function(i,param){
        if(param.value!="")
            queryString+=param.name+"="+param.value+"&";
    });
    queryString+="_page="+$("#paginator .active a").html();
    $('<input />').attr('type', 'hidden')
            .attr('name', "queryString")
            .attr('value', encodeURI(queryString))
            .appendTo('#toolbar_form');
}
   
</script>