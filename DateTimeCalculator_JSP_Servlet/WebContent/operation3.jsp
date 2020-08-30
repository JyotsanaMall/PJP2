<html>
	<head>
		<title>Add/Subtract Weeks From Date</title>
	</head>
	
	<body>
		<h2>Add/Subtract Weeks From Date</h2>
		<form action="OperationServlet" method="get">
			<input type="hidden" name="choice" value="3" readonly>
			Enter Date (dd-m-yyyy): <input type="text" name="date">
			<br><br>
			Enter Weeks: <input type="text" name="weeks">
			<br><br>
			<input type="radio" name="operation" value="+"> Add
			<input type="radio" name="operation" value="-"> Subtract
			<br><br>
			<input type="submit" value="Calculate">
		</form>
		<br><br>
		<a href="operations.html">Back to menu</a>
	</body>
</html>