<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Login ULima::</title>
<link rel="stylesheet" type="text/css" href="css/Estilos.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "http://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	window.fbAsyncInit = function() {
		FB.init({
			appId : '1809884605899449',
			cookie : true,
			xfbml : true,
			version : 'v2.0'
		});
	}

	function Ingresar() {
		FB.login(function(response) {
			validarUsuario();
		}, {
			scope : 'public_profile, email'
		});
	}
	function validarUsuario() {
		FB.getLoginStatus(function(response) {
			if (response.status == 'connected') {
				FB.api('/me', function(response) {
					alert('Hola ' + response.name);
					location = "Principal.jsp";
				});

			} else if (response.status == 'not_authorized') {
				alert('Debes autorizar la app!');
			} else {
				alert('Debes ingresar a tu cuenta de Facebook!');
			}
		});
		function logout() {
			FB.logout(function(response) {
				// user is now logged out

			});
			location = "Login.jsp";
		}
	}
</script>
</head>
<body>
	<div class="container-fluid" >		
		<form action="s01" method="post" class="form-group"
			style="padding: 20px; width: 300px; margin: 3% auto; font-style: inherit; font-family: Calibri;">
			<br> <img src="ULIMA_logo.png" class="img" height=150px width=130px 
				style="margin-left: 23%;"> <br> <br>
			
			<div>
				<label for="usr">Usuario:</label> <input type="text"
					class="form-control" name="usuario" placeholder="Código" required>
			</div>
			<br>
			<div>
				<label for="pwd">Contraseña:</label> <input type="password"
					class="form-control" name="pwd" placeholder="Contraseña">
			</div>
			<br> <br> <input class="btn btn-success"
				onclick="validar()" type="submit" value="Ingresar" id="boton1" /> <br>
			<br> <br>
		</form>
		<br>
		<img class="center-block" src="Logo SW2.PNG">
	</div>
	
</body>
</html>