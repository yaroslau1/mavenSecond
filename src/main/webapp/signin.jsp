<%--
  Created by IntelliJ IDEA.
  User: samoilovich_y
  Date: 23.01.2019
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign In</title>
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
            <li><a href="http://localhost:8081/index.jsp">Show all</a></li>

            <li><a href="http://localhost:8081/login.jsp">Log in</a></li>
            <li class="active"><a href="#"><span class="glyphicon glyphicon-inbox"
                                                 aria-hidden="true"></span>Sign in</a></li>
            <li><a href="http://localhost:8081/controller">Get All Cities</a></li>
            <li><a href="http://localhost:8081/users.jsp">Users</a></li>
        </ul>
    </div>
</nav>
<br/><br/><br/>
<div class="col-xs-12 col-sm-9">
    <form class="form-horizontal" role="form" method="POST" action="controller?action=/signIn">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name : </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name"
                       placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">Age : </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="age" name="age"
                       placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <label for="pass" class="col-sm-2 control-label">Password : </label>
            <div class="col-sm-10">
                <input type="password" hidden class="form-control" id="pass" name="pass"
                       placeholder="Enter password">
            </div>
        </div>
        <div class="form-group">
            <label for="passConf" class="col-sm-2 control-label">Confirm password : </label>
            <div class="col-sm-10">
                <input type="password" hidden class="form-control" id="passConf" name="passConf"
                       placeholder="Enter password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
