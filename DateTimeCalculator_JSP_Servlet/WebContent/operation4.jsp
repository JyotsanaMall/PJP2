<html>
	<head>
		<title>Add/Subtract Months From Date</title>
	</head>
	
	<body>
		<h2>Add/Subtract Months From Date</h2>
		<form action="OperationServlet" method="get">
			<input type="hidden" name="choice" value="4" readonly>
			Enter Date (dd-m-yyyy): <input type="text" name="date">
			<br><br>
			Enter Months: <input type="text" name="months">
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