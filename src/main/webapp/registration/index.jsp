
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<%@ page contentType="text/html; charset=UTF-8" %>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<ul id="header">
		<li><a href="#">HOME</a></li>
		<li><a href="#">ABOUT US</a></li>
		<li><a href="#">TEST</a></li>
		<li><a href="#">TEST</a></li>
	</ul>
	<div class="main">
		<div>
			<h2>Регистрация</h2>
			<form action= "../reg" method="get">
				<div class="lable">
					<div class="col_1_of_2 span_1_of_2">
						<input type="text" class="text" value="Име"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'First Name';}"
							id="active">
					</div>
					<div class="col_1_of_2 span_1_of_2">
						<input type="text" class="text" value="Фамилия"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Last Name';}">
					</div>
					<div class="clear"></div>
				</div>
				<div class="lable-2">
					<input type="text" class="text" value="your@email.com "
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'your@email.com ';}">
					<input type="password" class="text" value="Password "
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