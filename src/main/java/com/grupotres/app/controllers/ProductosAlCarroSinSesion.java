package com.grupotres.app.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet({"/guardar-producto", "/carro-compras.ss"})
public class ProductosAlCarroSinSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servlet = request.getServletPath();

        if(servlet.contains("/guardar-producto")){
            String codigoProducto = request.getParameter("codpro");

            Cookie[] cookies = request.getCookies();
            int indexProducto = 1;

            boolean contieneProductos = false;

            for(int i = 0; i < cookies.length; i++){
                if((cookies[i].getName()).contains("producto")){
                    contieneProductos = true;
                    break;
                }
            }

            if(!contieneProductos) {

                Cookie producto = new Cookie("producto".concat(Integer.toString(indexProducto)), codigoProducto);

                response.addCookie(producto);

                request.setAttribute("productosCarro", Integer.valueOf(indexProducto));

                getServletContext().getRequestDispatcher("/controlprincipal").forward(request, response);

            } else {

                for(int i = 0; i < cookies.length; i++){
                    if((cookies[i].getName()).contains("producto")){
                        int ultimoCodigo = Integer.valueOf(cookies[i].getName().substring(8));
                        if(ultimoCodigo > indexProducto || indexProducto == 0){
                            indexProducto = ultimoCodigo;
                        }
                    }
                }

                Cookie producto = new Cookie("producto".concat(Integer.toString(++indexProducto)), codigoProducto);

                response.addCookie(producto);

                request.setAttribute("productosCarro", Integer.valueOf(indexProducto));

                getServletContext().getRequestDispatcher("/controlprincipal").forward(request, response);

            }
        }

        if(servlet.equals("/carro-compras.ss")){

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
