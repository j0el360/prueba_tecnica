/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import connectionSQL.Conexion;
import java.util.ArrayList;

/**
 *
 * @author jaenc
 */
public class Carrito {
    
    ArrayList<Libro> carrito;
    private static Carrito miCarrito;
    int valorTotalCompra=0;
    Conexion conexion=Conexion.getmiConexion();

    private Carrito() {
        carrito= new ArrayList<Libro>();
    }
    
    public static Carrito getmiCarrito(){
        if(miCarrito==null)
            miCarrito=new Carrito();
        return miCarrito;
        
    }
    
    public void añadirLibro(int id,int cantidad){
        Libro libro=new Libro();
        libro.setId_libro(id);
        libro.setCant_libro(cantidad);
        carrito.add(libro);
        
    }

    public ArrayList<Libro> getCarrito() {
        return carrito;
    }
    
    public void vaciar_carrito(){
        this.carrito.clear();
        this.valorTotalCompra=0;
    }

    public int getValorTotalCompra() {
        valorTotalCompra=0;
        for(int i=0;i<carrito.size();i++){
            valorTotalCompra=valorTotalCompra+(carrito.get(i).getCant_libro()*Integer.parseInt(conexion.obtenerPrecio(carrito.get(i).getId_libro())));
        }
        return valorTotalCompra;
    }

    public void setValorTotalCompra(int valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }
    
    
    
}
