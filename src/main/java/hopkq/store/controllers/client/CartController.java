package hopkq.store.controllers.client;

import hopkq.store.models.AjaxResponseBody;
import hopkq.store.models.ShoppingCart;
import hopkq.store.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("listCart") // use session trong spring
@RequestMapping("")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "add-to-cart", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponseBody<ShoppingCart> addProductToCart(@ModelAttribute("listCart") List<ShoppingCart> cartList, ModelMap modelMap,
                                                           @RequestParam(name = "id") int id,
                                                           @RequestParam(name = "quantity") int quantity) {

        AjaxResponseBody<ShoppingCart> result = new AjaxResponseBody();
        try {
            cartList = cartService.AddProductToCart(id, quantity, cartList);
            if (cartList.isEmpty()) {
                result.setMsg("no data !");
            } else {
                result.setMsg("success");
            }
            result.setListData(cartList);
        } catch (Exception ex) {
            result.setListData(null);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "calculate-cart", method = RequestMethod.GET)
    @ResponseBody
    public String calculateProductQuantity(@ModelAttribute("listCart") List<ShoppingCart> cartList, ModelMap modelMap,
                                           @RequestParam(name = "id") int id,
                                           @RequestParam(name = "flat") int flat) {

        cartList = cartService.updateProductQuantity(cartList, id, flat == 2);
        float totalPrice = cartService.calculatedTotalPriceCart(cartList);
        modelMap.addAttribute("listCart", cartList);
        modelMap.addAttribute("totalPrice", totalPrice);
        return "update-successfully";
    }

    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String getCartList(@ModelAttribute("listCart") List<ShoppingCart> cartList, ModelMap modelMap) {

        float totalPrice = cartService.calculatedTotalPriceCart(cartList);
        modelMap.addAttribute("listCart", cartList);
        modelMap.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @RequestMapping(value = "remove-cart", method = RequestMethod.GET)
    public String removeProductInCart(@ModelAttribute("listCart") List<ShoppingCart> cartList,
                                      @RequestParam(name = "id") int id, ModelMap modelMap) {

        cartList = cartService.removeProductInCart(cartList, id);
        float totalPrice = cartService.calculatedTotalPriceCart(cartList);
        modelMap.addAttribute("listCart", cartList);
        modelMap.addAttribute("totalPrice", totalPrice);
        return "cart";
    }


    @ModelAttribute("listCart") // if session search cartList isn't exist -> initialize new cartList
    public List<ShoppingCart> shoppingCart() {
        return new ArrayList<>();
    }
}