package hopkq.store.controllers;


import hopkq.store.entities.Category;
import hopkq.store.entities.Product;
import hopkq.store.services.CategoryService;
import hopkq.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("filter")
public class FilterProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllCategories(@RequestParam(name = "categoryId") int categoryID, ModelMap modelMap) {
        List<Product> listProduct = (categoryID == 0) ? productService.getAllProduct() : productService.getProductByCategoryID(categoryID);
        List<Category> listCategory = categoryService.getAllCategory();
        modelMap.addAttribute("listProduct", listProduct);
        modelMap.addAttribute("listCategory", listCategory);
        return "products";
    }


}
