package com.http.servlet;


import com.http.service.ImageService;
import com.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(UrlPath.IMAGES + "/*")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = ImageService.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String imagePath = requestURI.replace("/images", "");

        imageService.get(imagePath)
                .ifPresentOrElse(image -> {
                    resp.setContentType("application/octet-stream");
                    writeImage(image, resp);
                }, () -> resp.setStatus(404));

    }

    private void writeImage(InputStream image, HttpServletResponse resp) {
        try (image;
            var outputStream = resp.getOutputStream()) {

            int currentByte;
            while ((currentByte = image.read()) != -1) {
                outputStream.write(currentByte);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
