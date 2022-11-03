<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <title>School App</title>
</head>
<body>
    <nav>
      <div id="logo">
        <span>School</span>
        <span>Managment</span>
        <span>App.</span>
      </div>

      <div id="nav-menu">
        <a href="${pageContext.request.contextPath}/teachers">Teachers</a>
        <a href="${pageContext.request.contextPath}/students">Students</a>
        <a href="${pageContext.request.contextPath}/courses">Courses</a>
      </div>
    </nav>

    <section id="main-section">
        <h1>Welcome to my application!</h1>

        <p>  
          Using the application menu, you can create, edit or delete your own entities of Teacher, Student and Course!<br>
          Search and manipulate your data by inserting Teachers and Students in the database, creating courses, and then adding students to those courses.<br> 
          Keep in mind the applications restrictions* listed bellow.<br><br>
          *Fields cannot be empty, and must be at least 3 characters long.<br>
          *A Course can't be Created without an existing Teacher.<br>
          *A Student must exist to participate in a Course.<br>
          *Deleting a Teacher, Student or Course will also delete their corresponding instances in all other tables of the database.<br>
        </p>
    </section>
</body>
</html>