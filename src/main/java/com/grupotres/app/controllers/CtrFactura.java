package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoTipoPago;
import com.grupotres.app.dao.DaoUsuario;
import com.grupotres.app.modelos.TipoPago;
import com.grupotres.app.modelos.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet({"/pagar-factura", "/"})
public class CtrFactura extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servlet = request.getServletPath();

        if(servlet.equals("/pagar-factura")){

            //valido inicio de sesion
            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if(usuarioOptional.isPresent()) {

                DaoTipoPago daoTipoPago = new DaoTipoPago();
                List<TipoPago> tipos = daoTipoPago.listar();

                request.setAttribute("tipos", tipos);



            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
