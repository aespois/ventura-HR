<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>VenturaHR</title>
    </head>
    <body>
        <h1>VenturaHR</h1>
        <form action="login" method="post">
            <table border="1" cellpdding="10" cellspacing="0">
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" size="15" maxlength="30" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Senha:
                    </td>
                    <td>
                        <input type="text" name="senha" size="10" maxlength="10" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Login" />
                        <input type="button" value="Criar Conta" />
                    </td>
                </tr>
            </table>
        </form>
        <h4 style="color: red">${erro}</h4>
    </body>
</html>







