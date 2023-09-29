/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Producto;

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

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, productos.id_categoria, "
                    + "categorias.nombre_categoria FROM productos JOIN generos ON productos.id_categoria = categorias.id";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double precio = rs.getDouble("precio");
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");

                Categoria categoria = new Categoria(idCategoria, nombreCategoria);

                Producto producto = new Producto(codigo, nombre, precio, distribuidor, categoria);
                productos.add(producto);
            }
        } catch (SQLException ex) {

            System.err.println(ex.toString());
        }
        return productos;
    }

    public ArrayList<Categoria> getTodasLasCategorias() {
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

    public Producto buscarProducto(String codigo) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, productos.id_categoria"
                    + " categorias.nombre_categoria FROM productos JOIN categorias on productos.id_categoria = categorias.id WHERE productos.codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double precio = rs.getDouble("precio");
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");

                Categoria categoria = new Categoria(idCategoria, nombreCategoria);

                Producto producto = new Producto(codigo, nombre, precio, distribuidor, categoria);

                return producto;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public ArrayList<Producto> buscarProductoPorCategoria(int id) {
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT productos.codigo, productos.nombre, productos.distribuidor, productos.precio, productos.id_categoria,"
                    + " categorias.nombre_categoria FROM productos JOIN categorias ON productos.id_categoria = categorias.id WHERE productos.id_categoria = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String distribuidor = rs.getString("distribuidor");
                double precio = rs.getDouble("precio");
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");

                Categoria categoria = new Categoria(idCategoria, nombreCategoria);

                Producto producto = new Producto(codigo, nombre, precio, distribuidor, categoria);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return productos;
    }

    public void agregarProducto(Producto producto) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO productos(codigo, nombre, distribuidor, precio, id_categoria) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDistribuidor());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCategoria().getIdCategoria());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }

    }

    public boolean editarProducto(Producto producto) {
        try {
            PreparedStatement ps;

            String query = "UPDATE productos SET precio = ? WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setDouble(1, producto.getPrecio());
            ps.setString(2, producto.getCodigo());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

    public boolean eliminarProducto(String codigo) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM productos WHERE codigo = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, codigo);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

}
