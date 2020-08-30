<html>
	<head>
		<title>Add/Subtract Years From Date</title>
	</head>
	
	<body>
		<h2>Add/Subtract Years From Date</h2>
		<form action="OperationServlet" method="get">
			<input type="hidden" name="choice" value="5" readonly>
			Enter Date (dd-m-yyyy): <input type="text" name="date">
			<br><br>
			Enter Years: <input type="text" name="years">
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