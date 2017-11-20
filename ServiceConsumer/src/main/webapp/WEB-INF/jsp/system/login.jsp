<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
<div align="center">
  <div style="width: 50%;padding-top:5%;" align="left">
   <label class="control-label">login</label>
   <hr style="height:1px;border:none;border-top:1px solid #555555;" />
   <div align="center" style="width: 100%">
    <div  style="width:40%">
       <form action="${basePath }/system/login" method="post" class="form-horizontal"  role="form" id="userRegisterForm">
       	<div class="form-group">
       	<c:import url="../common/errors.jsp"></c:import>
		<label class="col-sm-2 control-label" for="account">account</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="account" name="userId" maxlength="32"
			   required oninvalid="setCustomValidity('please enter your account!');" oninput="setCustomValidity('');"
			   placeholder="account">
		</div>
	   </div>
	   	 <div class="form-group">
		<label class="col-sm-2 control-label" for="password">password</label>
		<div class="col-sm-10">
			 <input type="password" class="form-control" id="password" name="password" maxlength="64"
			   required oninvalid="setCustomValidity('please enter password!');" oninput="setCustomValidity('');"
			   placeholder="password">
		</div>
	   </div>
	   <div class="form-group" align="center"><button type=submit class="btn btn-primary" >login</button></div>
       </form>
    </div>
    </div>
  </div>
</div>
</body>
</html>