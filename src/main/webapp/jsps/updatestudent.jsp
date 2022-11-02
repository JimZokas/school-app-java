<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/updatestudent.css">
    <title>Update Student</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/updatestudent" method="POST">
            <label for="studentform">Update Student</label>

            <input type="text" name="id" value="${student.id}" hidden="hidden">

            <input type="text" name="firstname" value="${student.firstname}">

            <input type="text" name="lastname" value="${student.lastname}">

            <button type="submit">UPDATE</button>
            <a href="${pageContext.request.contextPath}/students" id="returnbutton">CANCEL</a>
            
            <c:if test="${EmptyField}">
    			<span style="color: red;">Fields must not be empty</span>
    		</c:if>
    		
    		<c:if test="${FieldLength}">
    			<span style="color: red;">Fields must be at least 3 characters long</span>
    		</c:if>
    		
    		<c:if test="${SQLError}">
    			<span style="color: red;">SQL ERROR</span>
    		</c:if>
        </form>
    </section>
</body>
</html>