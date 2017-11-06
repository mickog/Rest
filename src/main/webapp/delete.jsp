<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST ASSIGNMENT</title>
  <link rel="stylesheet" href="standard.css">
  
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">REST Assignment</a>
    </div>
    <ul class="nav navbar-nav">
<li><a href="add.jsp">CREATE</a></li>
    <li><a href="/rest/myServlet">READ ALL</a></li>
    <li><a href="delete.jsp">DELETE</a></li>
    <li><a href="update.jsp">UPDATE</a></li>
    <li><a href="readOne.jsp">READ ONE</a></li>
    </ul>
  </div>
</nav>
<h1>Delete Page</h1>

<hr>
<form action="myServlet" method="post">
    Enter an ID: <input type="text" name="id" size="20">
    <input type="submit" name="submit" value="DELETE" />
</form>
<hr>

</body>
</html>