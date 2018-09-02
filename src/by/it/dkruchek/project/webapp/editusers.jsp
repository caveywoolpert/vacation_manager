<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <div class="container">
        <div class="row">
            <div class=col-md-2>Имя</div>
            <div class=col-md-2>Фамилия</div>
            <div class=col-md-2>Пароль</div>
            <div class=col-md-2>Email</div>
            <div class=col-md-1>Роль</div>
        </div>
    </div>

    <div class="container">
        <c:forEach items="${employees}" var="employee">
            <form class="update-user-${employee.id}" action="do?command=EditUsers" method=POST>
                <div class="row">
                    <input name="id" type="hidden" value="${employee.id}"/>
                    <div class=col-md-2>
                        <input id="name" class="form-control input-md" name="name"
                               value="${employee.name}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="lastname" class="form-control input-md" name="lastname"
                               value="${employee.lastname}"/>
                    </div>
                    <div class=col-md-2>
                        <input id="password" class="form-control input-md" name="password"
                               value="${employee.password}"/>
                    </div>
                    <div class=col-md-3>
                        <input id="email" class="form-control input-md" name="email"
                               value="${employee.email}"/>
                    </div>

                    <div class=col-md-2>
                        <select id="roles_id" name="roles_id" class="form-control">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}" role=${role.id} ${role.id==user.roles_id?"selected":""}>
                                        ${role.role}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <button id="Update" value="Update" name="Update" class="btn btn-success col-md-1">
                        Обновить
                    </button>

                    <button id="Delete" value="Delete" name="Delete" class="btn btn-danger col-md-1">
                        Удалить
                    </button>
                </div>
            </form>
            <p></p>
        </c:forEach>
    </div>

</div>
</body>

