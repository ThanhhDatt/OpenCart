package com.opencart.Repository.DataJPA;

import com.opencart.Model.Product;
import com.opencart.Repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.Collection;

@Repository
public class JPAProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Product> findAllProduct() {
        return null;
    }

    @Override
    public Collection<Product> findByName(String name) {
        return null;
    }

    @Override
    public Collection<Product> findByBrandName() {
        return null;
    }

    @Override
    public Product findByID(int ID) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Collection<Product> addToCart(int productID, int cartID) {
        return null;
    }

    @Override
    public Collection<Product> addToWishList(int productID, int wishListID) {
        return null;
    }
}
