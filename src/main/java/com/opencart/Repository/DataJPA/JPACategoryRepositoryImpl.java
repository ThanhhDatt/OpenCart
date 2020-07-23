package com.opencart.Repository.DataJPA;

import com.opencart.Model.Category;
import com.opencart.Model.Product;
import com.opencart.Repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.Collection;

@Repository
public class JPACategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Product> findProductByCategory(int CategoryID) {
        return null;
    }

    @Override
    public Collection<Category> findCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public Category findCategoryById(int categoryID) {
        return null;
    }

    @Override
    public void save(Category category) {

    }
}
