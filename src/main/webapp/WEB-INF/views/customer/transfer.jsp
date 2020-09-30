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
                <div class="card-body px-5" style="background-color:#bd4e44">
                    <h3 class="text-center my-3">Transfer</h3>
                    <h5 class="text-center my-3" style="background-color:#189e06">${msg}</h5>
                    <form action="doTransfer" method="post">
                        <div class="form-group">
                            <label for="amount">Amount</label>
                            <input name="amount" step="0.01" type="number" class="form-control"
                                   id="amount" placeholder="Enter the amount" required>
                        </div>

                        <div class="form-group">
                            <label for="receiver">To Account No</label>
                            <input name="toAccountNo" step="1" type="number" class="form-control"
                                   id="receiver" placeholder="Enter receiver AccountNo" required>
                        </div>

                        <div class="form-group">
                            <label for="date">Date</label>
                            <input name="date" type="date" class="form-control"
                                   id="date" required>
                        </div>
                        <input type="hidden" name="accountNo" value=${accountNo}>
                        <div class="container text-center">
                            <button type="submit" class="btn btn-info">Transfer</button>
                            <button type="reset" class="btn btn-info">Reset</button>
                        </div>
                    </form>

                    <div class="offset-md-4">
                        <form action="transaction" class="align-self-md-center">
                            <input type="hidden" name="accountNo" value=${accountNo}>
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

