<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Авторизация</title>
</head>
<body>
<form action="LoginServlet" method="POST">
Логин  <input type="text" name="Login"><br><br>
Пароль  <input type="password" name="Password"><br><br>
<button type="submit">Войти</button>	
</form>
</body>
</html>