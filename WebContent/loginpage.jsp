<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form Action="LoginRegister" method="post">
		<table
			style="background-color: #3d7591; margin-left: 50px; margin-top: 50px">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><h3 style="color: #242c30;">Welcome Please Login
						Here!!</h3></td>
			</tr>
			<tr>
				<td><h3 style="color: #294e61;">${successMessage}</h3></td>
			</tr>

			<tr>
				<td><h3 style="color: #87bad4;">${message}</h3></td>
			</tr>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" value="Login"></td>
				<td><a href="register.jsp">Registration</a></td>
			</tr>

		</table>
	</form>






</body>
</html>