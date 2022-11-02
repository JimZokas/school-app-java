<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/courses.css">
    <title>Courses</title>
</head>
<body>
    <section id="courses-table">
        <table>
            <thead>
                <tr>
                    <th hidden="hidden">ID</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var = "course" items = "${courses}">
			    <tr>
				    <td hidden="hidden">${course.id}</td>
				    <td>${course.description}</td>
				    <td hidden="hidden">${course.teacherId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/updatecourse?id=${course.id}&description=${course.description}&teacherid=${course.teacherId}">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/deletecourse?id=${course.id}">Delete</a>
                    </td>
			    </tr>
		    </c:forEach>
            <tr>
                <td id="addbutton"><a href="${pageContext.request.contextPath}/createcourse">Add Course</a></td>
            </tr>
            <tr>
                <td id="returnbutton"><a href="./jsps/index.jsp">Return Home</a></td>
            </tr>
            <c:if test="${EmptyList}">
            	<tr>
    				<td style="color: red;">No teacher exists</td>
    			</tr>
    		</c:if>
    		<c:if test="${SQLError}">
            	<tr>
    				<td style="color: red;">Error in SQL</td>
    			</tr>
    		</c:if>
            </tbody>
        </table>
    </section>
</body>
</html>