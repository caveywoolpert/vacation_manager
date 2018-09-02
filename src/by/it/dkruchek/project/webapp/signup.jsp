<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="POST" action="do?command=SignUp">
<fieldset>

<!-- Form Name -->
<legend>Sign Up form</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Name</label>
  <div class="col-md-4">
  <input id="textinput" name="name" type="text" placeholder="Name" class="form-control input-md" required=""
  value="testName">
  <span class="help-block">${help_name}</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="lastname">Lastname</label>
  <div class="col-md-4">
  <input id="lastname" name="lastname" type="text" placeholder="Lastname" class="form-control input-md" required=""
  value="testLastname">
  <span class="help-block">${help_lastname}</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="password" type="password" placeholder="password" class="form-control input-md" required=""
    value="testPassword">
    <span class="help-block">${help_password}</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">E-mail</label>
  <div class="col-md-4">
  <input id="textinput" name="email" type="text" placeholder="e-mail" class="form-control input-md" required=""
  value="test@email.com">
  <span class="help-block">${help_email}</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-success">Sign-up</button>
  </div>
</div>
</fieldset>
</form>
</div>
</body>
</html>




