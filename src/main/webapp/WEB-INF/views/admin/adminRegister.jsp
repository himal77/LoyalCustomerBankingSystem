<%--
  Created By Puri_Himal
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
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
                            <h5 class="text-center my-3" style="background-color:#189e06">${msg}</h5>
                            <input name="userName" type="text" class="form-control"
                                   id="username" placeholder="Enter user username" required>
                        </div>

                        <div class="form-group">
                            <label for="kennwort">Admin Password</label>
                            <input name="kennwort" type="password" class="form-control"
                                   id="kennwort" placeholder="Enter user password" required>
                        </div>
                        <div class="container text-center">
                            <button type="submit" class="btn btn-info">Register</button>
                            <button type="reset" class="btn btn-info">Reset</button>
                        </div>
                    </form>
                    <div class="offset-md-4">
                        <form action="home" class="align-self-md-center">
                            <button type="submit" class="btn btn-primary btn-lg">
                                Home
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
