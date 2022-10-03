package com.grupotres.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import com.grupotres.app.modelos.Categoria;
import com.grupotres.app.modelos.GuardarImagen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grupotres.app.dao.DaoCategoria;
import com.grupotres.app.dao.DaoProducto;
import com.grupotres.app.dao.DaoUsuario;

/**
 * Servlet implementation class CtrProducto
 */
@MultipartConfig
@WebServlet("/formularioproducto")
public class CtrProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("productocrear");

        List<Categoria> categorias = null;

        if(accion == null) {

            try {


                DaoCategoria daoCat = new DaoCategoria();


                categorias = daoCat.listar();


                request.setAttribute("categorias", categorias);




                getServletContext().getRequestDispatcher("/productosCrud/crearProducto.jsp").forward(request, response);

            } catch (Exception e) {

                e.printStackTrace(System.out);

            }

        }

        //En caso de desplegar la app en un servidor se usa esta variable
        //String urlBase = getServletContext().getRealPath("/");

        //esta variable contiene la ruta donde se ubica el proyecto pero no donde se desplega el servidor
        String urlBase = System.getProperty("user.home");

        String urlCarpetaImagenes = urlBase + "\\IdeaProjects\\lienzo-art\\src\\main\\webapp\\imagenesProductos\\";

        File carpetaImagenes = new File(urlCarpetaImagenes);

        if(accion.equals("Crear")) {

            PrintWriter out = response.getWriter();

            Map<String, String> errores = new HashMap<String, String>();

            //validar nombre
            String nombre = request.getParameter("nombre");

            if(nombre == null || nombre.isEmpty()) {
                errores.put("nombre", "Debe asignar un nombre al producto");
            }

            //validar descripcion
            String descripcion = request.getParameter("descripcion");

            if(nombre == null || nombre.isBlank()) {
                errores.put("descripcion", "coloca una breve descripcion del producto");
            }

            //validar precio, debe ser int
            String precioString = request.getParameter("precio");

            if(precioString == null || precioString.isBlank()) {
                errores.put("precio", "asigne un precio al producto");
            }

            //validar existencia, debe ser int
            String existenciaString = request.getParameter("existencia");

            if(existenciaString == null || existenciaString.isBlank()) {
                errores.put("existencia", "ingrese la existencia disponible del producto");
            }

            //validar estado
            String estadoString = request.getParameter("estado");

            if(estadoString == null || estadoString.isBlank()) {

                errores.put("estado", "seleccione un estado del producto");

            }

            //validar categoria
            String categoriaString = request.getParameter("categoria");

            if(categoriaString == null || categoriaString.isBlank()) {
                errores.put("categoria", "seleccione una categoria para el producto");
            }

            //validar tienda, debe ser int
            String tiendaString = request.getParameter("tienda");

            if(tiendaString == null || tiendaString.isBlank()) {
                errores.put("tienda", "ingrese el codigo de la tienda");
            }

            //validar si hay archivo de foto
            Part imagen = request.getPart("imagen");

            GuardarImagen guardarImagen = new GuardarImagen();



            if(Paths.get(imagen.getSubmittedFileName()).getFileName().toString().isEmpty()) {
                errores.put("imagen", "seleccione una imagen para el producto");
            } else if( !(guardarImagen.validarExtension(imagen.getSubmittedFileName())) ) {
                errores.put("imagen", "archivo con extencion no valida");
            }

            //si no hay errores en la lista, se guarda el producto
            if(errores.isEmpty()) {

                try {

                    //logica para guardar producto
                    String urlFotoGuardada = guardarImagen.imagenEnDirectorio(imagen, carpetaImagenes);

                    DaoProducto daoProducto = new DaoProducto();

                    //obtengo la fecha de creacion del producto
                    java.util.Date utilfecha = new java.util.Date();
                    java.sql.Date sqlFecha = new java.sql.Date(utilfecha.getTime());

                    //convierto el precio de String a int
                    int precioInt = Integer.parseInt(precioString);

                    //convierto la existencia de String a int
                    int existenciaInt = Integer.parseInt(existenciaString);

                    //convierto el estado de String a int
                    int estadoInt = Integer.parseInt(estadoString);

                    //convierto la categoria de String a int
                    int categoriaInt = Integer.parseInt(categoriaString);

                    //convierto la tienda de String a int
                    int tiendaInt = Integer.parseInt(tiendaString);

                    int resultado = daoProducto.insertarProducto(nombre, sqlFecha, descripcion,
                            precioInt, existenciaInt, estadoInt, categoriaInt, tiendaInt, urlFotoGuardada);


                    if(resultado != 0) {
                        response.getWriter().println("Producto Creado");
                    } else {
                        response.getWriter().println("No se ha podido actualizar el producto");
                    }


                    System.out.println(urlFotoGuardada);


                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }

            } else {

                request.setAttribute("errores", errores);

                //se reenvia la lista de las categorias en caso de que haya errores
                try {

                    DaoCategoria daoCat = new DaoCategoria();

                    categorias = daoCat.listar();

                } catch (Exception e) {

                    e.printStackTrace(System.out);

                }
                request.setAttribute("categorias", categorias);
                request.setAttribute("nombre", nombre);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("precio", precioString);
                request.setAttribute("existencia", existenciaString);
                request.setAttribute("estado", estadoString);
                request.setAttribute("categoria", categoriaString);
                request.setAttribute("tienda", tiendaString);

                //Donde se quiere redirigir a una vista
                getServletContext().getRequestDispatcher("/productosCrud/crearProducto.jsp").forward(request, response);

            }





        }







    }

}