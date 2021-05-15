<%-- 
    Document   : carrito
    Created on : 13/05/2021, 03:25:11 PM
    Author     : jaenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.Carrito" %>
<%@ page import="connectionSQL.Conexion" %>

<%            
            Carrito carrito=Carrito.getmiCarrito();
            Conexion conexion=Conexion.getmiConexion();
%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/tabla.css">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Carrito</title>
    </head>
    <body>
        
        <%
            for(int i=0;i<carrito.getCarrito().size();i++){
                if(request.getParameter("eliminar_"+i)!=null){
                    if(carrito.getCarrito().size()>0)
                        carrito.getCarrito().remove(i);                    
                }
            }
                   
        %>
        <form method="post" action="carrito.jsp">
            <div id="main-container">
                <table>
                    <tr>
                        <th></th>
                        <th>Libro</th>
                        <th>Cantidad</td>
                        <th>Precio Unitario</th>
                        <th>Precio Total</th>
                    </tr>
                    <%
                        if(carrito.getCarrito().size()>0)
                        for (int i=0;i<carrito.getCarrito().size();i++){
                            out.print("<tr><td><button type=submit name=eliminar_"+i+">Eliminar</button></td>"
                                    + "<td>"+ conexion.obtenerTitulo(carrito.getCarrito().get(i).getId_libro()) +"</td>"
                                    + "<td>"+ carrito.getCarrito().get(i).getCant_libro() +"</td>"
                                    + "<td>$ "+ conexion.obtenerPrecio(carrito.getCarrito().get(i).getId_libro()) +"</td>"
                                    + "<td>$ "+ Integer.parseInt(conexion.obtenerPrecio(carrito.getCarrito().get(i).getId_libro()))*carrito.getCarrito().get(i).getCant_libro()+"</td>"
                                    + "</tr>");
                        }
                
                    %>
                </table>
                <h3>Valor total de la compra: $ <% out.print(carrito.getValorTotalCompra()); %></h3>



            </div>

        </form>
        <div id="main-container">
            <button id="btn-abrir-popup-cancelar">Cancelar compra</button><button id="btn-abrir-popup">Confirmar compra</button>
        </div>
        <%
            if(carrito.getCarrito().size()==0){
                carrito.vaciar_carrito();
                request.getRequestDispatcher("").forward(request,response);                        
            }  
            
        %>
        <div class="overlay" id="overlay-confirmar">
            <div class="popup" id="popup-confirmar">
                <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>

                <form action="carrito.jsp" method="post">
                    <div>
                        <h4>Confirmar compra?</h4>
                    </div>
                    <button type="submit" class="btn-submit" name="confirmar">Si</button>      <button type="submit" class="btn-submit">No</button>
                </form>
            </div>
        </div>
        <div class="overlay" id="overlay-cancelar">
            <div class="popup" id="popup-cancelar">
                <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>

                <form action="carrito.jsp" method="post">
                    <div>
                        <h4>Cancelar compra?</h4>
                    </div>
                    <button type="submit" class="btn-submit" name="cancelar">Si</button>      <button type="submit" class="btn-submit">No</button>
                </form>
            </div>
        </div>
        <%
        if(request.getParameter("confirmar")!=null){
                conexion.confirmarCompra(carrito.getCarrito(),carrito.getValorTotalCompra());
                carrito.vaciar_carrito();
                request.getRequestDispatcher("").forward(request,response);
            }
        if(request.getParameter("cancelar")!=null){
                carrito.vaciar_carrito();
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        %>
        <script src="js/popup.js"></script>
    </body>
</html>
