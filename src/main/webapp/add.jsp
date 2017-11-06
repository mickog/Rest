<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST ASSIGNMENT</title>

  <link rel="stylesheet" href="standard.css">
  <link rel="stylesheet" href="form.css">
  
  
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
    <h1>Enter Values for a new CD</h1>

		<form action="myServlet" method="post">
		<ul class="form-style-1">
		<li><label>ID : <span class="required">*</span></label><input type="text" name="id" class="field-long"/>
		<li>
        <label>TITLE :<span class="required">*</span></label> <input type="text" name="title" class="field-long" />
        </li>
		<li>
        <label>DURATION :<span class="required">*</span></label> <input type="number" name="duration" /></p>
		<li>
        <label>ARTIST NAME : <span class="required">*</span></label><input type="text" name="artistName" /></p>
		</li>
		
    <li><input type="submit" name="submit" value="ADD" /></li>
	</form>
	</ul>

</body>
</html>
