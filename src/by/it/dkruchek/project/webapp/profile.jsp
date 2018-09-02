<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
Привет ${employee.name} ${employee.lastname}!<br>
<br>
<br>
    <h2>Мои отпуска</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Начало</th>
            <th scope="col">Конец</th>
            <th scope="col">Апрувал</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vacation" items="${vacations}">
            <tr>
                <td>${vacation.startdate}</td>
                <td>${vacation.enddate}</td>
                  <c:choose>
                      <c:when test="${vacation.approved eq false}">
                           <td>Ожидает одобрения</td>
                      </c:when>
                      <c:otherwise>
                           <td>Одобрен</td>
                      </c:otherwise>
                  </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" class="btn btn-success">Завершить сеанс</button>
                </div>
            </div>
        </fieldset>
    </form>
    </div>
   </body>
</html>
