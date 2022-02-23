package com.example.webexample.controllers;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class FileController {

    @PostMapping("/uploadFile")

    //Send a file to a specific folder
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = Paths.get("C:\\Users\\keyrus\\Desktop\\Helidon\\" + fileName);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return "File uploaded successfully";
    }
    //Get an image with a path
    @GetMapping(value = "downloadFile", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] downloadImage() throws IOException {

        File file = new File("C:\\Users\\keyrus\\Desktop\\Helidon\\sesion 8 de febrero 2.jpg");
        byte[] bytes = new byte[(int) file.length()];

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        dataInputStream.readFully(bytes);

        return bytes;


    }
}
