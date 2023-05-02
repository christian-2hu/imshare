package com.imshare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imshare.models.Images;
import com.imshare.response.ResponseHandler;
import com.imshare.services.ImagesService;

@RestController
@RequestMapping("/api/v1")
public class ImagesController {

    @Autowired
    ImagesService imagesService;

    @PostMapping("/images")
    public @ResponseBody ResponseEntity<Object> saveCostumer(@RequestBody MultipartFile file) {
        try {
            Images newImage = imagesService.saveImage(file);
            return ResponseHandler.generateResponse("Successfully added!", HttpStatus.OK, newImage);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
