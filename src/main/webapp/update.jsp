<%--
  Created by IntelliJ IDEA.
  User: samoilovich_y
  Date: 03.12.2018
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update</title>
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
<div class="col-xs-12 col-sm-9">
    <form class="form-horizontal" role="form" method="POST" action="controller?action=/validateUpdate">
        <div class="form-group">
            <label for="cityId" class="col-sm-2 control-label">Id : </label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control" id="cityId" name="cityId"
                       placeholder="<%= session.getAttribute("cityId")%>" value="<%= session.getAttribute("cityId")%>">
                <br/>
            </div>
        </div>
        <div class="form-group">
            <label for="cityName"
                   <% if (session.getAttribute("actionCityName") == "errorInCityName") {%>class="col-sm-2 control-label error"
                   <%}else{%>class="col-sm-2 control-label"<%}%>>
                City Name :
            </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="cityName" name="cityName"
                       placeholder="<%= session.getAttribute("cityNames")%><%if (session.getAttribute("actionCityName") == "errorInCityName") {%>
                <% String string = (String) session.getAttribute("errorCityName");%>
                <% if (string != null) {%>
                <%=string%>
                <%}}%>"> <br/>
            </div>
        </div>

        <div class="form-group">
            <label for="population"
                   <% if (session.getAttribute("actionPopulation") == "errorInPopulation") {%>class="col-sm-2 control-label error"
                   <%}else{%>class="col-sm-2 control-label"<%}%>>
                Population :
            </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="population" name="population"
                       placeholder="<%= session.getAttribute("population")%><%if (session.getAttribute("actionPopulation") == "errorInPopulation") { String string = (String) session.getAttribute("errorPopulation");%>
            <% if (string != null) {%>
            <%=string%>
                <%}}%>">
            </div>
            <br/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Update City</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
