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
                      <tr><td>you have not begin a home!</td></tr>
                   </c:when>
                   <c:otherwise>
                        <tr>
                     <th width="12px;"></th>
                     <th>Family Name</th>
                     <th>Family Motto</th>
                     <th>Parent Family1</th>
                     <th>Parent Family2</th>
                     <th>Family Create Time</th>
                     <th>Family Modified Time</th>
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
	                      <td>${data.familyName }</td>
	                      <td>${data.familyMotto }</td>
	                      <td>${data.pFamilyId1 }</td>
	                      <td>${data.pFamilyId2 }</td>
	                      <td>${data.timeCreate }</td>
	                      <td>${data.timeModifed }</td>
	                    </tr>
	                 </c:forEach>
                </tbody>
             </table>
          </div>
          <div class="row-fluid">
			<div class="span4 toolbar"  align="center">
			 <c:choose>
			    <c:when test="${hasDatas}">
			      <c:import url="../common/toolbar.jsp">
					<c:param name="update">../family/update</c:param>
					<c:param name="updateName">update</c:param>
				</c:import>
			    </c:when>
			    <c:otherwise>
			      <c:import url="../common/toolbar.jsp">
					<c:param name="addData">../family/addData</c:param>
					<c:param name="addDataName">add</c:param>
					<c:param name="update">../family/update</c:param>
					<c:param name="updateName">update</c:param>
				  </c:import>
			    </c:otherwise>
			 </c:choose>
			    
			</div>
		  </div>
       </div>
       </div>
       </div>
</body>
</html>