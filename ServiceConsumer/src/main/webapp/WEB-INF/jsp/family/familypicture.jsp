<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<c:set var="_myHome" value="active" scope="request"/>
<c:import url="../common/home.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
   <div >
    
    <div style=" width: 10%;padding-top: 15px;float: left;"align="center" >
    
       <a href="${basePath }/family/familypicture">Family Picture</a>
       <br>
        <br>
       <a href="${basePath }/familyshare/show">Family Share</a>
    
    </div>
       <div style=" width: 90%;padding-top: 15px;float: left;" align="center">
                   <table>
                   <tr>
	                 <c:forEach var="data" items="${datas}" varStatus="status">
	                     <td><img alt="${data.familyMotto }" src="${basePath }${data.familyPictureSrc }" style="width: 98%;height: 90%;"></td>
	                 </c:forEach>
	                 </tr>
	                 </table>
       </div>
       </div>
</body>
</html>