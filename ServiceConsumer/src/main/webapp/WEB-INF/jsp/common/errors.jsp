<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<ul id="errors">
<c:if test="${errors!=null}">
			<c:forEach var="error" items="${errors.allErrors}">
				<li><font color="red">${error.defaultMessage}</font></li>
			</c:forEach>
</c:if>
</ul>
<c:if test="${msg!=null}">
	<ul id="msg">
		<li>${msg}</li>
	</ul>
</c:if>