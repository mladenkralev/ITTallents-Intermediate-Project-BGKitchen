<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="menu/css/main.css" />
<link rel="stylesheet" type="text/css" href="menu/css/cart.css" />
<title>Page Title</title>
</head>

<body>
	<ul>
		<li><a href="index.html">Начало</a></li>
		<li><a href="#news">Меню</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="Cart1.aspx" class="icon-shopping-cart"
			style="font-size: 25px"><asp:Label ID="lblCartCount"
					runat="server" CssClass="badge badge-warning" ForeColor="White" /></a></li>
	</ul>
</body>
</html>

