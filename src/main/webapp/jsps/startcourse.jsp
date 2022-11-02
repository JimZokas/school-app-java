<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/startcourse.css">
    <title>Start Course</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/startcourse" method="POST">
            <label for="studentcourseform">Start Course</label>

            <input type="text" name="studentid" value="${student.id}" hidden="hidden">

            <input type="text" name="firstname" value="${student.firstname}">

            <input type="text" name="lastname"  value="${student.lastname}">
            
            <select name="courseid" id="courseid">
            		<option value="" selected disabled hidden="hidden">Choose Course</option>
            		<c:forEach var = "course" items = "${courses}">
                		<option value="${course.id}">${course.description}</option> 
                	</c:forEach>
			</select>
			
            <button type="submit">START COURSE</button>
            <a href="${pageContext.request.contextPath}/studentcourses?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" id="returnbutton">CANCEL</a>                     
        </form>
    </section>
</body>
</html>