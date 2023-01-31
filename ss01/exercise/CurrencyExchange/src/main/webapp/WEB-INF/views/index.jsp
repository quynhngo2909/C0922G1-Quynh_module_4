<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - Currency Exchange</title>
</head>
<body>
<h1><%= "Currency Exchange: USD TO VND" %>
</h1>
<form method="post">
    <table>
        <tr>
            <td>Tỷ giá</td>
            <td><input type="number" name="exchangeRate" value="23000" placeholder="${exchangeRate}"></td>
        </tr>
        <tr>
            <td>Số lượng USD cần chuyển đổi</td>
            <td><input type="number" name="usdAmount" placeholder="${usdAmount}"></td>
        </tr>
    </table>
    <button>Chuyển đổi</button>
</form>
<p>Kết quả: ${vnd}VND</p>
</body>
</html>