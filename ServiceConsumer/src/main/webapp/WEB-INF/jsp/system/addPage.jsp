<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user add</title>
	<script type="text/javascript">
	   function pwdOnFocus(){
		   $('#hiddenMeg').attr("hidden",true);
	   }
	   function pwdLoseFocus(){
		   var apassword=$('#apassword').val();
		   var password=$('#password').val();
		   if(apassword!=password){
			   $('#hiddenMeg').attr("hidden",false);
		   }
	   }
	</script>
</head>
<body>
<div align="center">
  <div style="width: 50%;padding-top:5%;" align="left">
   <label class="control-label">register</label>
   <hr style="height:1px;border:none;border-top:1px solid #555555;" />
    <div style="width: 50%;height:100%;float:left;" >
       <form action="${basePath }/system/register" method="post" class="form-horizontal"  role="form" id="userRegisterForm">
       <c:import url="../common/errors.jsp"></c:import>
       	<div class="form-group">
		<label class="col-sm-2 control-label" for="account">account</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="account" name="userId" maxlength="32" value="${form.userId }"
			   required oninvalid="setCustomValidity('please enter your account!');" oninput="setCustomValidity('');"
			   placeholder="account/phone/email">
		</div>
	   </div>
	          	<div class="form-group">
		<label class="col-sm-2 control-label" for="account">name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="account" name="userName" maxlength="32" value="${form.userName }"
			   required oninvalid="setCustomValidity('please enter your name');" oninput="setCustomValidity('');"
			   placeholder="name">
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label" for="sex">sex</label>
		<div class="col-sm-10">
			 <select class="form-control" id="sex" name="sex" >
			  <c:forEach items="${sexMap }" var="sex">
		      <option value="${sex.key}" ${form.sex eq  sex.key?"selected":""}>${sex.value}</option>
		      </c:forEach>
		    </select>
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="email">email</label>
		<div class="col-sm-10">
			 <input type="email" class="form-control" id="email" name="email" maxlength="64" value="${form.email }"
			   required oninvalid="setCustomValidity('please enter correct email address!');" oninput="setCustomValidity('');"
			   placeholder="email">
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="phone">phone</label>
		<div class="col-sm-10">
			 <input type="number" class="form-control"   id="phone" name="phoneNum" pattern="^1[3|4|5|8][0-9]\d{4,8}$ " value="${form.phoneNum }"
			   title="please enter correct phone number!"
			   required oninvalid="setCustomValidity('please enter correct phone number!');" oninput="setCustomValidity('');"
			   placeholder="phone">
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="address">address</label> 
		<div class="col-sm-10">
			 <input type="text" class="form-control" id="address" name="address" maxlength="128" value="${form.address }"
               required oninvalid="setCustomValidity('please enter address!');" oninput="setCustomValidity('');"
			   placeholder="address">
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="qq">qq</label>
		<div class="col-sm-10">
			 <input type="number" class="form-control" id="qq" name="qqCount" maxlength="16" value="${form.qqCount }"
				required oninvalid="setCustomValidity('please enter correct qq number!');" oninput="setCustomValidity('');"
			   placeholder="qq">
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="wechart">wechart</label>
		<div class="col-sm-10">
			 <input type="text" class="form-control" id="wechart" name="weChartCount" maxlength="16" value="${form.weChartCount }"
			  required oninvalid="setCustomValidity('please enter correct wechart number!');" oninput="setCustomValidity('');"
			   placeholder="wechart">
		</div>
	   </div>
	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="password">password1</label>
		<div class="col-sm-10">
			 <input type="password" class="form-control" id="password" name="password" maxlength="64" 
			   required oninvalid="setCustomValidity('please enter password!');" oninput="setCustomValidity('');"
			   placeholder="password">
		</div>
	   </div>
	   	   	   <div class="form-group">
		<label class="col-sm-2 control-label" for="apassword">password2</label>
		<div class="col-sm-10">
			 <input type="password" class="form-control" id="apassword" maxlength="64"
			  required oninvalid="setCustomValidity('please enter password again!');" oninput="setCustomValidity('');"
			   placeholder="password again" onfocus="pwdOnFocus();" onblur="pwdLoseFocus();">
             <p id="hiddenMeg" hidden="true">the password1 and password2 must be equal!</p>
		</div>
	   </div>
	   <div class="form-group" align="center"><button type=submit class="btn btn-primary" >submit</button></div>
       </form>
    </div>
    <div style="width: 50%;height:100%;float:left;;padding-top:10%" align="center"><img src="<%=request.getContextPath()%>/image/home.jpg" style="width: 80%;height:100%;"></div>
  </div>
</div>
</body>
</html>