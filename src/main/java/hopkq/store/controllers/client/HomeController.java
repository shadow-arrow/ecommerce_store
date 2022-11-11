package hopkq.store.controllers.client;

import hopkq.store.entities.Category;
import hopkq.store.entities.Product;
import hopkq.store.services.CategoryService;
import hopkq.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getAllCategories(ModelMap modelMap) {
        List<Product> listProduct = productService.getAllProduct();
        List<Category> listCategory = categoryService.getAllCategory();
        modelMap.addAttribute("listProduct", listProduct);
        modelMap.addAttribute("listCategory", listCategory);
        return "products";
    }


}
