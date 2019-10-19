<%-- 
    Document   : categorias
    Created on : 24/08/2019, 02:03:51 PM
    Author     : Developer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <div class="card border-primary mb-3">
                <div class="card-header">Categorias</div>
                <div class="card-body text-primary">
                    <h5 class="card-title">Listado de categorias</h5>
                    <div class="my-2 text-left">
                        <a href="createCategoria.jsp" class="btn btn-rounded btn-primary">Crear Categoria</a>
                    </div> 
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Descripción</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>                        
                        </thead>
                        <tbody>
                        <c:forEach items="${categorias}" var="categoria">
                            <tr>
                                <td>${categoria.codigoCategoria}</td>
                                <td>${categoria.descripcion}</td>
                                <td>                                
                                    <a class="btn btn-success" href="ServletBuscarCategoria.do?codigoCategoria=${categoria.codigoCategoria}" type="button">Update</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ServletEliminarCategoria.do?codigoCategoria=${categoria.codigoCategoria}" type="button">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
