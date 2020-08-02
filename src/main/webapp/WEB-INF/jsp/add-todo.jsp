<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Todo</title>
    <jsp:include page="partials/header.jsp"/>
</head>
<body>
<div class="container">
    <form:form method="post" modelAttribute="todo">
        <fieldset class="form-group">
            <form:label path="desc">Description:</form:label>
            <form:input path="desc" class="form-control" required="required" type="text" id="todo_description"/>
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>

</body>
</html>
