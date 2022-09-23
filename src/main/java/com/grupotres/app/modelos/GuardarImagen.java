package com.grupotres.app.modelos;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.http.Part;

public class GuardarImagen {

    String[] extenciones = {".ico", ".png", ".jpg", ".jpeg"};

    public String imagenEnDirectorio(Part part, File ruta) {

        String rutaRetornar = "";


        try {

            //se toma la ruta del archivo subido en el formulario
            Path rutaFotoSubida = Paths.get(part.getSubmittedFileName());

            //se toma el nombre del archivo apartir de la ruta del archivo
            String nombreFotoSubida = rutaFotoSubida.getFileName().toString();

            //se extrae informacion binaria de la foto
            InputStream binarioFotoSubida = part.getInputStream();

            //valida si hay informacion binaria o no de la foto
            if(binarioFotoSubida != null) {

                File fotoEnServidor = new File(ruta, nombreFotoSubida);

                rutaRetornar = "http://localhost:8080/lienzoart/imagenesProductos/" + nombreFotoSubida;

                //Se envia el binario de la foto a la ruta que retorna
                Files.copy(binarioFotoSubida, fotoEnServidor.toPath());


            }


        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return rutaRetornar;

    }

    public boolean validarExtension(String nombreRuta) {

        for(String extencion: extenciones) {

            if(nombreRuta.toLowerCase().endsWith(extencion)) {

                return true;

            }

        }

        return false;

    }





}
