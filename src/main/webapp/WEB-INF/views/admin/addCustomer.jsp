<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@include file="/components/common.jsp" %>
</head>
<div class="container w-50">
    <div class="container-fluid">
        <%@include file="/WEB-INF/views/message.jsp" %>
        <div class="card-body">
            <form action="registerCustomer" method="post">
                <div class="form-group">
                    <label for="AccountNumber">Account Number</label>
                    <input type="number" name="accountNo" class="form-control" id="AccountNumber" required>
                </div>
                <div class="form-group">
                    <label for="CustomerName">Customer Name</label>
                    <input type="text" name="name" class="form-control" id="CustomerName" required>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" name="address" class="form-control" id="address" required>
                </div>
                <div class="form-group">
                    <label for="currentBalance">Balance</label>
                    <input type="number" step="0.01" value="0.0" name="currentBalance" class="form-control"
                           id="currentBalance" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password" required>
                </div>
                <div class="offset-md-5">
                    <button type="submit" class="btn btn-primary btn-lg">Insert</button>
                </div>
            </form>
            <div class="offset-md-5">
                <form action="adminPanel" class="align-self-md-center">
                    <input type="hidden" name="admin" value="${admin}">
                    <button type="submit" class="btn  btn-danger btn-lg">
                        Back
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</html>
