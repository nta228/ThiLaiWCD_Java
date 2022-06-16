<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Tuấn Anh
  Date: 6/16/2022
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fpt.aptech.thilaiwcd_java.entity.Employee" %><%
    Employee employee =(Employee) request.getAttribute("employee");
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
    <div class="w3-panel w3-green">
        <h2 class="w3-opacity">Employee table</h2>
    </div>
    <div>Full name: <%= employee.getFullName()%></div>
    <div>Birthday: <%= employee.getBirthday()%></div>
    <div>Address: <%= employee.getAddress()%></div>
    <div>Position: <%= employee.getPosition()%></div>
    <div>Department: <%= employee.getDepartment()%></div>
</div>

</body>
</html>

