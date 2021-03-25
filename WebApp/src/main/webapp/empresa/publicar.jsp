<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script>
        $(document).ready(function() {
            var $inputPeso = $('#inputPeso');
            var $inputPerfil = $('#inputPerfil');
            var $inputDescricao = $('#inputDescricao');
            $("input[name=cargo]").on('change', function() {
                var disabled = $(this).val().length === 0;
                $inputDescricao.prop('disabled', disabled);
                $inputPeso.prop('disabled', disabled);
                $inputPerfil.prop('disabled', disabled);
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
            
            <form action="publicarVaga" method="post">
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="usuarioResponsavel">Responsável pela Vaga:</label>
                        <input type="text" readonly disabled id="usuarioResponsavel" value="${usuario.nome}" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text text-muted">Caso este não seja seu nome, faça login novamente no sistema.</small>
                    </div>
                </div><br>  
 
                <div class="form-row"> 
                    <div class="form-group col-md-6">
                        <label for="inputCargo">Cargo:</label>
                        <input type="text" class="form-control" id="inputCargo" name="cargo" value="${vaga.cargo}">
                    </div>                     
                         
                    <div class="form-group col-md-4">
                        <label for="inputCidade">Cidade:</label>
                        <select class="form-control" id="inputCidade">
                            <option selected>Escolher...</option>
                            <option value="Rio de Janeiro - RJ" name="cidade">Rio de Janeiro - RJ</option>
                            <option value="São Paulo - SP" name="cidade">São Paulo - SP</option>
                            <option value="Remoto - Brasil" name="cidade">Remoto - Brasil</option>
                        </select>
                    </div>
                    
                    <div class="form-group col-md-2">
                        <label for="inputContrato">Contrato:</label>
                        <select class="form-control" id="inputContrato">
                            <option selected>Escolher...</option>
                            <option value="CLT" name="contrato">CLT</option>
                            <option value="PJ" name="contrato">PJ</option>
                            <option value="Autônomo" name="contrato">Autônomo</option>
                        </select>
                    </div>
                </div>
                    
                <hr class="my-4">                     
                
                <label aria-describedby="emailHelp">Critérios da Vaga</label><br> 
                <small id="emailHelp" class="form-text text-muted">Adicione dois critérios válidos para a Vaga:</small>

                <div class="form-row">                  
                    <div class="form-group col-md-6">
                        <label for="inputDescricao1">Descrição:</label>
                        <input disabled type="text" class="form-control" id="inputDescricao1" name="descricao1" value="${criterio.descricao}">
                    </div> 

                    <div class="form-group col-md-2">
                        <label for="inputPerfil1">Perfil:</label>
                        <select disabled class="form-control" id="inputPerfil1">
                            <option selected>Escolher...</option>
                            <option value="1" name="perfil1">1 - Iniciante</option>
                            <option value="2" name="perfil1">2 - Pleno</option>
                            <option value="3" name="perfil1">3 - Sênior</option>
                            <option value="4" name="perfil1">4 - Especialista</option>
                        </select>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="inputPeso1">Peso:</label>
                        <select disabled class="form-control" id="inputPeso1">
                            <option selected>Escolher...</option>
                            <option value="1" name="peso1">1 - Opcional</option>
                            <option value="2" name="peso1">2 - Desejável</option>
                            <option value="3" name="peso1">3 - Mandatório</option>
                        </select>
                    </div>              

                    <div class="form-group col-md-6">
                        <label for="inputDescricao2">Descrição:</label>
                        <input disabled type="text" class="form-control" id="inputDescricao2" name="descricao2" value="${criterio.descricao}">
                    </div> 

                    <div class="form-group col-md-2">
                        <label for="inputPerfil2">Perfil:</label>
                        <select disabled class="form-control" id="inputPerfil2">
                            <option selected>Escolher...</option>
                            <option value="1" name="perfil2">1 - Iniciante</option>
                            <option value="2" name="perfil2">2 - Pleno</option>
                            <option value="3" name="perfil2">3 - Sênior</option>
                            <option value="4" name="perfil2">4 - Especialista</option>
                        </select>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="inputPeso3">Peso:</label>
                        <select disabled class="form-control" id="inputPeso3">
                            <option selected>Escolher...</option>
                            <option value="1" name="peso3">1 - Opcional</option>
                            <option value="2" name="peso3">2 - Desejável</option>
                            <option value="3" name="peso3">3 - Mandatório</option>
                        </select>
                    </div>
                </div><br>

                <button type="submit" class="btn btn-primary">Publicar Vaga</button>
                <button type="button" class="btn btn-outline-secondary" onclick="location.href='index.jsp'">Voltar</button>    
                
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