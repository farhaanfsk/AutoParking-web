<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<form action = "ReloadFile" method = "GET">
		<br><h1>Choose a option</h1><br>
		<br>
		
		<input type="radio" name="option" value="1" onclick = "hideTextBox()"  checked> Get old data<br><br>
  		<input type="radio" name="option" value="2" onclick = "displayTextBox()"> Refresh parking<br>
  		<br><input type = "text"  hidden = "true" id = "textBox" name = "size" placeholder = "Enter slot size"/><br>
  		<input type="submit" name="submit" value = "submit">
	</form>
	</div>
	<script type = "text/javascript">
		function displayTextBox(){
			
			document.getElementById('textBox').style.display = 'block';
		}
		function hideTextBox(){
			document.getElementById('textBox').style.display = 'none';
		}
	</script>
</body>
</html>