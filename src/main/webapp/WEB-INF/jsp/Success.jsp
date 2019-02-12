<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
<tr><th>Id</th><th>Name</th><th>City</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>

<c:forEach var="listpersons" items="${listperson}">
<tr>
<td>
<c:out value="${listpersons.id}"></c:out></td>
<td><c:out value="${listpersons.name}"></c:out></td>
<td><c:out value="${listpersons.code}"></c:out></td>
<td><a href="editemployee?id=${listpersons.id}">Edit</a></td>
<td><a href="deleteemployee?id=${listpersons.id}">Delete</a></td>
</tr>
</c:forEach>

</table>
<a href="viewemp?page=1">Next</a>
<a href="viewemp?page=0">Prev</a>

</body>
</html>