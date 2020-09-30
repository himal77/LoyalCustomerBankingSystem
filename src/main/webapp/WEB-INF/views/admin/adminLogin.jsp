<%--
  Created By Puri_Himal
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>

<head>
    <title>Login</title>
    <%@include file="/components/common.jsp" %>
</head>
<body style="background-color:#7578d9">
<div class="container-fluid">
    <div class="row mt-3">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-body px-5" style="background-color:#7578d9">
                    <h3 class="text-center my-3">Admin Login</h3>
                    <h5 class="text-center my-3" style="background-color:#189e06">${msg}</h5>
                    <form action="adminPanel" method="post">
                        <div class="form-group">
                            <label for="username">Admin Username</label>
                            <input name="userName" type="text" class="form-control"
                                   id="username" placeholder="Enter user username" required>
                        </div>

                        <div class="form-group">
                            <label for="password">Admin Password</label>
                            <input name="password" type="password" class="form-control"
                                   id="password" placeholder="Enter user password" required>
                        </div>
                        <div class="container text-center">
                            <button type="submit" class="btn btn-info">Login</button>
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
