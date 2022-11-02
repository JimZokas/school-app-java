<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/teachers.css">
    <title>Teachers</title>
</head>
<body>
    <section id="teachers-table">
        <table>
            <thead>
                <tr>
                    <th hidden="hidden">ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var = "teacher" items = "${teachers}">
			    <tr>
				    <td hidden="hidden">${teacher.id}</td>
				    <td>${teacher.firstname}</td>
				    <td>${teacher.lastname}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/updateteacher?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/deleteteacher?id=${teacher.id}">Delete</a>
                    </td>
			    </tr>
		    </c:forEach>
            <tr>
                <td id="addbutton"><a href="./jsps/addteacher.jsp">Add Teacher</a></td>
            </tr>
            <tr>
                <td id="returnbutton"><a href="./jsps/index.jsp">Return Home</a></td>
            </tr>
            </tbody>
        </table>
        <c:if test="${SQLError}">
    			<span style="color: red;">SQL ERROR</span>
    	</c:if>
    </section>
</body>
</html>