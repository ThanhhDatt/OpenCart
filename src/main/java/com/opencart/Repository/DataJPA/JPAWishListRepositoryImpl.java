package com.opencart.Repository.DataJPA;

import com.opencart.Model.Cart;
import com.opencart.Model.Customer;
import com.opencart.Model.Product;
import com.opencart.Model.WishList;
import com.opencart.Repository.WishListRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@Repository
public class JPAWishListRepositoryImpl implements WishListRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAllProductInWishList() {
        Query query = this.em.createQuery("SELECT productName FROM product p INNER JOIN wishlist-product wp ON wp.productID=p.productID INNER JOIN wishlist w ON w.customerID = wp.customerID");
        return query.getResultList();
    }

    @Override
    public Collection<Product> addToCart(Product product) {
        Cart cart = em.find(Cart.class, 1);
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public Collection<Product> removeProductInWishList(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void save(WishList wishList) {
        if(wishList.getId()==null) this.em.merge(wishList);
        else this.em.persist(wishList);
    }

    @Override
    public Collection<Product> addProduct(Product product) {
        WishList wishList = this.em.find(WishList.class, 1);
        this.em.getTransaction().begin();
        this.em.persist(product);
        this.em.getTransaction().commit();
        return wishList.getProducts();
    }

    @Override
    public Collection<WishList> findWishListByName(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot= query.from(Customer.class);
        //ListJoin<Customer, WishList> tasks = customerRoot.join(Customer_.tasks);
        query.select(customerRoot);
        return null;
    }

    @Override
    public WishList findWishListByID(Integer ID) {
        return null;
    }

}
