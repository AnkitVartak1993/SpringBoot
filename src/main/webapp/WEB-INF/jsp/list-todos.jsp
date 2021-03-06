<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${name}'s Todo List</title>
    <jsp:include page="partials/header.jsp"/>
    <jsp:include page="partials/navbar.jsp"/>
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
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                <td>${todo.done}</td>
                <td><a class="btn btn-success"  href="/update-todo?id=${todo.id}">Edit</a> </td>
                <td><a class="btn btn-danger" id="${todo.id}" name="${todo.id}" href="/delete-todo?id=${todo.id}">Delete</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-primary" href="/add-todo">Add new</a>
    </div>
</div>

</body>
</html>
