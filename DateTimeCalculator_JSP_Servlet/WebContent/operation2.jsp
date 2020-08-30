<html>
	<head>
		<title>Add/Subtract Days From Date</title>
	</head>
	
	<body>
		<h2>Add/Subtract Days From Date</h2>
		<form action="OperationServlet" method="get">
		<input type="hidden" name="choice" value="2" readonly>
			Enter Date (dd-m-yyyy): <input type="text" name="date">
			<br><br>
			Enter Days: <input type="text" name="days">
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