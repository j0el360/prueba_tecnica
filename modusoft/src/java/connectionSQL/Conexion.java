/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionSQL;

import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Libro;

/**
 *
 * @author jaenc
 */
public class Conexion {
    Connection con;
    Statement st;
    ResultSet rs;
    
private static Conexion miConexion;

    private Conexion() {
        
    }
    
    public static Conexion getmiConexion(){
        if(miConexion==null)
            miConexion=new Conexion();
        return miConexion;
    }

    public void iniciarConexion(){
        if(con==null)
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/tienda?user=root");
            st=con.createStatement();            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public String obtenerPrecio(int id){
        String precio="";
        try {
            rs=st.executeQuery("SELECT precio_libro FROM libro WHERE id_libro="+id+";");
            while(rs.next())
            precio=rs.getString(1);
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return precio;
    }
    public String obtenerStock(int id){
        String stock="";
        try {
            rs=st.executeQuery("SELECT stock_libro FROM libro WHERE id_libro="+id+";");
            while(rs.next())
            stock=rs.getString(1);
        } catch (Exception ex) {
            
        }
        return stock;
    }
    
    public String obtenerTitulo(int id){
        String titulo="";
        try {
            rs=st.executeQuery("SELECT titulo_libro FROM libro WHERE id_libro="+id+";");
            while(rs.next())
            titulo=rs.getString(1);
        } catch (Exception ex) {
            
        }
        return titulo;
    }
    public void confirmarCompra(ArrayList<Libro> carrito, int valorCompra){
        try {
            st.executeUpdate("INSERT INTO compra (id_compra, precio_compra) SELECT count(*)+1,"+valorCompra+" FROM compra;");
        for(int i=0;i<carrito.size();i++){
            
                st.executeUpdate("UPDATE libro SET stock_libro=stock_libro-"+ carrito.get(i).getCant_libro() +" WHERE id_libro="+carrito.get(i).getId_libro()+";");
                
                st.executeUpdate("INSERT INTO ventas (id_compra,id_libro,cantidad_libro) SELECT COUNT(*),"+ carrito.get(i).getId_libro() +","+carrito.get(i).getCant_libro()+" FROM compra");
        }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        
    }    

    public Connection getCon() {
        return con;
    }

    public Statement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }

    
    
    
    
}
