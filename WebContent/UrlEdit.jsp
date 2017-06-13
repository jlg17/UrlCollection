<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/UrlCollection/CollectionServlet?action=update" method="post">
			<input type="hidden" name="id" value="${urlBean.id }"/>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${urlBean.name }"/></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="url" value="${urlBean.url }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="update" /></td>
			</tr>


		</table>
	


	</form>
</body>
</html>