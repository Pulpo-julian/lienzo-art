package com.grupotres.app.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.modelos.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DaoUsuario {

    private static final String SQL_SELECT = "SELECT docid, nombres, apellidos, correo FROM tblusuario;";

    private static final String SQL_SELECT_DOCID = "SELECT docid, nombres, apellidos, correo, perfil, telefono, ciudad, codigopostal, direccion FROM tblusuario WHERE docid = ?;";

    private static final String SQL_INSERT = "INSERT INTO tblusuario VALUES(?,?,?,?,?,(AES_ENCRYPT(?, \"lienzoart22\")),?,?,?,?);";

    private static final String SQL_UPDATE = "UPDATE tblusuario SET docid = ?, nombres = ?, apellidos = ?, correo = ? , telefono = ?, ciudad = ?, codigoPostal = ?, direccion = ? WHERE docid = ?;";

    private static final String SQL_DELETE = "DELETE FROM tblusuario WHERE docid = ?;";

    private static final String SQL_SELECT_BY_MAIL_PASS = "SELECT docid, nombres, apellidos, correo, perfil, telefono, ciudad, codigopostal, direccion FROM tblusuario WHERE correo = ? AND ? = AES_DECRYPT(clave, \"lienzoart22\");";




    public List<Usuario> listar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while(rs.next()) {

                String docid = rs.getString(1);
                String nombres = rs.getString(2);
                String apellidos = rs.getString(3);
                String correo = rs.getString(4);

                usuarios.add(new Usuario(docid, nombres, apellidos, correo));

            }


        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return usuarios;

    }

    //CRUD functions
    public Usuario buscarUsuario(String doc){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DOCID);
            stmt.setString(1, doc);
            rs = stmt.executeQuery();

            rs.next();
            String docid = rs.getString(1);
            String nombres = rs.getString(2);
            String apellidos = rs.getString(3);
            String correo = rs.getString(4);
            int perfil = rs.getInt(5);
            String telefono = rs.getString(6);
            String ciudad = rs.getString(7);
            String codigoPostal = rs.getString(8);
            String direccion = rs.getString(9);
            usuario = new Usuario(docid, nombres, apellidos, correo, perfil, telefono, ciudad, codigoPostal, direccion);

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return usuario;

    }

    public Usuario buscarUsuarioPorCorreoPassword(String correo, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_MAIL_PASS);
            stmt.setString(1, correo);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            rs.next();
            String docid = rs.getString(1);
            String nombres = rs.getString(2);
            String apellidos = rs.getString(3);
            String correoResivido = rs.getString(4);
            int perfil = rs.getInt(5);
            String telefono = rs.getString(6);
            String ciudad = rs.getString(7);
            String codigoPostal = rs.getString(8);
            String direccion = rs.getString(9);

            usuario = new Usuario(docid, nombres, apellidos, correoResivido, perfil, telefono, ciudad, codigoPostal, direccion);

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(rs);
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return usuario;

    }


    public void insertarUsuario(String docid, String nombres, String apellidos,
                                String correo, int perfil, String clave, String telefono,
                                String ciudad, String codigoPost, String direccion) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, docid);
            stmt.setString(2, nombres);
            stmt.setString(3, apellidos);
            stmt.setString(4, correo);
            stmt.setInt(5, perfil);
            stmt.setString(6, clave);
            stmt.setString(7, telefono);
            stmt.setString(8, ciudad);
            stmt.setString(9, codigoPost);
            stmt.setString(10, direccion);
            stmt.executeUpdate();




        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

    }

    public Usuario actualizarUsuario(String docid ,String nombres, String apellidos, String correo,
                                  String telefono, String ciudad, String codPostal, String direccion, String idActual) {


        Connection conn = null;
        PreparedStatement stmt = null;
        Usuario usuario = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, docid);
            stmt.setString(2, nombres);
            stmt.setString(3, apellidos);
            stmt.setString(4, correo);
            stmt.setString(5, telefono);
            stmt.setString(6, ciudad);
            stmt.setString(7, codPostal);
            stmt.setString(8, direccion);
            stmt.setString(9, idActual);
            stmt.executeUpdate();

            usuario = buscarUsuario(docid);

            return usuario;

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.closeConnection(stmt);
            Conexion.closeConnection(conn);
        }

        return usuario;

    }

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


    public Optional<Usuario> getObjetoUsuario(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario != null){
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    public void cerrarSesion(HttpServletRequest request) {
        Optional<Usuario> usuarioOptional = getObjetoUsuario(request);
        if (usuarioOptional.isPresent()) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
    }




}
