<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/users/edit/" method="post" >
		   <input type="text" name="empId" value=${empl.empId} />
			<input type="text" name="empName" value=${empl.empName} />
			<button type="submit">submit</button>
		</form>
	</div>
</body>
</html>