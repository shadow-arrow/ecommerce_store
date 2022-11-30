package hopkq.store.controllers.client;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ThanksController {

    @RequestMapping(value = "/thank-page", method = RequestMethod.GET)
    public String goToThanksPage(HttpSession session) {
        session.removeAttribute("listCart");
        return "thanks";
    }
}
