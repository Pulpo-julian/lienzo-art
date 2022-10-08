package com.grupotres.app.dao;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.modelos.Producto;
import com.grupotres.app.modelos.Tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoTienda {

    private static final String SQL_SELECT = "SELECT * FROM tbltienda WHERE usuarioid = ?;";

    private static final String SQL_SELECT_ID = "SELECT * FROM tbltienda WHERE codigo = ?;";

    private static final String SQL_UPDATE = "UPDATE tbltienda SET nombre = ? , direccion = ?, descripcion = ? WHERE codigo = ?;";

    private static final String SQL_SELECT_USERID_TIENDAID = "SELECT * FROM tbltienda WHERE codigo = ? AND usuarioid = ?;";




    private static final String SQL_SELECT_CON_JOIN = "SELECT\n"
            + "\n"
            + "    tt.codigo,\n"
            + "    tt.nombre,\n"
            + "    tt.direccion,\n"
            + "    tt.usuarioid,\n"
            + "    tt.descripcion\n"
            + "\n"
            + "FROM \n"
            + "\n"
            + "    tbltienda AS tt\n"
            + "    INNER JOIN tblestadoproducto AS te ON tp.estado = te.codestado\n"
            + "    INNER JOIN tblcategoria AS tc ON tc.codigo = tp.categoria\n"
            + "    INNER JOIN tbltienda AS tt ON tt.codigo = tp.tienda;";

    public List<Tienda> listarTiendas(String docid){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tienda> tiendas = new ArrayList<Tienda>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, docid);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String usuarioid = rs.getString(4);
                String descripcion = rs.getString(5);



                tiendas.add(new Tienda(codigo, nombre, direccion, usuarioid,
                        descripcion));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return tiendas;

    }

    public Tienda obtenerTienda(String tiendaId){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda tienda = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, tiendaId);
            rs = stmt.executeQuery();


            rs.next();
            int codigo = rs.getInt(1);
            String nombre = rs.getString(2);
            String direccion = rs.getString(3);
            String usuarioid = rs.getString(4);
            String descripcion = rs.getString(5);



            tienda = new Tienda(codigo, nombre, direccion, usuarioid,
                    descripcion);

            return  tienda;


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return tienda;

    }

    public int actializarTienda(String nombre, String direccion, String descripcion, int tiendaId){
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;


        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, descripcion);
            stmt.setInt(4, tiendaId);

            result = stmt.executeUpdate();

            return  result;


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return result;

    }

    public Tienda obtenerTiendaUsuarioIdTiendaId(String usuarioId, int tiendaId){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tienda tienda = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_USERID_TIENDAID);
            stmt.setInt(1, tiendaId);
            stmt.setString(2, usuarioId);
            rs = stmt.executeQuery();


            rs.next();
            int codigo = rs.getInt(1);
            String nombre = rs.getString(2);
            String direccion = rs.getString(3);
            String usuarioid = rs.getString(4);
            String descripcion = rs.getString(5);

            tienda = new Tienda(codigo, nombre, direccion, usuarioid,
                    descripcion);

            return  tienda;


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return tienda;

    }

}
