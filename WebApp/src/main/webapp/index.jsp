<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>VenturaHR® | 2021</title>
    </head>
    
    <body>       
        <div class="container">            
            <div class="jumbotron">
                <h1 class="display-4">VenturaHR</h1>
                <p class="lead">Conectando empresas incríveis com profissionais fabulosos!</p><hr class="my-4">
                <button type="button" class="btn btn-success btn-lg" onclick="location.href='usuario/manter.jsp'">Faça seu cadastro</button>
            </div>
                        
            <div class="row">                             
                <div class="col">
                    <form action="login" method="post">
                        <h3>Acesso ao Sistema</h3>
                        
                        <div class="form-group">
                          <label for="exampleInputEmail1">Email:</label>
                          <input name="email" type="email" class="form-control" id="exampleInputEmail1">
                        </div>
                        
                        <div class="form-group">
                          <label for="exampleInputPassword1">Senha:</label>
                          <input name="senha" type="password" class="form-control" id="exampleInputPassword1">
                        </div>

                        <button type="submit" class="btn btn-primary">Login</button>
                        <button type="button" class="btn btn-outline-success" onclick="location.href='usuario/manter.jsp'">Criar Conta</button>                             
                    </form>
                    <br>
                    <h5 style="color: red" style="font-size: smaller">${erro}</h5>
                </div>
            </div> 
            
            <footer>
                <hr class="my-4">
                <p style="font-size: smaller" align="center">Ventura HR® - Todos os direitos reservados</p>
            </footer>
        </div>          
    </body>
</html>