<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/studentcourse.css">
      <title>Student Courses</title>
</head>
<body>
    <section id="students-table">
        <table>
            <thead>
                <tr>
                    <th hidden="hidden">${student.id}</th>
                    <th>${student.firstname} ${student.lastname}</th>
                </tr>
            </thead>
            <tbody>
                <tr><td>Courses</td></tr>
                <c:forEach var = "course" items = "${courses}">
                    <tr>
                        <td hidden="hidden">${course.id}</td>
				        <td>${course.description}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dropcourse?courseid=${course.id}&studentid=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Drop Course</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td id="addbutton"><a href="${pageContext.request.contextPath}/startcourse?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Add Course</a></td>
                </tr>
                <tr>
                    <td id="returnbutton"><a href="${pageContext.request.contextPath}/students">RETURN</a></td>
                </tr>
            </tbody>
        </table>
    </section>
</body>
</html>