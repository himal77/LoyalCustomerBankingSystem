<%--
  Created By Puri_Himal
--%>
<html>
<head>
  <%@include file="/components/common.jsp" %>
</head>
<body>
<div class="container-fluid">
  <div class="row mt-5">
    <div class="col-md-4 offset-md-4">
      <div class="card">
        <h2 class="text-center">Raiffeisen Bank International AG</h2>
        <form action="customerButton" class="align-self-md-center">
          <button type="submit" class="btn btn-secondary btn-lg">
            Customer Login
          </button>
        </form>

        <form action="adminButton" class="align-self-md-center">
          <button type="submit" class="btn btn-primary btn-lg">
            Admin Login
          </button>
        </form>

        <form action="adminRegisterButton" class="align-self-md-center">
          <button type="submit" class="btn btn-info btn-lg">
            Admin Register
          </button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>

