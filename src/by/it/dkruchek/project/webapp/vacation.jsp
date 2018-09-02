<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" method="POST" action="do?command=Vacation">
<fieldset>

<!-- Form Name -->
<legend>Выбери даты планируемого отпуска</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Начало</label>
  <div class="col-md-4">
  <input id="start_date" name="start_date" type="date" class="form-control input-md" required=""
  min=${tomorrow}>
  <span class="help-block">${add_vacation}</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="end_date">Конец</label>
  <div class="col-md-4">
  <input id="end_date" name="end_date" type="date" class="form-control input-md" required=""
  max=${tomorrow_p_1}>
  <span class="help-block">${end_date}</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="addVacation"></label>
  <div class="col-md-4">
    <button id="addVacation" name="addVacation" class="btn btn-info">Добавить</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>