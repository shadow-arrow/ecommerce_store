package hopkq.store.controllers;


import hopkq.store.entities.Product;
import hopkq.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getDetailProduct(@RequestParam(name = "id") int id, ModelMap modelMap) {

        Product product = productService.getProductByID(id);
        modelMap.addAttribute("product", product);
        return "product-detail";
    }


}
