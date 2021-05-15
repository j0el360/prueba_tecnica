<%-- 
    Document   : index
    Created on : 13/05/2021, 02:23:47 AM
    Author     : jaenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.Libro" %>
<%@ page import="connectionSQL.Conexion" %>
<%@ page import="modelo.Carrito" %>
<%@ page import= "javax.swing.JSpinner" %>
        


<!DOCTYPE html>
<%            
            Conexion conexion=Conexion.getmiConexion();
            conexion.iniciarConexion();
            
            
            Carrito carrito=Carrito.getmiCarrito();
            
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Harry Books</title>



    </head>
    <body style="background-color: gainsboro">
        <div id="main-container">
            <h1 style="text-align: center">Harry Books - Tienda Online</h1>
        </div>

        <form method="post" action="index.jsp">

            <button type="submit" name="gotoshop">Ir al carrito de compras</button>            
            <button type="submit" name="vaciar_carrito" style="float: right">Vaciar carrito de compras</button>
            <table>
                <%
                    for(int i=1;i<=7;i++){
                        if(((i%2)==1)||(i==1)){
                            out.print("<TR>");
                            
                        }
                        out.print("<TD><IMG SRC=portadas/"+i+".jpg height=216px></TD>");
                        out.print("<TD><h1>"+conexion.obtenerTitulo(i)+"</h1>");
                        out.print("<h3>Precio: $"+conexion.obtenerPrecio(i)+"</h3>");
                        out.print("<h3>Stock:");
                        if(Integer.parseInt(conexion.obtenerStock(i))==0)
                            out.print("Agotado");
                            
                        else{
                        out.print(conexion.obtenerStock(i));
                        out.print("</h3>");
                        out.print("<h3>Cantidad:");
                        out.print("<select name=cantidad_libro"+i+">");
                        for(int j=1;j<=Integer.parseInt(conexion.obtenerStock(i));j++){
                                        out.print("<option>"+j+"</option>");
                                    }
                        out.print("</select><button type=submit name=agregar_libro"+i+">Agregar al carrito</button>");
                        
                        out.print("</h3></TD>");
                        
                    }
                        if(request.getParameter("agregar_libro"+i)!=null){                            
                                    for(int j=0;j<carrito.getCarrito().size();j++){
                                        if(carrito.getCarrito().get(j).getId_libro()==i){                                            
                                            carrito.getCarrito().remove(j);                                            
                                        }                                        
                                    }                                   
                                    carrito.añadirLibro(i,Integer.parseInt(request.getParameter("cantidad_libro"+i)));
                                   }                            
                        }                    
                %>                
            </table>
            <%
                if(request.getParameter("gotoshop")!=null){
                    if(carrito.getCarrito().isEmpty()){
                        out.print("<script>alert('No has agregado nada al carrito');</script>");
                    }else
                        request.getRequestDispatcher("carrito.jsp").forward(request,response);
                   }
                if(request.getParameter("vaciar_carrito")!=null){
                    if(carrito.getCarrito().isEmpty()){
                        out.print("<script>alert('No has agregado nada al carrito');</script>");
                    }else{
                        carrito.vaciar_carrito();
                        out.print("<script>alert('El carrito de compras esta vacio');</script>");
                    }
                   }
            %>
        </form>
    </body>
</html>
