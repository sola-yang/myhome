 <%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body >
<div style="background-color: #003333;float:left;width: 100%">
<div style="background-color: #003333;float:left;width:100%">
<ul class="nav nav-pills pull-right" >
  <c:choose>
     <c:when test="<%=LoginContext.checkLogin(session) %>">
	      <li><a href="#"><%=LoginContext.getLoginUser().getUser().getUserName()%>&nbsp;&nbsp;&nbsp;&nbsp;welcome to your home!</a></li>
	      <li><a href="${basePath }/system/logout">logout</a></li>
     </c:when>
     <c:otherwise>
	      <li><a href="${basePath }/system/login">login</a></li>
	      <li><a href="${basePath }/system/addData">register</a></li>
     </c:otherwise>
  </c:choose>
</ul>
</div>
</div>
</body>
</html>