package com.opencart.Repository.DataJPA;

import com.opencart.Model.Cart;
import com.opencart.Model.Product;
import com.opencart.Model.WishList;
import com.opencart.Repository.CartRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.CollectionEndEvent;

import javax.persistence.*;
import java.util.Collection;

@Repository
public class JPACartRepositoryImpl implements CartRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public Collection<Product> findAllProduct() {
        Query query = this.em.createQuery(
                "SELECT productName FROM product p " +
                        "INNER JOIN cart-product cp ON cp.productId = p.productId " +
                        "INNER JOIN cart c ON c.customerId = cp.customerId");
        Collection<Product> products = query.getResultList();
        return products;
    }

    @Override
    @Transactional
    public Collection<Product> addToWishList(Product product) {
        this.em.getTransaction().begin();
        this.em.persist(product);
        this.em.getTransaction().commit();
        Query query = this.em.createQuery(
                "SELECT * FROM product p " +
                        "INNER JOIN wishlist-product wp ON wp.productID = p.productID\n");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Collection<Product> removeProductInCart(Product product) {
        //DELETE FROM cart-product cp WHERE cp.productID = productID
        Query query = this.em.createQuery("DELETE FROM cart-product cp WHERE cp.productID = :productID", Product.class);
        Collection<Product> products = query.setParameter("productID", product.getId()).getResultList();
        return products;
    }

    @Override
    @Transactional
    public Collection<Product> addProduct(Integer productID, Integer customerID) {
        Query query = this.em.createQuery("INSERT INTO cart-product(customerID, productID) VALUES (:customerId, :productID)");
        query.setParameter("productID", productID).setParameter("customerID", customerID).getResultList();
        Query query1 = this.em.createQuery(
                "SELECT productName FROM product p " +
                        "INNER JOIN cart-product cp ON cp.productID = p.productID");
        Collection<Product> products = query1.getResultList();
        return products;
    }

    @Override
    @Transactional
    public String findCartByID(Integer ID) {
        Query query = this.em.createQuery("SELECT customerName cus FROM customer c" +
                "INNER JOIN cart c ON c.customerID = cus.customerID" +
                "WHERE cus.customerID = :ID");
        String name = (String) query.setParameter("ID", ID).getSingleResult();
        return name;
    }

    @Override
    @Transactional
    public Collection<Cart> findCartByName(String name) {
        Query query = this.em.createQuery("SELECT customerName cus FROM customer c" +
                "INNER JOIN cart c ON c.customerID = cus.customerID" +
                "WHERE cus.customerName = :customerName");
        Collection<Cart> carts = query.setParameter("customerName", name).getResultList();
        return carts;
    }

    @Override
    @Transactional
    public void save(Cart cart) {
        if (cart.getId() == null) this.em.persist(cart);
        else this.em.merge(cart);
    }
}
