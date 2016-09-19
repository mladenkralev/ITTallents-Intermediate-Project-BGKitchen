
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../menu/css/main.css" />
<%@ page contentType="text/html; charset=UTF-8"%>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
<ul>
			<li><a href="../index.html">Начало</a></li>
			<li><a href="#news">Меню</a></li>
			<li><a href="#contact">Contact</a></li>
			<li style="float:right"><a class="active" href="../registration/index.html">Регистрирай се</a></li>
			<li style="float:right"><a class="active" href="index.html">Вход</a></li>
		</ul>
<div class="main">
	<div>
		 <h2>Вход</h2>
		<form action="../log" method="get">
		   <div class="lable-2">
		        <input type="text" class="text" value="your@email.com " name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'your@email.com ';}">
		        <input type="password" class="text" value="Password " name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password ';}">
		   </div>
		   <div class="submit">
			  <input type="submit" onclick="myFunction()" value="Влизане" >
		   </div>
		   <div class="clear"> </div>
		</form>
		<!-----//end-main---->
		</div>
</body>
</html>