package opencart.Controller;

import opencart.Model.Customer;
import opencart.Service.ServiceInt.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/loginPage")
    public String showLogin(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "Login/loginPage";
    }

//    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
//    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
//                                     @RequestParam("accountName") String accountName,
//                                     @RequestParam("password") String password) {
//        ModelAndView mav = new ModelAndView("Login/loginPage");
//        Customer customer = this.customerService.findCustomerByAccountAndPassword(accountName, password);
//        return mav;
//    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("customer") Customer customer) {
        ModelAndView mav = new ModelAndView("Login/loginPage");
        customerService.findCustomerByAccountAndPassword(customer.getAccountName(), customer.getPassword());
        return mav;
    }
}
