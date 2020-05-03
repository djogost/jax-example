package org.vehicle.service;

import org.vehicle.DAO.BrandsDAO;
import org.vehicle.model.Brand;

import java.util.List;

public class BrandsService {

    BrandsDAO DAO = new BrandsDAO();

    public List<Brand> getBrands() {
        List<Brand> list = DAO.getBrands();
        return list;
    }

    public void addBrand(Brand brand) {
        DAO.addBrand(brand);
    }

    public void updateBrand(Brand brand) {
        DAO.updateBrand(brand);
    }

    public void deleteBrand(int brandId) {
        DAO.deleteBrand(brandId);
    }


    public Brand getBrand(int brandId) {
        return DAO.getBrand(brandId);
    }
}
