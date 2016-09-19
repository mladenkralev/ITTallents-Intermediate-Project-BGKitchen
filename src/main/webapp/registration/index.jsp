
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../menu/css/main.css" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<%@ page contentType="text/html; charset=UTF-8"%>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<form>
		<ul id="header">
			<li><a href="../">Начало</a></li>
			<li><a href="#">За нас</a></li>
			<li style="float: right"><a class="active" href="."">Регистрирай
					се</a></li>
			<li style="float: right"><a class="active" href="../login/">Вход</a></li>
		</ul>
	</form>
	<div class="main">
		<div>
			<h2>Регистрация</h2>
			<form action="../reg" method="get">
				<div class="lable">
					<div class="col_1_of_2 span_1_of_2">
						<input type="text" class="text" value="Georgi" name="name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'First Name';}"
							id="active">
					</div>
					<div class="col_1_of_2 span_1_of_2">
						<input type="text" class="text" value="Purvanov" name="fname"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Last Name';}">
					</div>
					<div class="clear"></div>
				</div>
				<div class="lable-2">
					<input type="text" class="text" value="your@email.com "
						name="email" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'your@email.com ';}">
					<input type="password" class="text" name="password"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Password ';}">
				</div>
				<div class="submit">
					<input type="submit" onclick="myFunction()" value="Създай акаунт">
				</div>
				<div class="clear"></div>
			</form>
			<!-----//end-main---->
		</div>
</body>
</html>