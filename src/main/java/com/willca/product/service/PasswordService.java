package com.willca.product.service;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PasswordService {

    public String hash(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    public boolean matches(String password, String hash) {
        return BcryptUtil.matches(password, hash);
    }
}
