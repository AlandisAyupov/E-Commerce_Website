package com.ayupov.Bank.Pictures;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayupov.Bank.Application;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/picture")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class PictureController {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PictureService pictureService;

    @PostMapping("/add")
    public String addPicture(@RequestParam("file") MultipartFile file) {
        
    }
}
