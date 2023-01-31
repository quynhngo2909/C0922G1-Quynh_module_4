<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>English-Vietnamese Dictionary</title>
</head>
<body>
<h1>Tra cứu từ điển Anh-Việt</h1>
<form method="post">
<table>
    <tr>
        <td>Tiếng Anh</td>
        <td><input name="lookUpWord" placeholder="Nhập từ cần tra cứu"></td>
    </tr>
    <tr>
        <td>Tiếng Việt</td>
        <td><input name="translateWord" value="${translateWord}"></td>
    </tr>
</table>
<button>Tra cứu</button>
</form>
</body>
</html>