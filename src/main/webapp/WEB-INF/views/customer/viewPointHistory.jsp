<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <%@include file="/components/common.jsp" %>
</head>
<body>
<div class="container w-75">
    <div class="container-fluid">
        <div class="card-body">
            <table class="table table-borderless table-dark">
                <thead>
                <tr>
                    <th scope="col">Date</th>
                    <th scope="col">Points</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pointsHistoryList}" var="points">
                    <tr>
                        <td>${points.date}</td>
                        <td>${points.points}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="offset-md-5">
                <form action="customerPanel" class="align-self-md-center" method="post">
                    <input type="hidden" name="accountNo" value=${accountNo}>
                    <input type="hidden" name="password" value=${password}>
                    <button type="submit" class="btn btn-primary btn-lg">
                        Back
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
