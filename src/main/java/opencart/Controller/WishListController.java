package opencart.Controller;

import opencart.Model.Customer;
import opencart.Model.WishList;
import opencart.Service.ServiceInt.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class WishListController {
    private final WishListService wishListService;

    @Autowired
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("wishlist")
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/wishlist.html")
    public ModelAndView showWishList(){
        WishList wishList = new WishList();
        ModelAndView mav = new ModelAndView();
        mav.addObject(this.wishListService.showProductByWishList());
        return mav;
    }

//    @ModelAttribute("customer")
//    public Customer findCustomer(@PathVariable("customerID") Integer customerId) {
//        return this.WishList.findCustomerByID(customerId);
//    }

    @ModelAttribute("wishlist")
    public WishList findWishList(@PathVariable("wishlistID") Integer wishlistID) {
        return this.wishListService.findWishListByID(wishlistID);
    }

    @PostMapping(value = "/customer/{customerId}/wishlist/{wishlistID}/product/new")
    public String addProductToWishList(@Valid Integer productID, @Valid Integer customerID, BindingResult result){
        if (result.hasErrors()) {
            return "wishlist/createOrUpdateProduct";
        } else {
            this.wishListService.addProductToWishList(productID, customerID);
            return "redirect:/wishlist/{customerID}";
        }
    }

}