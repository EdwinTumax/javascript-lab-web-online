<%-- 
    Document   : index
    Created on : 17/08/2019, 02:01:46 PM
    Author     : Developer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <c:if test="${empty token}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">Bienvenido al portal de compras en linea!!!</h1>
            <p class="lead">Sistema de control de compras</p>
            <hr class="my-4">
            <p>Puede iniciar el proceso de compras en cualquier momento</p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Login</a>
        </div>
    </body>

</html>
