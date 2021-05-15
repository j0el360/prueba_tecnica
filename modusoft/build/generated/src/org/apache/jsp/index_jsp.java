package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Libro;
import connectionSQL.Conexion;
import modelo.Carrito;
import javax.swing.JSpinner;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
            
            Conexion conexion=Conexion.getmiConexion();
            conexion.iniciarConexion();
            
            
            Carrito carrito=Carrito.getmiCarrito();
            

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Harry Books</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form method=\"post\">\n");
      out.write("\n");
      out.write("            <button type=\"submit\" name=\"gotoshop\">Ir al carrito de compras</button>\n");
      out.write("            <button type=\"submit\" name=\"vaciar_carrito\">Vaciar carrito de compras</button>\n");
      out.write("            <table>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/1.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y La Piedra Filosofal</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(1));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(1));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select id=\"cantidad_libro1\" name=\"cantidad_libro1\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(1));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro1\" class=\"btn-info\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro1")!=null){
                                    carrito.añadirLibro(1,Integer.parseInt(request.getParameter("cantidad_libro1")));      
                                    
                                   }
                            
      out.write("\n");
      out.write("                        </h3></TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/2.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y La Camara Secreta</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(2));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(2));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro2\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(2));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro2\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro2")!=null){
                                    carrito.añadirLibro(2,Integer.parseInt(request.getParameter("cantidad_libro2")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/3.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y El Prisionero de Azkaban</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(3));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(3));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro3\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(3));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro3\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro3")!=null){
                                    carrito.añadirLibro(3,Integer.parseInt(request.getParameter("cantidad_libro3")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/4.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y El Caliz de Fuego</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(4));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(4));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro4\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(4));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro4\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro4")!=null){
                                    carrito.añadirLibro(4,Integer.parseInt(request.getParameter("cantidad_libro4")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/5.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y La Orden del Fenix</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(5));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(5));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro5\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(5));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro5\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro5")!=null){
                                    carrito.añadirLibro(5,Integer.parseInt(request.getParameter("cantidad_libro5")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/6.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y El Misterio del Principe</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(6));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(6));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro6\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(6));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro6\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro6")!=null){
                                    carrito.añadirLibro(6,Integer.parseInt(request.getParameter("cantidad_libro6")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("                <TR>\n");
      out.write("                    <TD><IMG SRC=\"portadas/7.jpg\"></TD>\n");
      out.write("                    <TD><h1>Harry Potter y Las Reliquias de la Muerte</h1><h3>Precio: $");
out.print(conexion.obtenerPrecio(7));
      out.write("</h3><h3>Stock: ");
out.print(conexion.obtenerStock(7));
      out.write("</h3>\n");
      out.write("                        <h3>Cantidad: \n");
      out.write("                            <select name=\"cantidad_libro7\">                            \n");
      out.write("                                ");

                                    for(int i=1;i<=Integer.parseInt(conexion.obtenerStock(7));i++){
                                        out.print("<option>"+i+"</option>");
                                    }
                                
      out.write("\n");
      out.write("                            </select><button type=\"submit\" name=\"agregar_libro7\">Agregar al carrito</button>\n");
      out.write("                            ");

                                if(request.getParameter("agregar_libro7")!=null){
                                    carrito.añadirLibro(7,Integer.parseInt(request.getParameter("cantidad_libro7")));
                                   }
                            
      out.write("\n");
      out.write("                        </h3>\n");
      out.write("                    </TD>                              \n");
      out.write("                </TR>\n");
      out.write("            </table>\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
