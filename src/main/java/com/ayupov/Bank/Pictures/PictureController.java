package com.ayupov.Bank.Pictures;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayupov.Bank.Application;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/picture")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class PictureController {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PictureService pictureService;

    @GetMapping(
        value = "/get",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImageWithMediaType(@RequestParam String pictureID) throws IOException {
        log.info(pictureID);
        Base64.Decoder decoder = Base64.getDecoder();
        return decoder.decode(pictureService.getPicture(pictureID).getData());
    }

    @PostMapping("/add")
    public String addPicture(@RequestParam("file") MultipartFile file) {
        try {
            String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
            Picture picture = new Picture();
            UUID uuid = UUID.randomUUID();
            picture.setPictureID(uuid.toString());
            picture.setData(encodedString);
            picture.setEncoding("base64");
            if(pictureService.addPicture(picture) == 200)
                return picture.getPictureID();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
