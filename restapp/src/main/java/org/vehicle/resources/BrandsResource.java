package org.vehicle.resources;

import org.vehicle.model.Brand;
import org.vehicle.model.Link;
import org.vehicle.service.BrandsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/showroom/brands")
public class BrandsResource {

    BrandsService service = new BrandsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Brand> getBrands(){
        List<Brand> list = service.getBrands();
        return list;
    }

    @GET
    @Path("/{brandId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brand getBrand(@PathParam("brandId") int brandId, @Context UriInfo uri){

        Link self = new Link(uri.getAbsolutePath().toString(),"self");
        //Link products = new Link(uri.getAbsolutePathBuilder().path("products").build().toString(), "products");
        String productsUri = uri.getBaseUriBuilder()
                .path(ProductsResource.class)
                .path(ProductsResource.class, "getProductsByBrand")
                .resolveTemplate("brandId", brandId)
                .toString();
        Link products = new Link(productsUri, "products");
        Brand brand = service.getBrand(brandId);
        List<Link> links = new ArrayList<>();
        links.add(self);
        links.add(products);
        brand.setLinks(links);
        return brand;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBrands(Brand brand, @Context UriInfo uri){

        service.addBrand(brand);
        URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
        //URI location = URI.create(uri.getAbsolutePath().toString()+ "/" + brand.getBrandId());
        return Response.created(location).entity(brand).build();
                //status(Response.Status.CREATED).entity(brand).build();
    }

    @PUT
    @Path("/{brandId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putBrands(@PathParam("brandId") int brandId, Brand brand){
        brand.setBrandId(brandId);
        service.updateBrand(brand);
    }

    @DELETE
    @Path("/{brandId}")
    public void deleteBrands(@PathParam("brandId") int brandId){
        service.deleteBrand(brandId);
    }

    /*@Path("/{brandId}/products")
    public Products productsDelegation(){
        return new Products();
    }*/
}
