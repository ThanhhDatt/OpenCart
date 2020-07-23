package com.opencart.Service;

import com.opencart.Model.*;


import java.util.Collection;

public interface OpenCartService {
    Collection<Product> showCartProduct();
    Collection<Product> showWishListProduct();
    Collection<Product> addProductToCart(Product product);
    Collection<Product> addProductToWishList(Product product);
    Collection<Product> findProductByName(String name);
    Product findProductByID(Integer ID);
    Collection<Cart> findCartByName (String name);
    Cart findCartByID(Integer ID);
    WishList findWishListByCustomerID (Integer ID);
    Collection<WishList> finsWishListByCustomerName(String name);
    Collection<Brand> findBrandByName(String name);
    Brand findBrandByID(Integer ID);
    Collection<Category> findCategoryByName(String name);
    Category findCategoryByID(Integer ID);
    Collection<Customer> findCustomerByName(String name);
    Customer findCustomerByID(Integer ID);
    Collection<Product> removeProductFromCart(Product product);
}
