package com.product.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.in.DtoProductImageIn;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProductImage;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;

@Service
public class SvcProductImageImp implements SvcProductImage {

    @Autowired
    RepoProductImage repo;

    @Value("${app.upload.dir}")
    private String uploadDir;

    @Value("${app.upload.images}")
    private String uploadImages;

    @Override
    public ProductImage getProductImages(Integer productId) {
        try {
            return repo.findByProductId(productId);
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    @Override
    public String upload(Integer productId, DtoProductImageIn in) {
        try {
            // Eliminar el prefijo "data:image/png;base64," si existe
            if (in.getImage().startsWith("data:image")) {
                int commaIndex = in.getImage().indexOf(",");
                if (commaIndex != -1) {
                    in.setImage(in.getImage().substring(commaIndex + 1));
                }
            }

            // Decodifica la cadena Base64 a bytes
            byte[] imageBytes = Base64.getDecoder().decode(in.getImage());

            // Genera un nombre único para la imagen
            String fileName = UUID.randomUUID().toString() + ".png";

            // Construye la ruta completa donde se guardará la imagen
            Path imagePath = Paths.get(uploadDir, "img", "product", fileName);

            // Asegurarse de que el directorio exista
            Files.createDirectories(imagePath.getParent());

            // Escribir el archivo en el sistema de archivos
            Files.write(imagePath, imageBytes);

            // Crear nueva entidad y guardar en base de datos
            ProductImage productImage = new ProductImage();
            productImage.setProductId(productId);
            productImage.setImage("/" + uploadDir + "/img/product/" + fileName);
            productImage.setStatus(1);
            repo.save(productImage);

            return "La imagen ha sido registrada";

        } catch (IOException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el archivo");
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }

    @Override
    public String deleteProductImage(Integer productImageId) {
        try {
            ProductImage productImage = repo.findById(productImageId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "La imagen no existe"));
            repo.delete(productImage);
            return "La imagen ha sido eliminada";
        } catch (DataAccessException e) {
            throw new DBAccessException(e);
        }
    }
}