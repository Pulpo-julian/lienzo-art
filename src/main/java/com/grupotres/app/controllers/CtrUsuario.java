package com.grupotres.app.controllers;

import com.grupotres.app.dao.DaoCiudad;
import com.grupotres.app.modelos.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.grupotres.app.dao.DaoCategoria;
import com.grupotres.app.dao.DaoProducto;
import com.grupotres.app.dao.DaoUsuario;
import jakarta.servlet.http.HttpSession;

//import dao.DaoUsuario;

/**
 * Servlet implementation class CtrUsuario
 */
@WebServlet({"/formulariousuario", "/iniciar-sesion", "/usuario-config", "/usuario-config-datos", "/update-datos-validar"})
public class CtrUsuario extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoUsuario daoUsuario = new DaoUsuario();
        Optional<Usuario> usuarioOptional = daoUsuario.getObjetoUsuario(request);

        String servletPath = request.getServletPath();

        boolean esConfig = servletPath.equals("/usuario-config");
        boolean esUpdate = servletPath.equals("/usuario-config-datos");

        //valido que haya sesion abierta y sea la ruta indicada
        if(esConfig && usuarioOptional.isPresent()){
            getServletContext().getRequestDispatcher("/usuarioCrud/opcionesUsuario.jsp").forward(request, response);
        }

        if(esUpdate && usuarioOptional.isPresent()){

            DaoCiudad daoCiudad = new DaoCiudad();
            List<Ciudad> ciudades = daoCiudad.listar();

            request.setAttribute("ciudades", ciudades);

            getServletContext().getRequestDispatcher("/usuarioCrud/actualizarUsuario.jsp").forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String servletPath = request.getServletPath();

        String decision = request.getParameter("crud");

        String sesion = request.getParameter("botonsesion");

        PrintWriter out = response.getWriter();

        String btnsesion = request.getParameter("botonsesion");

        if(servletPath.equals("/iniciar-sesion")){
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");

            DaoUsuario daoUsuario = new DaoUsuario();
            Usuario usuario = daoUsuario.buscarUsuarioPorCorreoPassword(correo, password);
            System.out.println(usuario);

            if(usuario != null){

                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);

                //se obtiene el carro de compras del usuario
                String docIdUsuario = ((Usuario)(request.getSession().getAttribute("usuario"))).getDocid();

                Integer codCarro = daoUsuario.buscarCarroUsuario(docIdUsuario);

                if(codCarro == null){

                    daoUsuario.crearCarroUsuario(docIdUsuario);

                } else {

                    session.setAttribute("carro", codCarro);

                    Integer cantidadProductos = 0;

                    DaoProducto daoProducto = new DaoProducto();
                    List<ItemProducto> productos = daoProducto.listarPorCarro(codCarro);

                    if(productos != null){
                        cantidadProductos = daoProducto.cantidadProductosEnCarro(productos);
                    }

                    session.setAttribute("cantidadproductoscarro", cantidadProductos);

                }

                response.sendRedirect(request.getContextPath() + "/controlprincipalsesion");

            }



        }

        if(decision != null && decision.equals("Crear")) {



            Map<String, String> errores = new HashMap<String, String>();

            //validar cedula
            String cedula = request.getParameter("cedula");

            if(cedula == null || cedula.isEmpty()) {
                errores.put("cedula", "Debe ingresar su cedula");
            }

            //validar nombre
            String nombre = request.getParameter("nombre");

            if(nombre == null || nombre.isBlank()) {
                errores.put("nombre", "Debe ingresar su nombre");
            }

            //validar apellidos
            String apellidos = request.getParameter("apellidos");

            if(apellidos == null || apellidos.isBlank()) {
                errores.put("apellidos", "Debe ingresar sus apellidos");
            }

            //validar correo
            String correo = request.getParameter("correo");

            if(correo == null || correo.isBlank()) {
                errores.put("correo", "Debe ingresar su correo");
            } else if(!correo.contains("@")) {
                errores.put("correo", "El correo debe contener caracter \"@\"");
            }

            //validar password
            String password = request.getParameter("password");

            if(password == null || password.isBlank()) {

                errores.put("password", "Debe ingresar una contraseña");

            }

            //validar telefono
            String telefono = request.getParameter("telefono");

            if(telefono == null || telefono.isBlank()) {
                errores.put("telefono", "Debe ingresar su teléfono");
            }

            //validar ciudad
            String ciudad = request.getParameter("ciudades");

            if(ciudad == null || ciudad.isBlank()) {
                errores.put("ciudades", "Seleccione una opción");
            }

            //validar codigoPostal
            String codigoPostal = request.getParameter("codigoPostal");

            if(codigoPostal == null || codigoPostal.isBlank()) {
                errores.put("codigoPostal", "Debe ingresar su código postal");
            }

            //validar direccion
            String direccion = request.getParameter("direccion");

            if(direccion == null || direccion.isBlank()) {
                errores.put("direccion", "Debe ingresar su dirección");
            }


            if(errores.isEmpty()) {

                try {
                    DaoUsuario daoUsuario = new DaoUsuario();
                    daoUsuario.insertarUsuario(cedula, nombre, apellidos, correo, 3, password, telefono, ciudad, codigoPostal, direccion);
                    //getServletContext().getRequestDispatcher("CrudNuevoLienzoArt/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
                    out.print("El usuario se ha creado correctamente");
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

            } else {

                request.setAttribute("errores", errores);
                request.setAttribute("cedula", cedula);
                request.setAttribute("nombre", nombre);
                request.setAttribute("apellidos", apellidos);
                request.setAttribute("correo", correo);
                request.setAttribute("password", password);
                request.setAttribute("telefono", telefono);
                request.setAttribute("ciudad", ciudad);
                request.setAttribute("codigoPostal", codigoPostal);
                request.setAttribute("direccion", direccion);

                getServletContext().getRequestDispatcher("/usuarioCrud/crearUsuario.jsp").forward(request, response);

            }

        }

        if (decision != null && decision.equals("eliminar")) {

            String cedula = request.getParameter("cedula");

            try {

                List<Usuario> lista;

                DaoUsuario daoUsuario = new DaoUsuario();
                daoUsuario.borrarUsuario(cedula);

            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

        }

        if(decision != null && decision.equals("listar")) {

            try {

                DaoUsuario daoUsuario = new DaoUsuario();
                List<Usuario> listaU = daoUsuario.listar();

                request.setAttribute("listUsuarios", listaU);

                request.getRequestDispatcher("/usuarioCrud/listarUsuarios.jsp").forward(request, response);


            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

        }




        if(decision != null && decision.equals("actualizar")) {

            try {

                Map<String, String> errores = new HashMap<String, String>();

                //validar cedula
                String cedula = request.getParameter("cedula");

                if (cedula == null || cedula.isEmpty()) {
                    errores.put("cedula", "Debe ingresar su cedula");
                }

                //validar nombre
                String nombre = request.getParameter("nombre");

                if (nombre == null || nombre.isBlank()) {
                    errores.put("nombre", "Debe ingresar su nombre");
                }

                //validar apellidos
                String apellidos = request.getParameter("apellidos");

                if (apellidos == null || apellidos.isBlank()) {
                    errores.put("apellidos", "Debe ingresar sus apellidos");
                }

                //validar correo
                String correo = request.getParameter("correo");

                if (correo == null || correo.isBlank()) {
                    errores.put("correo", "Debe ingresar su correo");
                } else if (!correo.contains("@")) {
                    errores.put("correo", "El correo debe contener caracter \"@\"");
                }


                //validar telefono
                String telefono = request.getParameter("telefono");

                if (telefono == null || telefono.isBlank()) {
                    errores.put("telefono", "Debe ingresar su teléfono");
                }

                //validar ciudad
                String ciudad = request.getParameter("ciudades");

                if (ciudad == null || ciudad.isBlank()) {
                    errores.put("ciudades", "Seleccione una opción");
                }

                //validar codigoPostal
                String codigoPostal = request.getParameter("codigoPostal");

                if (codigoPostal == null || codigoPostal.isBlank()) {
                    errores.put("codigoPostal", "Debe ingresar su código postal");
                }

                //validar direccion
                String direccion = request.getParameter("direccion");

                if (direccion == null || direccion.isBlank()) {
                    errores.put("direccion", "Debe ingresar su dirección");
                }

                DaoCiudad daoCiudad = new DaoCiudad();
                List<Ciudad> ciudades = daoCiudad.listar();

                if (errores.isEmpty()) {

                    try {
                        DaoUsuario daoUsuario = new DaoUsuario();
                        Usuario usuario = daoUsuario.actualizarUsuario(cedula, nombre, apellidos, correo, telefono, ciudad, codigoPostal, direccion, ((Usuario) request.getSession().getAttribute("usuario")).getDocid());
                        request.getSession().setAttribute("usuario", usuario);
                        //getServletContext().getRequestDispatcher("CrudNuevoLienzoArt/usuarioCrud/usuarioFormulario.jsp").forward(request, response);
                        String mensajeExitoso = "El usuario se ha actualizado correctamente";
                        request.setAttribute("mensaje", mensajeExitoso);
                        request.setAttribute("ciudades", ciudades);

                        getServletContext().getRequestDispatcher("/usuarioCrud/actualizarUsuario.jsp").forward(request, response);


                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                    }

                } else {

                    request.setAttribute("errores", errores);
                    request.setAttribute("cedula", cedula);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("apellidos", apellidos);
                    request.setAttribute("correo", correo);
                    request.setAttribute("telefono", telefono);
                    request.setAttribute("ciudad", ciudad);
                    request.setAttribute("codigoPostal", codigoPostal);
                    request.setAttribute("direccion", direccion);



                    request.setAttribute("ciudades", ciudades);

                    getServletContext().getRequestDispatcher("/usuarioCrud/actualizarUsuario.jsp").forward(request, response);

                }


            } catch (Exception e) {

                e.printStackTrace(System.out);

            }
        }


        if(decision != null && decision.equals("mostrar")) {

            try {

                String cedula = request.getParameter("cedula");



                DaoUsuario daoUsuario = new DaoUsuario();
                Usuario usuario = daoUsuario.buscarUsuario(cedula);

                request.setAttribute("usuario", usuario);

                request.getRequestDispatcher("/usuarioCrud/verUsuario.jsp").forward(request, response);

            } catch (Exception e) {

                e.printStackTrace(System.out);

            }

        }

    }

}
