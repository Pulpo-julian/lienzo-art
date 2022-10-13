package com.grupotres.app.dao;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.modelos.TipoPago;
import com.grupotres.app.modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoTipoPago {

    private static final String SQL_SELECT = "SELECT * FROM tbltipopago;";

    public List<TipoPago> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoPago> tipoPagos = new ArrayList<TipoPago>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()) {

                int codTipo = rs.getInt(1);
                String nombre = rs.getString(2);


                tipoPagos.add(new TipoPago(codTipo, nombre));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return tipoPagos;

    }

}
