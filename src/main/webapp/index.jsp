<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="menu/css/main.css" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="food.meal.MealDAO"%>
<%@ page import="food.meal.Meal"%>
<%@ page import="java.util.TreeSet"%>
<title>Page Title</title>
</head>

<body>
	<form>
		<ul id="header">
			<li><a href=".">HOME</a></li>
			<li><a href="#">ABOUT US</a></li>
			<li style="float: right"><a class="active" href="registration/"">Регистрирай
					се</a></li>
			<li style="float: right"><a class="active" href="login/">Вход</a></li>
		</ul>
	</form>

	<div class = "table" >
			<%
				TreeSet<Meal> result = new MealDAO().getMeals();
				for (Meal meal : result) {
					
			%>
				
			<img id = "first" src = "<%= meal.getPath()%>"/>
			<p  style="display:inline"><%=meal.getName()%></p>
			<%
				}
			%>
	</div>

</body>
</html>