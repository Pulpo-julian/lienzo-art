package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoProducto;
import com.grupotres.app.dao.DaoUsuario;
import com.grupotres.app.modelos.ItemProducto;
import com.grupotres.app.modelos.Producto;
import com.grupotres.app.modelos.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet({"/guardar-producto", "/productos-carro"})
public class ProductosAlCarro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servlet = request.getServletPath();

        if(servlet.contains("/guardar-producto")){

            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if(usuarioOptional.isPresent()){
                String codigoProducto = request.getParameter("codpro");
                String docIdUsuario = ((Usuario)(request.getSession().getAttribute("usuario"))).getDocid();

                Integer codCarro = daoUsuario.buscarCarroUsuario(docIdUsuario);

                if(codCarro == null){
                    daoUsuario.crearCarroUsuario(docIdUsuario);
                } else {
                    int precio = Integer.parseInt(request.getParameter("pre"));

                    DaoProducto daoProducto = new DaoProducto();

                    //listar por producto y carro para ver si ya se ingreso un registro
                    ItemProducto productoPrueba = daoProducto.itemPorCarroProducto(Integer.parseInt(codigoProducto), codCarro);

                    if(productoPrueba == null){
                        daoProducto.insertarProductoCarro(Integer.parseInt(codigoProducto), codCarro, 1, precio);
                    } else {
                        //modifico la cantidad del registro
                        daoProducto.insertarProductoCarroModCantidad(Integer.parseInt(codigoProducto), codCarro);
                    }

                    Integer cantidadProductos = 0;

                    List<ItemProducto> productos = daoProducto.listarPorCarro(codCarro);

                    if(productos != null){
                        cantidadProductos = daoProducto.cantidadProductosEnCarro(productos);
                    }

                    request.getSession().setAttribute("cantidadproductoscarro", cantidadProductos);

                    getServletContext().getRequestDispatcher("/index.html").forward(request, response);

                }

            } else {
                response.getWriter().println("no tienes permiso para visitar esta pagina. Registrate o inicia sesión");
            }




        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servlet = request.getServletPath();

        if(servlet.equals("/productos-carro")){

            //valido que tenga la sesion iniciada
            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if(usuarioOptional.isPresent()){
                //listo los productos por el codigo del carro del usuario
                DaoProducto daoProducto = new DaoProducto();
                Integer codCarro = (Integer) request.getSession().getAttribute("carro");
                List<ItemProducto> itemProductos = daoProducto.listarPorCarro(codCarro);
                List<Producto> productos = new ArrayList<Producto>();

                for(ItemProducto item: itemProductos){
                    Producto producto = daoProducto.buscarProducto(item.getCodProducto());

                }

            }

        }

    }
}
