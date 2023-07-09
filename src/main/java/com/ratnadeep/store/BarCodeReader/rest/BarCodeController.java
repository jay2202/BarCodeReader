package com.ratnadeep.store.BarCodeReader.rest;

import com.ratnadeep.store.BarCodeReader.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ratnadeep.store.BarCodeReader.dto.Product;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
public class BarCodeController {

    @Autowired
    public ProductService service;

    @PostMapping(value = "/barcode/insert", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> insert(@RequestBody Product body){
        return ResponseEntity.ok(service.insertProduct(body));
    }

}