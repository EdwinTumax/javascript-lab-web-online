<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="menu.html"></jsp:include>
        <body>
            <div class="card border-primary text-center">
                <div class="card-header">
                    Nueva cartegoria
                </div>
                <div class="card-body">               
                <c:if test="${not empty categoria}">
                    <form action="" method="post">
                        <div class="form-group row">
                            <label class="col-form-label col-sm-2" id="descripcion" for="descripcion">Descripcion</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="descripcion" id="descripcion" value="${categoria.descripcion}">                          
                            </div>
                        </div>                       
                        <div class="form-group row">
                            <div class="col-sm-2">
                                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Guardar">                           
                            </div>
                        </div>
                    </form>            
                </c:if>
                <c:if test="${empty categoria}">
                    <form action="ServletAgregarCategoria.do" method="post">
                        <div class="form-group row">
                            <label class="col-form-label col-sm-2" id="descripcion" for="descripcion">Descripcion</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="descripcion" id="descripcion">                          
                            </div>
                        </div>                       
                        <div class="form-group row">
                            <div class="col-sm-2">
                                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Guardar">                           
                            </div>
                        </div>
                    </form>                  
                </c:if>
            </div>
        </div>
    </body>
</html>
