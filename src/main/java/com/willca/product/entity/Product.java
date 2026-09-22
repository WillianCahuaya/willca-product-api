package com.willca.product.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@MongoEntity(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private ObjectId id;
    private String name;
    private Double price;
    private String status;
}
