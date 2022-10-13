package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoProducto;
import com.grupotres.app.dao.DaoTienda;
import com.grupotres.app.dao.DaoUsuario;
import com.grupotres.app.modelos.Producto;
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

@WebServlet({"/obtener-tienda", "/update-tienda", "/ver-tienda"})
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

        //ver-tienda sera la ruta para los dueños de las tiendas
        if (servlet.contains("/ver-tienda")){

            //hay que confirmar si tienen la sesion iniciada
            DaoUsuario daoUsuario = new DaoUsuario();
            Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

            if(usuarioOptional.isPresent()){
                int codTienda = Integer.valueOf(request.getParameter("codtienda"));
                String codUsuario = ((Usuario)request.getSession().getAttribute("usuario")).getDocid();

                DaoTienda daoTienda = new DaoTienda();
                Tienda tienda = daoTienda.obtenerTiendaUsuarioIdTiendaId(codUsuario, codTienda);

                if(tienda != null){

                    request.setAttribute("tienda", tienda);

                    //se obtiene los productos de la tienda por el codigo de la tienda
                    DaoProducto daoProducto = new DaoProducto();
                    List<Producto> productos = daoProducto.listarPorTienda(codTienda);

                    request.setAttribute("productos", productos);

                    getServletContext().getRequestDispatcher("/tiendasCrud/tiendaConSesion.jsp").forward(request, response);


                } else {

                    response.getWriter().println("al parecer no tienes tiendas creadas o la tienda a la que intentas ingresar no es tuya");

                }

            } else {
                response.getWriter().println("Por favor registrate o inicia sesión");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("crud");

        if(accion.equals("actualizar")){

            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String descripcion = request.getParameter("descripcion");

            Map<String, String> errores = new HashMap<String, String>();

            if(nombre == null || nombre.isEmpty()) {
                errores.put("nombre", "Debe asignar un nombre a la tienda");
            }

            if(direccion == null || direccion.isEmpty()) {
                errores.put("direccion", "Debe ingresar la dirección de la tienda");
            }

            if(descripcion == null || descripcion.isEmpty()) {
                errores.put("descripcion", "Escriba una pequeña descripción de la tienda");
            }

            if(errores.isEmpty()){

                DaoTienda daoTienda = new DaoTienda();
                int codTienda = ((Tienda) request.getSession().getAttribute("tienda")).getCodigo();
                int resultado = daoTienda.actializarTienda(nombre, direccion, descripcion, codTienda);

                if(resultado == 1){


                    Tienda tienda = daoTienda.obtenerTienda(String.valueOf(codTienda));

                    request.getSession().setAttribute("tienda", tienda);

                    request.setAttribute("mensaje", String.valueOf("se ha actualizado la tienda"));

                    getServletContext().getRequestDispatcher("/tiendasCrud/actualizarTienda.jsp").forward(request, response);

                } else if (resultado == 0){

                    response.getWriter().println("Ha ocurrido un error");

                }

            } else {

                request.setAttribute("errores", errores);

                request.setAttribute("nombre", nombre);
                request.setAttribute("direccion", direccion);
                request.setAttribute("descripcion", descripcion);


                getServletContext().getRequestDispatcher("/tiendasCrud/actualizarTienda.jsp").forward(request, response);

            }


        }

    }

}


