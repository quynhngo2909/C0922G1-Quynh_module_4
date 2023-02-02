<%--
  Created by IntelliJ IDEA.
  User: Dieu Quynh
  Date: 2/2/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h2>Email box</h2>
<p>${message}</p>
<form:form action="/setting" method="post" modelAttribute="emailBoxSetting">
  <fieldset>
    <legend><b>Settings</b></legend>
    <table>
      <tr>
        <td><form:label path="language"> Languages</form:label></td>
        <td><form:select path="language">
          <form:options  items="${languages}"/>
        </form:select></td>
      </tr>
      <tr>
        <td><form:label path="pageSize">Page Size</form:label></td>
        <td>
          <span>Show </span>
          <form:select path="pageSize" items="${pageSizes}"/>
          <span> emails per page</span>
        </td>
      </tr>
      <tr>
        <td><form:label path="spamsFilter">Spams filter</form:label></td>
        <td><form:checkbox path="spamsFilter" value="0"/>Enable spams filter</td>
      </tr>
      <tr>
        <td><form:label path="">Signature</form:label></td>
        <td><form:textarea path="signature"/></td>
      </tr>
      <tr>
        <td></td>
        <td><button type="submit">Save</button></td>
      </tr>
    </table>
  </fieldset>
</form:form>
</body>
</html>
