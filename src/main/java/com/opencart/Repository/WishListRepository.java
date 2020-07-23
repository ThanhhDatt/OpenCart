package com.opencart.Repository;

import com.opencart.Model.Product;
import com.opencart.Model.WishList;

import java.util.Collection;

public interface WishListRepository {
    Collection<Product> findAllProductInWishList();
    Collection<Product> addToCart(Product product);
    Collection<Product> removeProductInWishList (Product product);
    void save(WishList wishList);
    WishList findWishListByID(Integer ID);
    Collection<Product> addProduct(Product product);
    Collection<WishList> findWishListByName(String name);
}
