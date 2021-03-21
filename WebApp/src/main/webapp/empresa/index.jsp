<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>VenturaHR® | Empresa</title>
    </head>
    <body>
        <div class="container">
            <h1>VenturaHR - Empresa</h1>
            <h3>Bem Vindo, ${usuario.nome}!</h3>
            <hr class="my-4">
            <button type="button" class="btn btn-success btn-lg" onclick="location.href='empresa/publicar.jsp'">Cadastrar Vaga</button> 
            <button type="button" class="btn btn-outline-primary" onclick="location.href='/'">Alterar Dados</button>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='/'">Voltar</button>
            <br><br>
            
            <div class="form-row">               
                <div class="form-group col-md-6">
                   <label for="inputBusca">Buscar por Cargo:</label>
                   <input type="text" class="form-control" id="inputBusca"><br>
                   <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
                <div class="form-group col-md-6">
                   <label for="inputBusca">Buscar por Cidade:</label>
                   <input type="text" class="form-control" id="inputBusca"><br>
                   <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </div>
            <br><br>
            
            <div class="row">
                <div class="col">
                  <h4>Resultado da Busca:</h4>                  
                  <table class="table table-striped" style="font-size: 14px">
                        <thead>
                          <tr>
                            <th scope="col">Cargo</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Cidade</th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        
                        <tbody>
                            <tr>
                              <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td><i class="fa fa-eye" aria-hidden="true"></td>
                            </tr>
                            <tr>
                              <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td><i class="fa fa-eye" aria-hidden="true"></td>
                            </tr>
                            <tr>
                              <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td><i class="fa fa-eye" aria-hidden="true"></td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td><i class="fa fa-eye" aria-hidden="true"></td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td><i class="fa fa-eye" aria-hidden="true"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <footer>
                <hr class="my-4">
                <p style="font-size: smaller" align="center">Ventura HR® - Todos os direitos reservados</p>
            </footer>
        </div>
    </body>
</html>







