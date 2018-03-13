<%--
  Created by IntelliJ IDEA.
  User: arnaudg
  Date: 07/03/2018
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>

<body>
<p>Ceci est une page générée depuis une JSP.</p>
<%
    String attribut = (String) request.getAttribute("test");
    out.println( attribut );
%>
</body>
</html>