# willca-product-api

## Generate keys

```bash script mac
openssl version
mkdir -p src/main/resources/jwt
```
```bash crear private key
openssl genrsa -out src/main/resources/jwt/product-private-key.pem 2048
```

```bash crear public key
openssl rsa \
-in src/main/resources/jwt/product-private-key.pem \
-pubout \
-out src/main/resources/jwt/product-public-key.pem
```
```bash conversion de private key PKCS#8
openssl pkcs8 \
-topk8 \
-nocrypt \
-in src/main/resources/jwt/product-private-key.pem \
-out src/main/resources/jwt/product-private-key-pkcs8.pem
```


