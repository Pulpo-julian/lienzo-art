package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoUsuario;
import com.grupotres.app.modelos.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.grupotres.app.modelos.Categoria;
import com.grupotres.app.modelos.Producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.dao.DaoCategoria;
import com.grupotres.app.dao.DaoProducto;

/**
 * Servlet implementation class CtrIndex
 */
@WebServlet({"/controlprincipal", "/controlprincipalsesion", "/cerrarsesion", "/index.html"})
public class CtrIndex extends HttpServlet {



    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrIndex() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //obtengo atributo de barrabusqueda
        String buscar = request.getParameter("buscar");

        //cuando arranque la aplicacion por primera vez la accion sera null
        //ya que no se envia ningun paramertro
        String accion = request.getParameter("accion");

        String servletPath = request.getServletPath();

        boolean esSesion = servletPath.equals("/controlprincipalsesion");

        boolean esCerrarSesion = servletPath.equals("/cerrarsesion");

        boolean esControlPrincipal = servletPath.equals("/controlprincipal");

        boolean esContarProductosCarro = servletPath.equals("/index.html");

        if(esCerrarSesion){
            DaoUsuario daoUsuario = new DaoUsuario();
            daoUsuario.cerrarSesion(request);
            response.sendRedirect(request.getContextPath() + "/controlprincipal");
        }

        if(esContarProductosCarro){
            doPost(request, response);
        }


        try {

            DaoProducto daoPro = new DaoProducto();
            DaoCategoria daoCat = new DaoCategoria();

            List<Producto> productos = null;

            //si no hay una accion ni busqueda simplemente se listan todos los productos
            if(accion == null && buscar == null) {

                productos = daoPro.listar();

                //entra al else cuando elgia alguna categoria metiante el parametro accion
            } else if(buscar == null) {

                //tomo el id de la categoria
                int codigoCategoria = Integer.parseInt(request.getParameter("idcategoria"));
                productos = daoPro.listarPorCategoria(codigoCategoria);
                request.setAttribute("accion", accion);

                //entra cuando el buscar este con algun valor de busqueda
            } else if(buscar != null){

                productos = daoPro.listarProductosBusqueda(buscar);
                request.setAttribute("buscar", buscar);

            }

            List<Categoria> categorias = daoCat.listar();

            request.setAttribute("productos", productos);
            request.setAttribute("categorias", categorias);

            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if(!usuarioOptional.isPresent()) {
                getServletContext().getRequestDispatcher("/vistas/vistaprincipal.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/vistaSesionIniciada/vistasesioniniciada.jsp").forward(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace(System.out);

        }





    }





    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        int indexProducto = 0;

        boolean contieneProductos = false;

        if (cookies != null) {

            for(int i = 0; i < cookies.length; i++){
                if((cookies[i].getName()).contains("producto")){
                    ++indexProducto;
                }
            }

        }

        request.setAttribute("productosCarro", Integer.valueOf(indexProducto));

        getServletContext().getRequestDispatcher("/controlprincipal").forward(request, response);


    }






}
