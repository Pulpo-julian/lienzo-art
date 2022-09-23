package com.grupotres.app.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
import java.util.ArrayList;
import java.util.List;

import com.grupotres.app.conexion.Conexion;
import com.grupotres.app.dao.DaoCategoria;
import com.grupotres.app.dao.DaoProducto;

/**
 * Servlet implementation class CtrIndex
 */
@WebServlet("/controlprincipal")
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


            response.setContentType("text/html; charset=UTF-8");

            getServletContext().getRequestDispatcher("/vistas/vistaprincipal.jsp").forward(request, response);

        } catch (Exception e) {

            e.printStackTrace(System.out);

        }





    }





    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }






}
