<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.epam.service.Task"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU</title>
<script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#map').click(function() {
			var carNo = $('#textBox').val();
			var menu = $('input[name=menu]:checked').val();
			$.ajax({
				type : 'POST',
				data : {
					carNo : carNo,
					menu : menu
				},
				url : 'Menu',
				success : function(result) {
					$("#result1").load("menu.jsp #result1");
					$('#result').text(result);
				}
			});
		}),
		$("#search").on("keyup", function() {
				    var value = $(this).val().toLowerCase();
				    $("#searchDisplay tr").filter(function() {
				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				    });
				  }); 
	});
</script>
</head>
<body id="load">
	<div align="right">
		<br> <a href="index.html"><input type="button" name="logout"
			value="logout"></a><br>
	</div>
	<br>
	<br>
	<% String value = (String)request.getAttribute("val");
	if(value.equals("display")){ %>
	<div align="center">
		<h3>Search for vehicle</h3>
		<input type="text" id="search" placeholder="Search">
		<br><br>
	</div>
	<%} %>
	<% 
						
						if(value.equals("park")){
						%>
	<table style="width: 100%">
		<tr>
			<th colspan="2" align="left"><h1>MENU</h1></th>
		</tr>
		<tr>
			<td colspan="2">



				<form>
					<div align="left">
						<br> <br> <input type="radio" name="menu" value="park"
							id="menu" checked> Park<br> <br>
					</div>
					<%
						}
			 			else if(value.equals("unpark")){
						%>
					<div id="unpark">
						<input type="radio" name="menu" value="unpark" id="menu">
						UnPark<br> <br>
						<%} if(value.equals("unpark") || value.equals("park")){%>
					</div>
					<input type="text" id="textBox" name="carNo"
						placeholder="Enter Vehicle number"> <br> <br> <input
						type="button" name="submit" value="submit" id="map"><br>
					<br> <br>
					<%} %>
				</form>


			</td>
			<td>
				<%if(value.equals("display")){ %>
				<div id="result1">
				<h1>Display</h1><br><br>
					<table style="width: 100%" border="1" id="maptable">
						<thead>
							<tr>
								<th align="left">Slot</th>
								<th align="left">Vehicle</th>
							</tr>

						</thead>
						<tbody id="searchDisplay">
							<%
							HashMap<Integer, String> map = new Task().displayMap();
							for (Entry<Integer, String> set : map.entrySet()) {
							%>
							<tr>
								<td><br> <%
									    out.print(set.getKey());
									%></td>
								<td>
									<%
									    out.print(set.getValue());
									%> <br>
								</td>
							</tr>
							<%
							    }
							
							%>

						</tbody>
					</table>
				</div> <%} %> <br>

			</td>
		</tr>

	</table>
	<div id="result"></div>
	<br>

</body>
</html>