<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/updatecourse.css">
    <title>Update Course</title>
</head>
<body>
    <section id="teacher-form">
        <form action="${pageContext.request.contextPath}/updatecourse" method="POST">
            <label for="teacherform">Update Course</label>

            <input type="text" name="id" value="${course.id}" hidden="hidden">

            <input type="text" name="description" value="${course.description}">
            
            <input type="text" name="teacherid" hidden="hidden" value="${course.teacherId}">
            
            <select name="teacherid" id="teacherid">
            	<c:forEach var = "teacher" items = "${teachers}">
            		<c:choose>
            			<c:when test="${course.teacherId == teacher.id}">
            				<option value="${teacher.id}" selected>${teacher.firstname} ${teacher.lastname}</option>
            			</c:when>
            			<c:otherwise>
            				<option value="${teacher.id}">${teacher.firstname} ${teacher.lastname}</option>
            			</c:otherwise>
            		</c:choose>
                </c:forEach>              
            </select>

            <button type="submit">UPDATE</button>
            <a href="${pageContext.request.contextPath}/courses" id="returnbutton">CANCEL</a>
        </form>
    </section>
</body>
</html>