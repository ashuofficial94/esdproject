<%--
  Created by IntelliJ IDEA.
  User: ashutosh
  Date: 23/12/20
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="dashboard.jsp">Academic ERP</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="dashboard.jsp">Domains</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="add-domain.jsp">Add Domain</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link disabled" id="welcome-text"></a>
        </li>
        <li class="nav-item">
            <button type="submit" class="btn btn-danger btn-sm" id="logout">Logout</button>
        </li>
    </ul>
</nav>
