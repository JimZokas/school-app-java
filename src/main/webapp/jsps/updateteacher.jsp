<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/updateteacher.css">
    <title>Update Teacher</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/updateteacher" method="POST">
            <label for="teacherform">Update Teacher</label>

            <input type="text" name="id" value="${teacher.id}" hidden="hidden">

            <input type="text" name="firstname" value="${teacher.firstname}">

            <input type="text" name="lastname" value="${teacher.lastname}">

            <button type="submit">UPDATE</button>
            <a href="${pageContext.request.contextPath}/teachers" id="returnbutton">CANCEL</a>    
        </form>
    </section>
</body>
</html>