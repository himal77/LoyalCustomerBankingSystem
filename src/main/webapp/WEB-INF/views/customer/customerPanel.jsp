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
        <div class="offset-md-3">
            <div class="card">
                <div class="card-body px-2" style="background-color:#bd4e44">
                    <h3 class="text-center my-3">Customer Panel</h3>

                    <div class="form-row">

                        <form action="viewAvailabePoints" class="align-self-md-center">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                View Points History
                            </button>
                        </form>

                        <form action="viewPoints" class="align-self-md-center">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                View Points
                            </button>
                        </form>

                        <form action="viewTransaction" class="align-self-md-center">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                View Transaction
                            </button>
                        </form>

                        <form action="transaction" class="align-self-md-center">
                            <input type="hidden" name="accountNo" value=${accountNo}>
                            <button type="submit" class="btn btn-secondary btn-lg">
                                Do Transaction
                            </button>
                        </form>
                    </div>
                    <div class="offset-md-5">
                        <form action="customerButton" class="align-self-md-center">
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
