<%--
  Created By Puri_Himal
--%>
<%@ page import="com.rbinternational.model.Customer" %>
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
            <div class="card">
                <div class="card-body px-2" style="background-color:#bd4e44">
                    <h3 class="text-center my-3">Transaction</h3>

                    <div class="form-row">

                        <form action="withdrawal" class="align-self-md-center", method="post">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Withdraw
                            </button>
                        </form>

                        <form action="deposit" class="align-self-md-center", method="post">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Deposit
                            </button>
                        </form>

                        <form action="transfer" class="align-self-md-center", method="post">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Transfer
                            </button>
                        </form>
                    </div>

                    <div class="offset-md-4">
                        <form action="customerPanel" class="align-self-md-center" method="post">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <input type="hidden" name="password" value=${password}>
                            <button type="submit" class="btn btn-primary btn-lg">
                                Back
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

