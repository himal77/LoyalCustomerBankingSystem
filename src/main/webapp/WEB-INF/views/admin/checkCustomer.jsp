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
                    <th scope="col">AccountNo</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Balance</th>
                    <th scope="col">Operations</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customerList}" var="customer">
                    <tr>
                        <td>${customer.accountNo}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td>${customer.currentBalance}</td>
                        <td>
                            <div class="form-row" onsubmit="return confirm('Do you really want to delete?');">
                                <form action="deleteCustomerReq">
                                    <input type="hidden" name="accountNo" value=${customer.accountNo}>
                                    <button type="submit">Delete</button>
                                </form>
                                <form action="updateCustomerReq">
                                    <input type="hidden" name="accountNo" value=${customer.accountNo}>
                                    <button type="submit">Update</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="align-self-lg-center">
            <form action="adminPanel" class="align-self-md-center">
                <button type="submit" class="btn btn-secondary btn-lg">
                    AdminPanel
                </button>
            </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
