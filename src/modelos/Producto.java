/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelos;

/**
 *
 * @author Manuela Gomez
 */
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private String distribuidor;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, String distribuidor, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.distribuidor = distribuidor;
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public String getCategoria() {
        return categoria;
    }
    
}