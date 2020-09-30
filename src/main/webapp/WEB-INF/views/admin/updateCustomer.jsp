<%--
  Created By Puri_Himal
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <%@include file="/components/common.jsp" %>
</head>
<div class="container w-50">
    <div class="container-fluid">
        <div class="card-body">
            <h3 class="text-center my-3">Customer Update</h3>
            <h5 class="text-center my-3" style="background-color:#189e06">${msg}</h5>
            <form action="updateCustomer" method="post">
                <div class="form-group">
                    <label>Account Number: ${customer.accountNo}</label>
                    <input type="hidden" name="accountNo" value="${customer.accountNo}">
                </div>
                <div class="form-group">
                    <label for="CustomerName">Customer Name</label>
                    <input type="text" name="name" class="form-control" required id="CustomerName"
                           value="${customer.name}">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" name="address" class="form-control" required id="address"
                           value="${customer.address}">
                </div>
                <div class="form-group">
                    <label for="currentBalance">Balance</label>
                    <input type="number" step="0.01" name="currentBalance" class="form-control" id="currentBalance"
                           required value=${customer.currentBalance}>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password" required
                           value=${customer.password}>
                </div>
                <div class="offset-md-5">
                    <input type="hidden" name="userName" value="${admin.userName}">
                    <input type="hidden" name="kennwort" value="${admin.kennwort}">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
            <div class="offset-md-5">
                <form action="checkCustomer" class="align-self-md-center" method="post">
                    <input type="hidden" name="userName" value="${admin.userName}">
                    <input type="hidden" name="kennwort" value="${admin.kennwort}">
                    <button type="submit" class="btn  btn-danger btn-lg">
                        Back
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</html>

