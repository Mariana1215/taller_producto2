/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.ConexionBD;
import modelos.Producto;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Manuela Gomez
 */
public class ControladorProducto {

    private final ConexionBD conn;
    private final Connection con;

    public ControladorProducto() {
        conn = new ConexionBD();
        con = conn.getConexion();
    }

    public ResultSet buscarProducto(String codigo) {
        String where = "";

        if (!"".equals(codigo)) {
            where = "WHERE codigo = '" + codigo + "'";
        }

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM productos " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;

    }

    public ResultSet listarProductos() {

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM productos ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;

    }

    public void guardarProductos(Producto producto) throws SQLException {

        try {

            PreparedStatement ps;

            String query = "INSERT INTO productos (codigo, nombre, precio, distribuidor, categoria) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getDistribuidor());
            ps.setString(5, producto.getCategoria());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
            throw new SQLException();
        }
    }

    public void updateProductos(Producto producto) {

        try {
            PreparedStatement ps;

            String query = ("UPDATE productos SET precio=?, distribuidor=?, categoria=? WHERE codigo=?");
            ps = con.prepareStatement(query);

            ps.setDouble(1, producto.getPrecio());
            ps.setString(2, producto.getDistribuidor());
            ps.setString(3, producto.getCategoria());
            ps.setString(4, producto.getCodigo());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public void deleteProducto(String codigo) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM productos WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

}
