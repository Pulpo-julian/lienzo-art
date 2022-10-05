package com.grupotres.app.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/guardar-producto")
public class ProductosAlCarroSinSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servlet = request.getServletPath();
        if(servlet.contains("/guardar-producto")){
            String codigoProducto = request.getParameter("codpro");

            Cookie[] cookies = request.getCookies();
            int indexProducto = 0;

            if(cookies == null) {

                Cookie producto = new Cookie("producto".concat(Integer.toString(indexProducto)), codigoProducto);

                response.addCookie(producto);

                response.getWriter().println("se agrego la primera cookie");
            } else {

                for(int i = 0; i < cookies.length; i++){
                    if((cookies[i].getName()).contains("producto")){
                        int ultimoCodigo = Integer.valueOf(cookies[i].getName().substring(8));
                        if(ultimoCodigo > indexProducto || indexProducto == 0){
                            indexProducto = ultimoCodigo;
                        }
                        response.getWriter().println("codigo de producto añadido: " + cookies[i].getValue());
                    }
                }

                Cookie producto = new Cookie("producto".concat(Integer.toString(++indexProducto)), codigoProducto);

                response.addCookie(producto);


            }






        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
