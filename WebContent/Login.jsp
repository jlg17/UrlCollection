<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"  %>
<%@page import="java.util.ArrayList"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function del(){
		if( confirm("are you sure to delete all these items?")){
			var f = document.forms[1];
			f.action="/UrlCollection/CollectionServlet?action=delete";
			f.submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
<form action="/UrlCollection/CollectionServlet?action=save" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="url" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="save" /></td>
			</tr>


		</table>

	</form>
<hr/>
<form action="/UrlCollection/CollectionServlet?action=delete" method ="post">

		<c:forEach var="u" items="${list }">
		<c:out value="${u.id }"></c:out>
		<c:out value="${u.name }"></c:out>
		<a href="${u.url }">${u.url }</a>
		<a href="/UrlCollection/CollectionServlet?action=get&id=${u.id }">Edit</a>
		<input type="checkbox" name="ids" value="${u.id }"/>
		<br/>
			
	</c:forEach>
	<input type="button" value="delete" onclick="del()">
</form>


</body>
</html>