<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<c:set var="_familyManagement" value="active" scope="request"/>
<c:import url="../common/home.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div>
    
    <div style=" width: 10%;padding-top: 10px;float: left;"align="center" >
    
       <a href="${basePath }/family/show">Family</a>
       <br>
        <br>
       <a href="${basePath }/familymember/show">Family Member</a>
    
    </div>
       <div style=" width: 90%;padding-top: 10px;float: left;">
       <div style="width: 100%;" align="left">
          <div style="width: 98%;" align="center">
             <table class="table table-bordered table-striped" style="word-wrap:break-word;word-break:break-all;">
                <thead>
                   <c:choose>
                   <c:when test="${not hasDatas }">
                      <tr><td>there has no family member!</td></tr>
                   </c:when>
                   <c:otherwise>
    				    <tr>
	                     <th width="12px;"></th>
	                     <th>ID</th>
	                     <th>Role</th>
                	  </tr>
                   </c:otherwise>
                </c:choose>
          
                </thead>
                <tbody>
	                 <c:forEach var="data" items="${datas}" varStatus="status">
	                    <tr>
	                      <td class="checkbox_td">
							  <input type="checkbox" name="ids" value="${data.id}"/>
						  </td>
	                      <td>${data.familyMember }</td>
	                      <td>${familyRoleMap[data.familyMemberRole] }</td>
	                    </tr>
	                 </c:forEach>
                </tbody>
             </table>
          </div>
          <div class="row-fluid">
			<div class="span4 toolbar"  align="center">
			      <c:import url="../common/toolbar.jsp">
					<c:param name="addData">../familymember/addData</c:param>
					<c:param name="addDataName">add</c:param>
					<c:param name="update">../familymember/update</c:param>
					<c:param name="updateName">update</c:param>
						<c:param name="delete">../familymember/delete</c:param>
					<c:param name="deleteName">delete</c:param>
				  </c:import>
			</div>
		  </div>
       </div>
       </div>
       </div>
</body>
</html>