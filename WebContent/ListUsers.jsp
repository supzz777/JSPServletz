<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
	String id = request.getParameter("userId");
	String driver = "com.mysql.jdbc.Driver";
	String Url = "jdbc:mysql://localhost:3306/supzz";

	String user = "root";
	String password = "password";

	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<h2 align="center">
	<font><strong>Retrieve data from database in jsp</strong></font>
</h2>
<form>
	<table align="left" cellpadding="3" cellspacing="3" border="1">
		<tr>

		</tr>
		<tr bgcolor="#cecfba">

			<td><b>username</b></td>
			<td><b>Password</b></td>
			<td><b>Name</b></td>

		</tr>
		<%
			try {
				connection = DriverManager.getConnection(Url, user, password);
				statement = connection.createStatement();
				String sql = "SELECT * FROM customer";

				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr bgcolor="#9fa17c">


			<td><%=resultSet.getString("username")%></td>
			<td><%=resultSet.getString("password")%></td>
			<td><%=resultSet.getString("name")%></td>


		</tr>

		<%
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	table>
</form>