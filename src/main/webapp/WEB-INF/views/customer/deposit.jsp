<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>

<head>
  <title>Login</title>
  <%@include file="/components/common.jsp" %>
</head>
<body  style="background-color:#7578d9">
<div class="container-fluid">
  <div class="row mt-3">
    <div class="col-md-4 offset-md-4">
      <div class="card">
        <div class="card-body px-5" style="background-color:#7578d9">
          <h3 class="text-center my-3">Deposit</h3>
          <form action="doDeposit" method="post">
            <div class="form-group">
              <label for="amount">Amount</label>
              <input name="amount" step="0.01" type="number" class="form-control"
                     id="amount" placeholder="Enter the amount">
            </div>

            <div class="form-group">
              <label for="date">Date</label>
              <input name="date" type="date" class="form-control"
                     id="date" placeholder="Enter user password">
            </div>
            <input type="hidden" name="accountNo" value=${accountNo}>
            <div class="container text-center">
              <button type="submit" class="btn btn-info">Deposit</button>
              <button type="reset" class="btn btn-info">Reset</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
