<%--
  Created By Puri_Himal
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <%@include file="/components/common.jsp" %>
</head>
<body style="background-color:#1bc44e">
<div class="container-fluid">
  <div class="row mt-3">
    <div class="col-md-4 offset-md-4">
      <div class="card">
        <div class="card-body px-5" style="background-color:#1bc44e">
          <h3 class="text-center my-3">Customer Login</h3>
          <form action="customerPanel" method="post">
            <div class="form-group">
              <label for="accountNumber">Customer Account Number</label>
              <input name="user_email" type="number" class="form-control"
                     id="accountNumber" placeholder="Enter user account number">
            </div>

            <div class="form-group">
              <label for="password">Customer Password</label>
              <input name="password" type="password" class="form-control"
                     id="password" placeholder="Enter user password">
            </div>
            <div class="container text-center">
              <button type="submit" class="btn btn-info">Login</button>
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
