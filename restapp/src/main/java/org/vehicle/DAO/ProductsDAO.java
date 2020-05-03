package org.vehicle.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vehicle.model.Brand;
import org.vehicle.model.Product;

import java.util.List;

public class ProductsDAO {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Brand.class)
            .buildSessionFactory();

    public List<Product> getProductsByBrand(int brandId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> productList;
        String hql ="from products where brandId ='"+ brandId + "'";
        productList = session.createQuery(hql).getResultList();
        return productList;
    }

    public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> productList;
        String hql ="from products where brandId ='"+ brandId + "' and category='" + category + "'";
        productList = session.createQuery(hql).getResultList();
        return productList;
    }

}
