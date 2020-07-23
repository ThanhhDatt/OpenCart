package com.opencart.Repository.DataJPA;

import com.opencart.Model.Cart;
import com.opencart.Model.Product;
import com.opencart.Model.WishList;
import com.opencart.Repository.CartRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JPACartRepositoryImpl implements CartRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProduct() {
        Query query = this.em.createQuery("SELECT productName FROM product p INNER JOIN cart-product cp ON cp.productId = p.productId INNER JOIN cart c ON c.customerId = cp.customerId");
        return query.getResultList();
    }

    @Override
    public Collection<Product> addToWishList(Product product) {
        WishList wishlist = em.find(WishList.class, 1);
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public Collection<Product> removeProductInCart(Product product) {
        return null;
    }

    @Override
    public Collection<Product> addProduct(Product product) {
        Cart cart = em.find(Cart.class, 1);
        this.em.getTransaction().begin();
        this.em.persist(product);
        this.em.getTransaction().commit();
        return cart.getProducts();
    }

    @Override
    public Cart findCartByID(Integer ID) {
        return null;
    }

    @Override
    public Collection<Cart> findCartByName(String name) {
        return null;
    }

    @Override
    public void save(Cart cart) {
        if (cart.getId() == null) this.em.persist(cart);
        else this.em.merge(cart);
    }
}
