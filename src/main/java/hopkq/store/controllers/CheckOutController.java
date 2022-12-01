package hopkq.store.controllers;


import hopkq.store.entities.Account;
import hopkq.store.entities.AccountDetail;
import hopkq.store.models.AjaxResponseBody;
import hopkq.store.models.InformationOrder;
import hopkq.store.models.ShoppingCart;
import hopkq.store.services.AccountDetailService;
import hopkq.store.services.CartService;
import hopkq.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"listCart", "account"}) // use session in spring
@RequestMapping("")
public class CheckOutController {

    @Autowired
    private AccountDetailService accountDetailService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/check-out-page", method = RequestMethod.GET)
    public String goToPage(@ModelAttribute("account") Account account,
                           @ModelAttribute("listCart") List<ShoppingCart> cartList, ModelMap modelMap) {
        if (account == null) return "redirect:/login-page";
        AccountDetail accountDetail = accountDetailService.getAccountDetailByID(account.getAccountDetailId());
        float totalPrice = cartService.calculatedTotalPriceCart(cartList);
        modelMap.addAttribute("accountInfo", accountDetail);
        modelMap.addAttribute("totalPrice", totalPrice);
        return "checkout";
    }

    @RequestMapping(value = "/check-out", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AjaxResponseBody<String> handleCheckOut(@ModelAttribute("account") Account account,
                                                   @ModelAttribute("listCart") List<ShoppingCart> cartList,
                                                   @RequestBody InformationOrder informationOrder) {
        AjaxResponseBody<String> result = new AjaxResponseBody<>();
        try {
            orderService.saveInformationOrders(cartList, account.getId(), informationOrder);
            result.setMsg("Success");
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setMsg("Error: " + ex.getMessage());
        }
        return result;
    }


    @ModelAttribute("account")
    public Account account() {
        return null;
    }
}
