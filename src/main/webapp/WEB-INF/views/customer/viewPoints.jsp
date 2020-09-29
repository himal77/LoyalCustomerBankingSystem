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
                    <th scope="col">Total</th>
                    <th scope="col">Used</th>
                    <th scope="col">Dismissed</th>
                    <th scope="col">Current</th>
                    <th scope="col">Operation</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${points.totalGatheredPoints}</td>
                        <td>${points.usedPoints}</td>
                        <td>${points.dismissedPoints}</td>
                        <td>${points.currAvailablePoints}</td>
                        <c:if test="${points.currAvailablePoints > 0}">
                        <td>
                            <div class="form-row" >
                                <form action="collectPoints">
                                    <input type="hidden" name="accountNo" value=${accountNo}>
                                    <button type="submit">Collect</button>
                                </form>
                            </div>
                        </td>
                        </c:if>
                    </tr>
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
