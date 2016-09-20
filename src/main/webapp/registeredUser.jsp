<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="menu/css/main.css" />
<link rel="stylesheet" type="text/css" href="menu/css/cart.css" />
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="food.meal.MealDAO"%>
<%@ page import="food.meal.Meal"%>
<%@ page import="java.util.TreeSet"%>
<title>Page Title</title>
</head>

<body>
	<ul>
		<li><a href=".">Начало</a></li>
		<li><a href="./info">За нас</a></li>
	</ul>



	<div class="table">
		<form action="./order" method="get">
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
					<td><button name="order" type="submit"
							value="<%=meal.getName()%>">Order</button></td>
				</tr>


				<%
					}
				%>

			</table>
		</form>
	</div>
</body>
</html>

