<%@ include file="common/header.jspf"%>
<div class="container">
		<h2>Add/Subtract Years From Date</h2>
		<form:form action="/calculate" method="post" commandName="calculatorDetails">
			
			<input type="hidden" name="choice" value="5" readonly>
			<fieldset class="form-group">
				<form:label path="date1">Enter Date</form:label>
				<form:input path="date1" type="text" required="required"/>
				<br><br>
				<form:label path="years">Enter Years</form:label>
				<form:input path="years" type="text" required="required"/>
				<br><br>
				<form:label path="operation">Enter (+/-)</form:label>
				<form:input path="operation" type="text"/>
				<br><br>
			</fieldset>
			<input class="btn btn-success" type="submit" value="Calculate">
		</form:form>
		<br><br>
		
		<a href="/menuOptions">Back to menu</a>
</div>
<%@ include file="common/footer.jspf"%>