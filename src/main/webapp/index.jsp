<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<body>
<h2>Hello from HTTP POST !</h2>
<form action="name" method="post" contentType="application/x-www-form-urlencoded">
    <div> Username <input type="text" name="username" value = ${username}> <div> <br>
    <div> Password <input type="password" name="password" value=${password}> <div> <br>
    <input type="submit" value="Submit">
     </form>
</body>
</html>
