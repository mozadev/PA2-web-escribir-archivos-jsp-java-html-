
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.TrabajadorBean"%>

<%!ArrayList<TrabajadorBean> listatrabajador;%> 
<%listatrabajador = (ArrayList<TrabajadorBean>) request.getAttribute("listatrabajador");%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script>

            function grabar() {
                document.form.action = "<%=request.getContextPath()%>/LecturaEscrituraControlador";
                document.form.method = "GET";
                document.form.op.value = "4";
                document.form.submit();
            }
        
        </script>
    </head>

    <body>
    <center>
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="COD">
            <input type="hidden" name="NOM">
            <input type="hidden" name="SUELDO">


            <center>
                <table>
                    <tr>
                        <td colspan="2">Registrar Tabla Sueldo Trabajadores</td>
                    </tr>
                    <tr>
                        <td>Codigo: </td>
                        <td><input type="text" name="txtcodigo"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtnombre"></td>
                    </tr>

                    <tr>
                        <td>Sueldo: </td>
                        <td><input type="text" name="txtsueldo"></td>
                    </tr>
                </table>
              
                    <tr>
                        <td><button onclick="grabar()">Grabar</button></td>

                    <br>
              
                 <br>
                <font style="color: red">
               
                </font>
                <table border="1">      
                       
                    <tr>
                        <td>Codigo</td>
                        <td>Nombre</td>
                        <td>Sueldo</td>
                    </tr>

                    <% for (TrabajadorBean obj : listatrabajador)
                      {%>
                    <tr>
                        <td><%=obj.getCODTRABAJADOR()%></td>
                        <td><%=obj.getNOMBTRABAJADOR()%></td>
                        <td><%=obj.getSUELDOTRABAJADOR()%></td>
                       </tr>
                    <%}%>                    
                </table>           
        </form>
    </center>
</body>
</html>
