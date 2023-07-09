package com.ratnadeep.store.BarCodeReader.repository;


import com.ratnadeep.store.BarCodeReader.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BarcodeRepository extends MongoRepository<Product,String> {
}