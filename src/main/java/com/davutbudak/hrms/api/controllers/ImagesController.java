package com.davutbudak.hrms.api.controllers;

import com.davutbudak.hrms.business.abstracts.ImageService;
import com.davutbudak.hrms.business.concretes.ImageManager;
import com.davutbudak.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/images/")
public class ImagesController {
    private final ImageService imageService;

    @Autowired
    public ImagesController(ImageManager imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@ModelAttribute Image image, @RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(imageService.add(image,file));
    }
}
