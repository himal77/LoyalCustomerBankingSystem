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
      <form action="updateCustomer" method="post">
        <div class="form-group">
          <label for="AccountNumber">Account Number</label>
          <input type="number" name="accountNo" class="form-control" id="AccountNumber" value=${customer.accountNo}>
        </div>
        <div class="form-group">
          <label for="CustomerName">Customer Name</label>
          <input type="text" name="name" class="form-control" id="CustomerName" value=${customer.name}>
        </div>
        <div class="form-group">
          <label for="address">Address</label>
          <input type="text" name="address" class="form-control" id="address" value=${customer.address}>
        </div>
        <div class="form-group">
          <label for="currentBalance">Balance</label>
          <input type="number" step="0.01" name="currentBalance" class="form-control" id="currentBalance" value=${customer.currentBalance}>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" name="password" class="form-control" id="password" value=${customer.password}>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
      </form>
    </div>
  </div>
</div>
</html>

