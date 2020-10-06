package com.bimurto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@ModelAttribute("fileUploadParam") FileUploadParam fileUploadParam, Model model,
                             HttpSession session) throws Exception {

        MultipartFile fileUpload = fileUploadParam.getLogo();
        System.out.println(fileUpload.getName());

        Byte[] byteObjects = new Byte[fileUpload.getBytes().length];
        int i = 0;
        for (byte b : fileUpload.getBytes()){
            byteObjects[i++] = b;
        }

        return "redirect:/hello";
    }
}
