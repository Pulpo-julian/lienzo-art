package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoTienda;
import com.grupotres.app.dao.DaoUsuario;
import com.grupotres.app.modelos.Tienda;
import com.grupotres.app.modelos.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet({"/obtener-tienda", "/update-tienda"})
public class CtrTienda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servlet = request.getServletPath();

        if (servlet.equals("/obtener-tienda")) {

            DaoTienda daoTienda = new DaoTienda();
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            List<Tienda> tiendas = daoTienda.listarTiendas(usuario.getDocid());

            String respuesta = "";

            if (tiendas.isEmpty()) {
                respuesta = "Por el momento no has creado ninguna tienda, Crea una para vender";
                request.setAttribute("respuesta", respuesta);
            } else {
                request.setAttribute("tiendas", tiendas);
            }

            getServletContext().getRequestDispatcher("/tiendasCrud/listaTiendasCrearTienda.jsp").forward(request, response);
        }

        if (servlet.contains("/update-tienda")) {

            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if (usuarioOptional.isPresent()) {

                String codtienda = request.getParameter("codtienda");

                DaoTienda daoTienda = new DaoTienda();
                Tienda tienda = daoTienda.obtenerTienda(codtienda);

                request.getSession().setAttribute("tienda", tienda);

                getServletContext().getRequestDispatcher("/tiendasCrud/actualizarTienda.jsp").forward(request, response);

            } else {
                response.getWriter().println("no tienes acceso a esta pagina, Inicia sesión");
            }


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}


