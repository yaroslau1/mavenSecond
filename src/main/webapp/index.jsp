<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page import="com.work.servlets.ControllerServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: samoilovich_y
  date: 30.11.2018
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Show All Cities</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/mystyles.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap-social.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">list of cities</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#"><span class="glyphicon glyphicon-home"
                                                 aria-hidden="true"></span> Show all</a></li>

            <li><a href="http://localhost:8081/login.jsp">Log in</a></li>
            <li><a href="http://localhost:8081/signin.jsp">Sign in</a></li>
            <li><a href="http://localhost:8081/controller">Get All Cities</a></li>
            <li><a href="http://localhost:8081/users.jsp">Users</a></li>
        </ul>
    </div>
</nav>
<br/>
<h1>Hello, <%=session.getAttribute("userName")%></h1>
<br/><br/>
<form action="insert.jsp" method="post">
    <button type="submit">Insert</button>
</form>
<form action="controller?action=/validateFindByName" method="post">
    <input type="text" name="cityName" placeholder="Minsk">
    <button type="submit">Find</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>City Name</th>
        <th>Population</th>
        <th>Country Code</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.cities}" var="cityName">
        <tr>
            <td><c:out value="${cityName.getName()}"/></td>
            <td><c:out value="${cityName.getPopulation()}"/></td>
            <td><c:out value="${cityName.getCountryCode()}"/></td>
            <td>
                <form action="update.jsp?cityId=${cityName.getId()}&population=${cityName.getPopulation()}"
                      method="post">
                    <button type="submit">
                        Update
                    </button>
                </form>
            </td>
            <td>
                <form action="controller?action=/delete&cityId=${cityName.getId()}" method="post">
                    <button type="submit">
                        Delete
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
