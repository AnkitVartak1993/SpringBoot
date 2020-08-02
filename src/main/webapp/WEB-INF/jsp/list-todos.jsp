<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>${name}'s Todo List</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <th>Description</th>
        <th>Target Date</th>
        <th>Completed</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a class="btn btn-danger" id="${todo.id}" name="${todo.id}" href="/delete-todo?id=${todo.id}">Delete</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-primary" href="/add-todo">Add new</a>
    </div>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</div>

</body>
</html>
