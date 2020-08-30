<html>
	<head>
		<title>Add/Subtract Two Dates</title>
	</head>
	
	<body>
		<h2>Add/Subtract Two Dates</h2>
		<form action="OperationServlet" method="get">
			<input type="hidden" name="choice" value="1" readonly>
			Enter Date 1 (dd-m-yyyy): <input type="text" name="date1">
			<br><br>
			Enter Date 2 (dd-m-yyyy): <input type="text" name="date2">
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