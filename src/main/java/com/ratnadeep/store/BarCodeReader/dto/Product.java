package com.ratnadeep.store.BarCodeReader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Products")
public class Product {
    @Id
    String id;
    @JsonProperty("Product")
    String productName;
    @JsonProperty("Barcode")
    String barcode;
    @JsonProperty("Expiry")
    String expiryDate;
    @JsonProperty("Mfg. Date")
    String manufacturingDate;
    @JsonProperty("Price")
    Double price;
}