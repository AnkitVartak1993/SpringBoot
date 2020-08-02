<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo</title>
    <jsp:include page="partials/header.jsp"/>
</head>
<body>
<div class="container">
    <form method="post">
        <fieldset class="form-group">Description:
            <input class="form-control" required="required" type="text" id="todo_description" name="todoDescription"/>
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form>
</div>

</body>
</html>
