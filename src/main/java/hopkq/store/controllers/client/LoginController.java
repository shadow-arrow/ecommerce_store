package hopkq.store.controllers.client;

import hopkq.store.entities.Account;
import hopkq.store.models.ShoppingCart;
import hopkq.store.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("account")
@RequestMapping("")
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login-page", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public String login(@RequestParam(name = "txtEmail") String email,
                        @RequestParam(name = "txtPassword") String password,
                        @ModelAttribute("account") Account account, ModelMap modelMap) {

        account = accountService.login(email, password);
        if (account != null) {
            modelMap.addAttribute("account", account);
            return "redirect:/home";
        }
        modelMap.addAttribute("message", "INVALID USER OR PASSWORD");

        return "login";
    }

    @ModelAttribute("account") // if session search cartList isn't exist -> initialize new cartList
    public Account account() {
        return new Account();
    }

}
