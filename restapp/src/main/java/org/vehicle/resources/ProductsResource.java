package org.vehicle.resources;

import org.vehicle.model.Product;
import org.vehicle.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/showroom/brands")
public class ProductsResource {

    ProductService productService = new ProductService();

    @GET
    @Path("/{brandId}/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
                                            @QueryParam("category") String category,
                                            @QueryParam("start") int start,
                                            @QueryParam("end") int end){
        List<Product> productList;
        if(category != null){
            productList = productService.getProductsByBrandAndCategory(brandId, category);
        }else{
            productList = productService.getProductsByBrand(brandId);
        }
        if(end > 0 ){
            productList = productList.subList(start, end);
        }
        return productList;
    }
}
