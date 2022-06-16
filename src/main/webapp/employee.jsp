<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Tuấn Anh
  Date: 6/16/2022
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="fpt.aptech.thilaiwcd_java.entity.Employee" %>
<%@ page import="java.util.HashMap" %>
<%
    Employee employee = (Employee) request.getAttribute("employee");
    if(employee == null){
        employee = new Employee();
    }
    HashMap<String, String> errors = (HashMap<String, String>)request.getAttribute("errors");
    if(errors == null){
        errors = new HashMap<>();
    }
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<form action="/employee" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
    <h2 class="w3-center">Create employee form</h2>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="fullName" type="text" placeholder="Full Name" value="<%=employee.getFullName()%>">
            <%
                if(errors.containsKey("fullName")){
            %>
            <span class="w3-text-red">* <%=errors.get("fullName")%></span>
            <%}%>
        </div>
    </div>

    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="birthday" type="date" placeholder="Birthday">
            <%
                if(errors.containsKey("birthday")){
            %>
            <span class="w3-text-red">* <%=errors.get("birthday")%></span>
            <%}%>
        </div>
    </div>
    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="address" type="text" placeholder="Address">
            <%
                if(errors.containsKey("address")){
            %>
            <span class="w3-text-red">* <%=errors.get("address")%></span>
            <%}%>
        </div>
    </div>
    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="position" type="text" placeholder="Position">
            <%
                if(errors.containsKey("position")){
            %>
            <span class="w3-text-red">* <%=errors.get("position")%></span>
            <%}%>
        </div>
    </div>
    <div class="w3-row w3-section">
        <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
        <div class="w3-rest">
            <input class="w3-input w3-border" name="department" type="text" placeholder="Department">
            <%
                if(errors.containsKey("department")){
            %>
            <span class="w3-text-red">* <%=errors.get("department")%></span>
            <%}%>
        </div>
    </div>

    <p class="w3-center">
        <button type="submit" class="w3-button w3-section w3-blue w3-ripple"> Save </button>
        <button type="reset" class="w3-button w3-section w3-blue w3-ripple"> Reset </button>
    </p>
</form>

</body>
</html>
