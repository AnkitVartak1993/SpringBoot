<html>
<title>Login page Title</title>
<head>
  <jsp:include page="partials/header.jsp"/>
</head>
  <body>
  <font color="red">${errorMessage}</font>
  <div class="container">
    <form method="post">
      <fieldset class="form-group">
        <label>Name</label>
        <input class="form-control" type="text" id="name" name="name"/>
      </fieldset>
      <fieldset class="form-group">
        <label>Password</label>
        <input class="form-control" type="password" name="password"/>
      </fieldset>
      <div class="form-group">

          <button class="btn btn-primary" type="submit">Login</button>
      </div>
    </form>
  </div>

  </body>
</html>
