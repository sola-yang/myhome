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
  <div style="width: 70%;padding-top:5%;" align="left">
   <label class="control-label">add family member</label>
   <hr style="height:1px;border:none;border-top:1px solid #555555;" />
    <div style="width: 100%;height:100%;float:left;" >

       <form action="${basePath }/familymember/save" method="post" class="form-horizontal"  role="form" id="familyAddForm" enctype="multipart/form-data">
       	<input type="text" value="${update.id }" hidden="true" name="id"/>
       	<div class="form-group">
		<label class="col-sm-2 control-label" for="familyName">Family Member ID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="familyMember" name="familyMember" maxlength="32" value="${update.familyMember } " 
			   required oninvalid="setCustomValidity('please enter familyMemberId');" oninput="setCustomValidity('');"
			   placeholder="familyMemberId">
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label" for="familyMemberRole">Family Member Role</label>
		<div class="col-sm-10">
			<select class="form-control" id="familyMemberRole" name="familyMemberRole" >
			  <c:forEach items="${familyRoleMap }" var="role">
			    <option value="${role.key }" ${update.familyMemberId==role.key?"selected":""}>${role.value}</option>
			  </c:forEach>
		    </select>
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

</script>
</body>
</html>