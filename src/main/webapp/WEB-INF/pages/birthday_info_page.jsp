<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><spring:message code="output.age"/>: ${age}</h1>
    <h1><spring:message code="output.dayBeforeBirthday"/>: ${dayBeforeBirthday}</h1>
</body>
</html>
