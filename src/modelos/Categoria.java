/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author LENOVO
 */
public class Categoria {

    private int idCategoria;
    private String nombreCategoria;

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria(int id, String nombreCategoria) {
        this.idCategoria = id;
        this.nombreCategoria = nombreCategoria;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

}
