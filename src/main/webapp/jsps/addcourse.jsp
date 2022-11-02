<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/addcourse.css">
    <title>Create Course</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/createcourse" method="POST">
            <label for="courseform">Create Course</label>

            <input type="text" name="description"  placeholder="Description">

            <select name="teacherid" id="teacherid">
            	<option value="" selected disabled hidden="hidden">Choose Teacher</option>
            	<c:forEach var = "teacher" items = "${teachers}">
                	<option value="${teacher.id}">${teacher.firstname} ${teacher.lastname}</option> 
                </c:forEach>              
            </select>

            <button type="submit">CREATE</button>
            <a href="${pageContext.request.contextPath}/courses" id="returnbutton">CANCEL</a> 
        </form>
    </section>
</body>
</html>