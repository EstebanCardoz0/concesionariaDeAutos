package com.concesionaria.concesionaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.concesionaria.concesionaria.entity.Imagen;
import com.concesionaria.concesionaria.exception.MiException;
import com.concesionaria.concesionaria.repository.IImagenRepository;

@Service
public class ImagenService {

    @Autowired
    IImagenRepository imagenRepo;

    public Imagen guardar(MultipartFile archivo) throws MiException {

        if (archivo != null) {
            try {
                Imagen imagen = new Imagen();
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepo.save(imagen);
            } catch (Exception e) {

                System.err.println(e.getMessage());
            }
        }

        return null;

    }

    public Imagen actualizar(MultipartFile archivo, Long idImagen) throws MiException {

        if (archivo != null) {
            try {
                Imagen imagen = new Imagen();
                if (idImagen != null) {
                    Optional<Imagen> respuesta = imagenRepo.findById(idImagen);
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepo.save(imagen);
            } catch (Exception e) {

                System.err.println(e.getMessage());
            }
        }

        return null;

    }

}
