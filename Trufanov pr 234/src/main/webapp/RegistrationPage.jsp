<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Регистрация</title>
</head>
<body>

<form action="RegistrationServlet" method="POST">
	Укажите ваш логин:  <input type="text" name="Login"><br><br>
	Укажите ваш пароль:  <input type="password" name="Password"><br><br>
	Укажите вашу фамилию: <input type="text" name="UserSurname"><br>	<br>
	Укажите вашe имя:  <input type="text" name="UserName"><br><br>
	Укажите ваш пол: <input type="text" name="UserSex"><br><br>
	Укажите ваш телефон:  <input type="number" name="UserPhone"><br><br>
	Укажите ваш email:  <input type="email" name="UserEmail"><br><br>
	Укажите вашу страну:  <input type="text" name="UserCountry"><br><br>
	Укажите ваш город:  <input type="text" name="UserCity"><br><br>
	Укажите ваш возраст:  <input type="number" name="UserAge"><br><br>
	<button type="submit">Регистрация</button>	
</form>

</body>
</html>