package com.grupotres.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CtrSesion
 */
@WebServlet("/controlsesion")
public class CtrSesion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);

        response.setContentType("text/html; charset=UTF-8");

        String validar = request.getParameter("sesion");
        String registro = request.getParameter("registro");

        if(validar != null && validar.equalsIgnoreCase("Iniciar sesión")) {

            getServletContext().getRequestDispatcher("/vistas/sesion.jsp").forward(request, response);

        }

        if(registro != null && registro.equalsIgnoreCase("Regístrate")) {

            getServletContext().getRequestDispatcher("/usuarioCrud/crearUsuario.jsp").forward(request, response);

        }





        //response.sendRedirect("/vistas/sesion.jsp");

    }

}
