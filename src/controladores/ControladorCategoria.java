/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Categoria;


/**
 *
 * @author LENOVO
 */
public class ControladorCategoria {

    private final ConexionBD conn;
    private final Connection con;

    public ControladorCategoria() {
        conn = new ConexionBD();
        con = conn.getConexion();
    }

    public ArrayList<Categoria> listarCategorias() {
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM categorias";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("id");
                String nombreCategoria = rs.getString("nombre_categoria");

                Categoria categoria = new Categoria(idCategoria, nombreCategoria);
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return categorias;
    }

    public Categoria buscarCategoria(String nombre) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT id, nombre_categoria FROM categorias WHERE nombre_categoria = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombreCategoria = rs.getString("nombre_categoria");

                Categoria categoria = new Categoria(id, nombreCategoria);

                return categoria;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void agregarCategoria(Categoria categoria) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO categorias(id, nombre_categoria) VALUES (?,?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getNombreCategoria());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public void editarCategoria(int id, String nombre) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "UPDATE categorias SET nombre_categoria = ? WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public boolean eliminarCategoria(int id) {

        try {
            PreparedStatement ps;

            String query = "DELETE FROM categorias WHERE id = ? AND NOT EXISTS (SELECT 1 FROM productos WHERE id_categoria = ?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, id);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
}
