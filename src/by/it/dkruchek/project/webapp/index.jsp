<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<c:choose>
    <c:when test="${employee!=null}">
    <div class="month">
      <ul>

          <form method="post" action="do?command=Index">
              <fieldset>
                  <!-- Button -->
                  <div>
                      <div >
                            <button id="prev" name="prev" class="prev">&#10094;</button>
                      </div>
                  </div>
              </fieldset>

                <form method="post" action="do?command=Index">
                    <fieldset>
                        <!-- Button -->
                        <div>
                            <div >
                                   <button id="next" name="next" class="next">&#10095;</button>
                            </div>
                        </div>
                    </fieldset>

        <li>${curr_month_name}<br><span style="font-size:18px">${curr_year}</span></li>
      </ul>
    </div>
<table class="table" border="1" style="table-layout: fixed; width: 100%;">
  <tbody>
  <c:forEach var="entry" items="${full_list}">
    <tr>
      <td class="employee" style="width: 20%;">${entry.key.name} ${entry.key.lastname}</td>
      <c:forEach begin="1" end="${curr_month_days}" varStatus="loop">
        <c:choose>
            <c:when test="${entry.value!=null}">

                <c:set var="contains" value="false" />
                <c:forEach var="day" items="${entry.value.dates}">
                  <c:if test="${day eq loop.index}">
                    <c:set var="contains" value="true" />
                  </c:if>
                </c:forEach>

                <c:choose>
                    <c:when test="${contains}">
                        <td class="days_vacation">${loop.index}</td>
                    </c:when>
                    <c:otherwise>
                        <td class="days">${loop.index}</td>
                    </c:otherwise>
                </c:choose>

            </c:when>
            <c:otherwise>
            <td class="days">${loop.index}</td>
            </c:otherwise>
        </c:choose>
      </c:forEach>
    </tr>
  </c:forEach>
  </tbody>
</table>
</c:when>
<c:otherwise>
<br>
<br>
    <h2><center>Календарь отпусков</center><h2>
    <br>
    <img src="include/assets/vacation.jpg" alt="Time to rest" class="center">
    </c:otherwise>
</c:choose>
</div>
</body>
</html>
