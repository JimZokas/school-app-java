<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/done.css">   
    <title>After Page</title>
</head>
<body>
    <section id="success">
        <div>
            <span>Course updated successfully</span>
            <a href="${pageContext.request.contextPath}/courses">Return</a>
            <a href="./jsps/index.jsp" id="returnbutton">Return Home</a>
        </div>
    </section>
</body>
</html>