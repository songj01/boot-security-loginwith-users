<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Show Employees</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	      
	<h3 style="color: red;">Show All Employees</h3>
	<table  >
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.empId}</td>
				<td>${emp.empName}</td>

				<td><a href="/users/edit/${emp.empId}">Edit</a></td>
				<td><a href="/users/deleted/${emp.empId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>