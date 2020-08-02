<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>${name}'s Todo List</title>
</head>
<body>
<table>
    <caption>Your todo list</caption>
    <thead>
    <th>Description</th>
    <th>Target Date</th>
    <th>Completed</th>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.desc}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
        </tr>
    </c:forEach>
    
    </tbody>
</table>
 List to be shown
${todos}
<a href="/add-todo">Add new</a>
</body>
</html>
