package com.opencart.Repository;

import com.opencart.Model.Cart;
import com.opencart.Model.Product;

import java.util.Collection;

public interface CartRepository {
    Collection<Product> findAllProduct();
    Collection<Product> removeProductInCart (Product product);
    Collection<Product> addProduct(Product product);
    Cart findCartByID(Integer ID);
    Collection<Cart> findCartByName (String name);
    Collection<Product> addToWishList(Product product);
    void save (Cart cart);
}
