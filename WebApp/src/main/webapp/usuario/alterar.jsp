<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
        <script>        
        //Mascara Telefone
        $(document).ready(function(){
          $('#inputPhone').mask('(99) 99999-9999');
        });          
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>VenturaHR® | Usuário</title>
    </head>
    
    <body>
        <div class="container">
            <h1>VenturaHR - Alterar Dados do Usuário</h1>
            <hr class="my-4">
            
            <form action="alterarConta" method="post">
                <div class="form-row"> 
                    <div class="form-group col-md-8">
                        <label for="inputName">Nome Completo:</label>
                        <input type="text" class="form-control" id="inputName" name="nome" value="${usuario.nome}">
                    </div> 
                    <div class="form-group col-md-4">
                           <label for="inputCPF">CPF:</label>
                           <input type="text" readonly disabled class="form-control" id="inputCPF" name="cpf" value="${usuario.cpf}">
                    </div>
                </div>

                <div class="form-row"> 
                    <div class="form-group col-md-8">
                       <label for="inputAddress">Endereço:</label>
                       <input type="text" class="form-control" id="inputAddress" name="endereco" value="${usuario.endereco}">
                    </div>
                    <div class="form-group col-md-4">
                       <label for="inputPhone">Telefone:</label>
                       <input type="text" class="form-control" id="inputPhone" name="telefone" value="${usuario.telefone}">
                    </div>
                </div>

                <div class="form-row">               
                    <div class="form-group col-md-8">
                       <label for="inputEmail4">Email:</label>
                       <input type="email" class="form-control" id="inputEmail4" name="email" value="${usuario.email}">
                    </div>
                    <div class="form-group col-md-4">
                       <label for="inputPassword4">Senha:</label>
                       <input type="password" class="form-control" id="inputPassword4" name="senha" value="${usuario.senha}">
                    </div>             
                </div>

                                   
                <button type="submit" class="btn btn-primary">Salvar Alterações</button>
                <button type="button" class="btn btn-outline-secondary" onclick="location.href='/'">Voltar</button> 
            </form>              
            <br>
            <div style="color:red">
                <c:forEach var="erro" items="${erros}">
                    <h5>${erro.defaultMessage}</h5>
                </c:forEach>
            </div>

            <div style="color:green">
                <h5>${sucesso}</h5>
            </div>              
                        
            <footer>
                <hr class="my-4">
                <p style="font-size: smaller" align="center">Ventura HR® - Todos os direitos reservados</p>
            </footer>
        </div>
    </body>
</html>