<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="calculate" method="post">
<input name="value1" type="number" placeholder="${value1}">
<input name="value2" type="number" placeholder="${value2}">
<br>
<button name="cal" value="add" type="submit">Addtion</button>
<button name="cal" value="subtract" >Subtraction</button>
<button name="cal" value="multiply">Multiplication</button>
<button name="cal" value="divide">Division</button>
</form>
</body>
<p>Result ${math}: ${result}</p>
</html>