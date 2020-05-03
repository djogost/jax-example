package org.vehicle.service;

import org.vehicle.DAO.ProductsDAO;
import org.vehicle.model.Product;

import java.util.List;

public class ProductService {

    ProductsDAO DAO = new ProductsDAO();


    public List<Product> getProductsByBrand(int brandId) {
        List<Product> productList = DAO.getProductsByBrand(brandId);
        return productList;
    }

    public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
        List<Product> productList = DAO.getProductsByBrandAndCategory(brandId, category);
        return productList;
    }
}
