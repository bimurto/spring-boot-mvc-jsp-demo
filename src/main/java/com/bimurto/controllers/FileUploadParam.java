package com.bimurto.controllers;


import org.springframework.web.multipart.MultipartFile;

public class FileUploadParam {

    private MultipartFile logo;

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }
}
