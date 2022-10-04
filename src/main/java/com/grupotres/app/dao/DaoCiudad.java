package com.grupotres.app.dao;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.modelos.Ciudad;
import com.grupotres.app.modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCiudad {

    private static final String SQL_SELECT = "SELECT * FROM tblciudad;";

    public List<Ciudad> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ciudad> ciudades = new ArrayList<Ciudad>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()) {

                String codciudad = rs.getString(1);
                String nombre = rs.getString(2);

                ciudades.add(new Ciudad(codciudad, nombre));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return ciudades;

    }

}
