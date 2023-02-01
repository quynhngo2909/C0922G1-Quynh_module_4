<%--
  Created by IntelliJ IDEA.
  User: Dieu Quynh
  Date: 2/1/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<table>
    <tr>
        <th colspan="2">Sandwich Condiments:</th>
    </tr>
    <c:forEach var="condiment" items="${condiments}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${condiment}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
