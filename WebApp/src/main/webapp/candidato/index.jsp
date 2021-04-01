<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css" />  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <script>     
        // Idioma do datatable
        $(document).ready(function () {
            $('#busca').DataTable( {
                language: {
                    url: "https://cdn.datatables.net/plug-ins/1.10.24/i18n/Portuguese-Brasil.json"
                }
            });
        });
        </script> 
        
        <title>VenturaHR® | Candidato</title>
    </head>
    <body>
        <div class="container">
            <h1>VenturaHR - Candidato</h1>
            <h2>Bem Vindo, ${usuario.nome}!</h2>
            <hr class="my-4">
            <button type="button" class="btn btn-outline-primary" onclick="location.href='usuario/alterar.jsp'">Alterar Dados</button>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='/'">Voltar</button>
            <br><br>
            
            <div class="row">
                <div class="col">
                  <h4>Buscar Vaga por Cargo ou Cidade</h4><br>                  
                    <table id="busca" name="busca" class="table table-hover" style="width:100%">
                        <thead>
                            <tr>
                                <th>Cargo</th>
                                <th>Cidade</th>
                                <th>Forma de Contratação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="vaga" items="${publicadas}">
                                <tr>
                                    <td>${vaga.cargo}</td>
                                    <td>${vaga.cidade}</td>
                                    <td>${vaga.formaContratacao}</td>
                                </tr>
                            </c:forEach>
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







