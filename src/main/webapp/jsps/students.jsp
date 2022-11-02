<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/students.css">
    <title>Students</title>
</head>
<body>
    <section id="students-table">
        <table>
            <thead>
                <tr>
                    <th hidden="hidden">ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var = "student" items = "${students}">
			    <tr>
				    <td hidden="hidden">${student.id}</td>
				    <td>${student.firstname}</td>
				    <td>${student.lastname}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/updatestudent?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/deletestudent?id=${student.id}">Delete</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/studentcourses?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Courses</a>
                    </td>
			    </tr>
		    </c:forEach>
            <tr>
                <td id="addbutton"><a href="./jsps/addstudent.jsp">Add Student</a></td>
            </tr>
            <tr>
                <td id="returnbutton"><a href="./jsps/index.jsp">Return Home</a></td>
            </tr>
            </tbody>
        </table>
    </section>
</body>
</html>