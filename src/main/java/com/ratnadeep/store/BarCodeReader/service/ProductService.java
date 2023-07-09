package com.ratnadeep.store.BarCodeReader.service;

import com.ratnadeep.store.BarCodeReader.dto.Product;
import com.ratnadeep.store.BarCodeReader.repository.BarcodeRepository;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ProductService {

    @Autowired
    BarcodeRepository repository;

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }
    public BufferedImage insertProduct(Product body) {
        Timestamp timestamp = Timestamp.from(Instant.now());
        String str = String.valueOf(timestamp.getTime());
        body.setBarcode(str.substring(0,12));
        repository.save(body);
        BufferedImage image = generateEAN13BarcodeImage(body.getBarcode());
        return image;
    }
    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

}