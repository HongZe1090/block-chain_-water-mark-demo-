package com.example.clientfont_serve.Controller;

import com.example.clientfont_serve.Service.saveOrUpdateImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    private saveOrUpdateImageFile saveOrUpdateImageFile;

    @CrossOrigin
    @PostMapping("/Upload")
    public String Upload(MultipartFile image) throws IOException {

        System.out.println(image);
        String path = saveOrUpdateImageFile.saveOrUpdateImageFile(image);
        System.out.println(path);
        return "ok";

    }
}
