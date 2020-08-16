package com.goshgarmirzayev.lastrebound.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;

@Service
public class ImageService {
    public String createImage(MultipartFile[] arr) {
        System.out.println(arr);

        String path = null;
        String randomName = "";
        try {
            randomName = UUID.randomUUID().toString() + ".jpg";

//            Path mappedFile = Paths.get("images/", randomName);
            Path uploadedFile = Paths.get("/projects/allora/images/", randomName);
            Files.write(uploadedFile, arr[0].getBytes());
//            Files.write(mappedFile, arr[0].getBytes());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "/images/" + randomName;
    }

    public void delete(String path) throws IOException {
        Path path1 = Paths.get(path);
        Files.delete(path1);
    }
}
