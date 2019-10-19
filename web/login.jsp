<%-- 
    Document   : login.jsp
    Created on : 17/08/2019, 02:43:06 PM
    Author     : Developer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="card border-primary text-center" style="margin-left:10%; margin-right: 10%; margin-top: 60px">
            <div class="card-header">
                Iniciar Sesion
            </div>
            <div class="card-body">
                <form method="post" action="ServletAuthenticar.do">
                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username">                                
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>                    
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>                    
                <input type="submit" class="btn-primary" value="Login">
            </form>       
            </div>
        </div>
    </body>
</html>
