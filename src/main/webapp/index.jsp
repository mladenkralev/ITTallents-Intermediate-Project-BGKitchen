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

	<div class="table">
		<form action="" method="get">
			<table>
				<%
					TreeSet<Meal> result = new MealDAO().getMeals();
					for (Meal meal : result) {
				%>
				<tr>
					<td><p style="display: inline"><%=meal.getName()%></p></td>
				</tr>
				<tr>
					<td><img id="first" src="<%=meal.getPath()%>" /></td>
					<td><button name="order" type="submit" value="<%meal.getName();%>">Order</button></td>
				</tr>


				<%
					}
				%>

			</table>
		</form>
	</div>


</body>
</html>