package com.willca.product.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Set;

@MongoEntity(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private ObjectId id;

    private String username;

    private String password;

    private Set<String> roles;
}
