package com.opencart.Repository;

import com.opencart.Model.Brand;
import com.opencart.Model.Product;

import java.util.Collection;


public interface BrandRepository {
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(int ID);
    Collection<Product> removeProductInBrand (int productID);
}
