<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
        <script>
        //Mascara CPF
        $(document).ready(function(){
          $('#inputCPF').mask('999.999.999-99');
        });
        //Mascara CNPJ
        $(document).ready(function(){
          $('#inputCNPJ').mask('999.999.999/9999-99');
        });
        //Mascara Telefone
        $(document).ready(function(){
          $('#inputPhone').mask('(99) 99999-9999');
        });  
        $(document).ready(function() {
            var $inputCNPJ = $('#inputCNPJ');
            var $inputRazaoSocial = $('#inputRazaoSocial');
            $("input[name=tipo]").on('change', function() {
                var disabled = $(this).val() === 'C';
                $inputCNPJ.prop('disabled', disabled);
                $inputRazaoSocial.prop('disabled', disabled);
            });
        }); 
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>VenturaHR® | Empresa</title>
    </head>
    
    <body>
        <div class="container">
            <h1>VenturaHR - Publicar Vaga</h1>
            <hr class="my-4">
            
            <form action="criarConta" method="post">
                <div class="form-row"> 
                    <div class="form-group col-md-6">
                        <label for="inputCargo">Cargo:</label>
                        <input type="text" class="form-control" id="inputCargo" name="cargo" value="${usuario.nome}">
                    </div> 
                    <div class="form-group col-md-4">
                        <label for="inputCidade">Cidade:</label>
                        <input type="text" class="form-control" id="inputCidade" name="cidade" value="${usuario.cpf}">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputContrato">Contrato:</label>
                        <select class="form-control" id="inputContrato">
                            <option>CLT</option>
                            <option>PJ</option>
                            <option>Autônomo</option>
                        </select>
                    </div>
                </div>
                                   
                <button type="submit" class="btn btn-primary">Criar Conta</button>
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