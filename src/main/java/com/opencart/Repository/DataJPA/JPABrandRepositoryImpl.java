package com.opencart.Repository.DataJPA;

import com.opencart.Model.Brand;
import com.opencart.Model.Product;
import com.opencart.Repository.BrandRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class JPABrandRepositoryImpl implements BrandRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Brand> findBrandByName(String name) {
        return null;
    }

    @Override
    public Brand findBrandByID(int ID) {
        return null;
    }

    @Override
    public Collection<Product> removeProductInBrand(int productID) {
        return null;
    }
}
