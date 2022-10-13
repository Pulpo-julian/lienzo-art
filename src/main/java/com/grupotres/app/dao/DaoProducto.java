package com.grupotres.app.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.modelos.ItemProducto;
import com.grupotres.app.modelos.Producto;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DaoProducto {



    private static final String SQL_SELECT = "SELECT\n"
            + "\n"
            + "    tp.codproducto,\n"
            + "    tp.nombre,\n"
            + "    tp.fechapublicacion,\n"
            + "    tp.descripcion,\n"
            + "    tp.precio,\n"
            + "    tp.existencia,\n"
            + "    te.nombre,\n"
            + "    tc.nombre,\n"
            + "    tt.nombre,\n"
            + "	   tp.urlimagen\n"
            + "\n"
            + "FROM \n"
            + "\n"
            + "    tblproducto AS tp\n"
            + "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
            + "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
            + "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda;";

    private static final String SQL_SELECT_CATEGORIA = "SELECT\n"
            + "\n"
            + "    tp.codproducto,\n"
            + "    tp.nombre,\n"
            + "    tp.fechapublicacion,\n"
            + "    tp.descripcion,\n"
            + "    tp.precio,\n"
            + "    tp.existencia,\n"
            + "    te.nombre,\n"
            + "    tc.nombre,\n"
            + "    tt.nombre,\n"
            + "	   tp.urlimagen\n"
            + "\n"
            + "FROM \n"
            + "\n"
            + "    tblproducto AS tp\n"
            + "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
            + "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
            + "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda "
            + "WHERE tp.categoria = ?;";

    private static final String SQL_SELECT_BUSQUEDA = "SELECT\n"
            + "\n"
            + "    tp.codproducto,\n"
            + "    tp.nombre,\n"
            + "    tp.fechapublicacion,\n"
            + "    tp.descripcion,\n"
            + "    tp.precio,\n"
            + "    tp.existencia,\n"
            + "    te.nombre,\n"
            + "    tc.nombre,\n"
            + "    tt.nombre\n,"
            + "	   tp.urlimagen\n"
            + "\n"
            + "FROM \n"
            + "\n"
            + "    tblproducto AS tp\n"
            + "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
            + "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
            + "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda"
            + "    WHERE tp.nombre LIKE ? OR tp.descripcion LIKE ? LIMIT 10;";


    private static final String SQL_SELECT_DOCID = "SELECT\n"
            + "\n"
            + "    tp.codproducto,\n"
            + "    tp.nombre,\n"
            + "    tp.fechapublicacion,\n"
            + "    tp.descripcion,\n"
            + "    tp.precio,\n"
            + "    tp.existencia,\n"
            + "    te.nombre,\n"
            + "    tc.nombre,\n"
            + "    tt.nombre,\n"
            + "	   tp.urlimagen\n"
            + "\n"
            + "FROM \n"
            + "\n"
            + "    tblproducto AS tp\n"
            + "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
            + "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
            + "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda\n"
            + "\n"
            + "WHERE \n"
            + "\n"
            + "    tp.codproducto = ?;";

    private static final String SQL_SELECT_TIENDA = "SELECT\n" +
            "tp.codproducto,\n" +
            "tp.nombre,\n" +
            "tp.fechapublicacion,\n" +
            "tp.descripcion,\n" +
            "tp.precio,\n" +
            "tp.existencia,\n" +
            "te.nombre,\n" +
            "tc.nombre,\n" +
            "tt.nombre,\n" +
            "tp.urlimagen\n" +
            "FROM\n" +
            "tblproducto AS tp\n" +
            "INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n" +
            "INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n" +
            "INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda\n" +
            "WHERE\n" +
            "tt.codigo = ?;";

    private static final String SQL_INSERT = "INSERT INTO tblproducto VALUES(?,?,?,?,?,?,?,?,?,?);";

    //private static final String SQL_UPDATE = "UPDATE tblusuario SET nombres = ?, apellidos = ?, correo = ? WHERE docid = ?;";

    private static final String SQL_UPDATE = "UPDATE tblproducto SET urlimagen = ? WHERE codproducto = ?;";

    private static final String SQL_DELETE = "DELETE FROM tblusuario WHERE docid = ?;";

    private static final String SQL_INSERT_CARRO_PRODUCTO = "INSERT INTO tblcarroproducto VALUES(?,?,?,?);";

    private static final String SQL_SELECT_CARROID = "SELECT * FROM tblcarroproducto WHERE codcarro = ?;";

    private static final String SQL_SELECT_CARROID_PRODID = "SELECT * FROM tblcarroproducto WHERE codproducto = ? AND codcarro = ?;";

    private static final String SQL_UPDATE_CANT_CARRO = "UPDATE tblcarroproducto SET cantproducto = ? WHERE codproducto = ? AND codcarro = ?;";


    public List<Producto> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String fechaPub = rs.getString(3);
                String descripcion = rs.getString(4);
                int precio = rs.getInt(5);
                int existencia = rs.getInt(6);
                String estado = rs.getString(7);
                String categoria = rs.getString(8);
                String tienda = rs.getString(9);
                String imagen = rs.getString(10);

                productos.add(new Producto(codProducto, nombre, fechaPub, descripcion,
                        precio, existencia, estado, categoria, tienda, imagen));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return productos;

    }

    // listar por categoria
    public List<Producto> listarPorCategoria(int codigo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CATEGORIA);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String fechaPub = rs.getString(3);
                String descripcion = rs.getString(4);
                int precio = rs.getInt(5);
                int existencia = rs.getInt(6);
                String estado = rs.getString(7);
                String categoria = rs.getString(8);
                String tienda = rs.getString(9);
                String imagen = rs.getString(10);

                productos.add(new Producto(codProducto, nombre, fechaPub, descripcion,
                        precio, existencia, estado, categoria, tienda, imagen));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return productos;

    }

    // listar por tienda
    public List<Producto> listarPorTienda(int codigoTienda){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_TIENDA);
            stmt.setInt(1, codigoTienda);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String fechaPub = rs.getString(3);
                String descripcion = rs.getString(4);
                int precio = rs.getInt(5);
                int existencia = rs.getInt(6);
                String estado = rs.getString(7);
                String categoria = rs.getString(8);
                String tienda = rs.getString(9);
                String imagen = rs.getString(10);

                productos.add(new Producto(codProducto, nombre, fechaPub, descripcion,
                        precio, existencia, estado, categoria, tienda, imagen));

            }

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return productos;

    }


    //CRUD functions
    public Producto buscarProducto(int codigoProducto){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DOCID);
            stmt.setInt(1, codigoProducto);
            rs = stmt.executeQuery();

            rs.next();

            int codProducto = rs.getInt(1);
            String nombre = rs.getString(2);
            String fechaPub = rs.getString(3);
            String descripcion = rs.getString(4);
            int precio = rs.getInt(5);
            int existencia = rs.getInt(6);
            String estado = rs.getString(7);
            String categoria = rs.getString(8);
            String tienda = rs.getString(9);
            String imagen = rs.getString(10);

            producto = new Producto(codProducto, nombre, fechaPub, descripcion,
                    precio, existencia, estado, categoria, tienda, imagen);




        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return producto;

    }

    // se debe ingresar los metodos correctos del producto
    public int insertarProducto(String nombre, Date fechaPublicacion,
                                String descripcion, int precio, int existencia, int estado,
                                int categoria, int tienda, String urlImagen) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, null);
            stmt.setString(2, nombre);
            stmt.setDate(3, fechaPublicacion);
            stmt.setString(4, descripcion);
            stmt.setInt(5, precio);
            stmt.setInt(6, existencia);
            stmt.setInt(7, estado);
            stmt.setInt(8, categoria);
            stmt.setInt(9, tienda);
            stmt.setString(10, urlImagen);

            int resultado = stmt.executeUpdate();

            return resultado;




        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return 0;

    }


    public int actualizarProducto(int codProducto, String urlImagen) {


        Connection conn = null;
        PreparedStatement stmt = null;


        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, urlImagen);
            stmt.setInt(2, codProducto);
            int resultado = stmt.executeUpdate();

            return resultado;


        } catch (Exception e) {

            e.printStackTrace(System.out);

            return 0;

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

    }

    public List<Producto> listarProductosBusqueda(String entrada){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {

            entrada = "%".concat(entrada).concat("%");
            //se imprime lo que busco
            System.out.print(entrada);
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BUSQUEDA);
            stmt.setString(1, entrada);
            stmt.setString(2, entrada);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String fechaPub = rs.getString(3);
                String descripcion = rs.getString(4);
                int precio = rs.getInt(5);
                int existencia = rs.getInt(6);
                String estado = rs.getString(7);
                String categoria = rs.getString(8);
                String tienda = rs.getString(9);
                String imagen = rs.getString(10);

                productos.add(new Producto(codProducto, nombre, fechaPub, descripcion,
                        precio, existencia, estado, categoria, tienda, imagen));



            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return productos;

    }

	/*
	public void borrarUsuario(String docid) {


		Connection conn = null;
		PreparedStatement stmt = null;


		try {

			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, docid);
			stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace(System.out);

		} finally {
			Conexion.closeConnection(stmt);
			Conexion.closeConnection(conn);
		}

	}
	*/

	/*
	public static void main(String[] args) {
		DaoProducto daoPro = new DaoProducto();
		List<Producto> productos = daoPro.listar();

		for(Producto pro: productos) {
			System.out.println(pro);
		}

	}
	*/

    public int insertarProductoCarro(int codPro, int codCarro,
                                int cant, int precio) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CARRO_PRODUCTO);


            stmt.setInt(1, codPro);
            stmt.setInt(2, codCarro);
            stmt.setInt(3, cant);
            stmt.setInt(4, precio);


            int resultado = stmt.executeUpdate();

            return resultado;

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return 0;

    }

    public List<ItemProducto> listarPorCarro(int codigoCarro){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemProducto> productos = new ArrayList<ItemProducto>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CARROID);
            stmt.setInt(1, codigoCarro);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codProducto = rs.getInt(1);
                int codCarro = rs.getInt(2);
                int cantProducto = rs.getInt(3);
                int existencia = rs.getInt(4);

                productos.add(new ItemProducto(codProducto, codCarro, cantProducto, existencia));

            }

            return productos;

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return productos;

    }

    public ItemProducto itemPorCarroProducto(int codProducto, int codigoCarro){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemProducto itemProducto = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CARROID_PRODID);
            stmt.setInt(1, codProducto);
            stmt.setInt(2, codigoCarro);

            rs = stmt.executeQuery();

            rs.next();
            int codigoProducto = rs.getInt(1);
            int codCarro = rs.getInt(2);
            int cantProducto = rs.getInt(3);
            int existencia = rs.getInt(4);

            itemProducto = new ItemProducto(codigoProducto, codCarro, cantProducto, existencia);



            return itemProducto;

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return itemProducto;

    }

    //envio true si quiero aumentar o false si quiero disminuir
    public int insertarProductoCarroModCantidad(int codPro, int codCarro, boolean aumentar) {

        ItemProducto itemProducto = itemPorCarroProducto(codPro, codCarro);

        int cantidad = itemProducto.getCantProducto();

        if(aumentar) {
            itemProducto.setCantProducto(cantidad + 1);
        } else if(!aumentar) {
            itemProducto.setCantProducto(cantidad - 1);
        }

        //actualizo cantidad
        Connection conn = null;
        PreparedStatement stmt = null;


        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_CANT_CARRO);
            stmt.setInt(1, itemProducto.getCantProducto());
            stmt.setInt(2, itemProducto.getCodProducto());
            stmt.setInt(3, itemProducto.getCodCarro());

            int resultado = stmt.executeUpdate();

            return resultado;


        } catch (Exception e) {

            e.printStackTrace(System.out);

            return 0;

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

    }

    public int cantidadProductosEnCarro(List<ItemProducto> productos){
        int cantidadTotal = 0;
        for(ItemProducto producto: productos){
            cantidadTotal += producto.getCantProducto();
        }
        return cantidadTotal;
    }
}
