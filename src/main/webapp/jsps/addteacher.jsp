<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/addteacher.css">
    <title>Create Teacher</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/createteacher" method="POST">
            <label for="teacherform">Create Teacher</label>

            <input type="text" name="firstname"  placeholder="First name">

            <input type="text" name="lastname" placeholder="Last name">

            <button type="submit">CREATE</button>
            <a href="${pageContext.request.contextPath}/teachers" id="returnbutton">CANCEL</a>
        </form>
        
    </section> 
</body>
</html>
