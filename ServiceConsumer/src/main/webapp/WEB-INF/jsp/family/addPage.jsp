<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:set var="_familyManagement" value="active" scope="request"/>
<c:import url="../common/home.jsp"></c:import>
</head>
<body>
<div align="center">
  <div style="width: 50%;padding-top:5%;" align="left">
   <label class="control-label">add family</label>
   <hr style="height:1px;border:none;border-top:1px solid #555555;" />
    <div style="width: 100%;height:100%;float:left;" >

       <form onsubmit="javascript:return checkFile(${update.id });" action="${basePath }/family/save" method="post" class="form-horizontal"  role="form" id="familyAddForm" enctype="multipart/form-data">
       	<input type="text" value="${update.id }" hidden="true" name="id"/>
       	<div class="form-group">
		<label class="col-sm-2 control-label" for="familyName">Family Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="familyName" name="familyName" maxlength="32" value="${update.familyName } " 
			   required oninvalid="setCustomValidity('please enter your family name!');" oninput="setCustomValidity('');"
			   placeholder="familyName">
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label" for="familyMotto">Family Motto</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="familyMotto" name="familyMotto" maxlength="32" value="${update.familyMotto }"
			   required oninvalid="setCustomValidity('please enter your family name!');" oninput="setCustomValidity('');"
			   placeholder="familyMotto">
		</div>
	   </div>
	    <div class="form-group">
		<label class="col-sm-2 control-label" for="account">Family Picture</label>
		<div class="col-sm-10">
			<input name="file" type="file" class="input-medium"/>
		</div>
	   </div>
	   <div class="form-group" align="center">
	      <button type=submit class="btn btn-primary" >submit</button>
	      <button type="button" class="btn" onclick="javascript:history.go(-1)">cancel</button>
	   </div>
       </form>
    </div>
</div>
</div>
<script type="text/javascript">

     function checkFile(id){
    	 var file=$('input[type=file]')[0].value;
    	 if((file==null||file=="")&&(id==null&&id=="")){
    		 alert("please choose a file!");
    		 return false;
    	 }else if((file!=null&&file!="")&&!(file.endsWith(".jpg")||file.endsWith(".png")||file.endsWith(".gif")||file.endsWith(".JPEG")||file.endsWith(".PNG")||file.endsWith(".GIF"))){
    		 alert("please choose a correct file!(suffix like:jpg,png,jpeg,gif)");
    		 return false;
    	 }
    	 return true;
     }

</script>
</body>
</html>