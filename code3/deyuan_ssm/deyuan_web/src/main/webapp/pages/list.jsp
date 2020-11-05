<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="lis" items="${list}">
        ${lis.productName}<br>
    </c:forEach>
</body>
</html>
