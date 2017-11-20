<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>home!</title>
</head>
<body>
  <ul class="nav nav-tabs" >
  <li class="${_myHome}"><a href="${basePath }/family/familypicture">My Home</a></li>
  <li class="${_homeTree}"><a href="${basePath }/myhome/hometree">Home Tree</a></li>
  <li class="${_homeMember}"><a href="${basePath }/myhome/homemember">Home Member</a></li>
  <li class="${_myPlace}"><a href="${basePath }/myhome/myplace">My Place</a></li>
  <li class="${_homeManagement}"><a href="${basePath }/myhome/homemanagement">Home Management</a></li>
  <li class="${_familyManagement}"><a href="${basePath }/family/show">Starting A Family</a></li>
 </ul>
</body>
</html>