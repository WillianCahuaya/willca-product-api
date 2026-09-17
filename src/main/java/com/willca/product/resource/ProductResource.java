package com.willca.product.resource;

import com.willca.product.model.Product;
import com.willca.product.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GET
    @Path("/status")
    public List<Product> findByStatus(@QueryParam("status") String status) {
        return productService.findByStatus(status);
    }

    @GET
    @Path("/{id}")
    public Product findById(@PathParam("id") ObjectId id) {
        return productService.findById(id);
    }

    @POST
    public Product create(Product product) {
        return productService.create(product);
    }

    @PUT
    @Path("/{id}")
    public Product update(@PathParam("id") ObjectId id, Product product) {
        return productService.update(id, product);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") ObjectId id) {
        productService.delete(id);
        return Response.noContent().build();
    }
}