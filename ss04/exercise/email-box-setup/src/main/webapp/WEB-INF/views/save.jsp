<%--
  Created by IntelliJ IDEA.
  User: Dieu Quynh
  Date: 2/2/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Setting</title>
</head>
<body>
<h2>Email box</h2>
<p>${message}</p>
    <table>
      <tr>
        <td>Languages:</td>
        <td>${emailBoxSetting.language}</td>
      </tr>
      <tr>
        <td>Page Size:</td>
        <td>
          <span>Show </span>${emailBoxSetting.pageSize}<span> emails per page</span>
        </td>
      </tr>
      <tr>
        <td>Spams filter:</td>
        <td>${emailBoxSetting.spamsFilter}</td>
      </tr>
      <tr>
        <td>Signature:</td>
        <td>${emailBoxSetting.signature}</td>
      </tr>
    </table>
</body>
</html>
