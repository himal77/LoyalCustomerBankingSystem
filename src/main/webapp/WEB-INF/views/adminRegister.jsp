<%--
  Created By Puri_Himal
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <%@include file="/components/common.jsp" %>
</head>
<body style="background-color:#b4e364">
<div class="container-fluid">
  <div class="row mt-3">
    <div class="col-md-4 offset-md-4">
      <div class="card">
        <div class="card-body px-5" style="background-color:#b4e364">
          <h3 class="text-center my-3">Admin Register</h3>
          <form action="registerAdmin" method="post">
            <div class="form-group">
              <label for="username">Admin Username</label>
              <input name="userName" type="text" class="form-control"
                     id="username" placeholder="Enter user username">
            </div>

            <div class="form-group">
              <label for="password">Admin Password</label>
              <input name="password" type="password" class="form-control"
                     id="password" placeholder="Enter user password">
            </div>
            <div class="container text-center">
              <button type="submit" class="btn btn-info">Register</button>
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
