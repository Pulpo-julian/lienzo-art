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

    private static final String SQL_SELECT = "SELECT * FROM tbltienda WHERE idusuario = ?;";

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

}
