package com.willca.product.resource;

import com.willca.product.dto.ProductRequest;
import com.willca.product.dto.ProductResponse;
import com.willca.product.model.Product;
import com.willca.product.service.ProductService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GET
    @Path("/status")
    public List<ProductResponse> findByStatus(@QueryParam("status") String status) {
        return productService.findByStatus(status);
    }

    @GET
    @Path("/{id}")
    public ProductResponse findById(@PathParam("id") ObjectId id) {
        return productService.findById(id);
    }

    @POST
    public ProductResponse create(@Valid ProductRequest product) {
        return productService.create(product);
    }

    @PUT
    @Path("/{id}")
    public ProductResponse update(@PathParam("id") ObjectId id, @Valid Product product) {
        return productService.update(id, product);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") ObjectId id) {
        productService.delete(id);
        return Response.noContent().build();
    }
}