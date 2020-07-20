package Service;

import Model.Cart;
import Model.Category;
import Model.Product;
import Model.WishList;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class OpenCartServiceImpl implements OpenCartService{

    private BrandRepository brandRepository;
    private CartRepository cartRepository;
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private WishListRepository wishListRepository;

    @Autowired
    public OpenCartServiceImpl(BrandRepository brandRepository,
                               CartRepository cartRepository,
                               CategoryRepository categoryRepository,
                               CustomerRepository customerRepository,
                               OrderRepository orderRepository,
                               ProductRepository productRepository,
                               WishListRepository wishListRepository){
        this.brandRepository = brandRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.wishListRepository = wishListRepository;
    }

    @Override
    public Collection<Product> showCartProduct() {
        return null;
    }
}
