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
                    <th scope="col">Amount</th>
                    <th scope="col">Type</th>
                    <th scope="col">Receiver</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${transactionList}" var="transaction">
                    <tr>
                        <td>${transaction.date}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.type}</td>
                        <td>${transaction.receiverAccountNo.accountNo}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>Total Amount: ${currentBalance}</tr>
                </tfoot>
            </table>
            <div class="offset-md-4">
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
