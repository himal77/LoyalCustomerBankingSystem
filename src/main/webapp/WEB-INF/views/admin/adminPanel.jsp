<%--
  Created By Puri_Himal
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/components/common.jsp" %>
</head>
<body>
<body style="background-color:#7578d9">
<div class="container-fluid">
    <div class="row mt-3">
        <div class="offset-md-4">
            <div class="card" style="background-color:#7578d9">
                <div class="card-body px-2" style="background-color:#95d66d">
                    <h3 class="text-center my-3">Admin Panel</h3>
                    <div class="form-row">
                        <form action="addCustomer" class="align-self-md-center" method="post">
                            <input type="hidden" name="userName" value="${admin.userName}">
                            <input type="hidden" name="kennwort" value="${admin.kennwort}">
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Add Customer
                            </button>
                        </form>

                        <form action="checkCustomer" class="align-self-md-center" method="post">
                            <input type="hidden" name="userName" value="${admin.userName}">
                            <input type="hidden" name="kennwort" value="${admin.kennwort}">
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Check Customer
                            </button>
                        </form>
                    </div>
                    <div class="offset-md-4">
                        <form action="home" class="align-self-md-center">
                            <button type="submit" class="btn btn-primary btn-lg">
                                Logout
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
