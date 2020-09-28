<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
${msg}
<%

    String message = null;

    if (message != null) {

%>

<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong><%=message%>
    </strong> <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<%
    }
%>
</body>
</html>
