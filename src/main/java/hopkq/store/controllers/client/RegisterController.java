package hopkq.store.controllers.client;


import hopkq.store.models.RegisterAccount;
import hopkq.store.services.RegisterAccountService;
import hopkq.store.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private RegisterAccountService registerAccountService;

    @RequestMapping(value = "/register-page", method = RequestMethod.GET)
    public String goToRegisterPage() {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute(name = "register-account") RegisterAccount registerAccount, ModelMap modelMap) {

        boolean result = registerAccountService.handleRegisterAccount(registerAccount);

        if (result) {
            modelMap.addAttribute("message", Common.Status.REGISTER_SUCCESS);
        } else {
            modelMap.addAttribute("message", Common.Status.REGISTER_FAILED);
        }
        return "register";
    }

}
