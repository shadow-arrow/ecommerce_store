package hopkq.store.controllers.client;


import hopkq.store.entities.Product;
import hopkq.store.models.AjaxResponseBody;
import hopkq.store.services.CategoryService;
import hopkq.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class FilterProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "filter", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponseBody<Product> getProductByCategoryID(@RequestParam(name = "categoryId") int categoryID) {

        AjaxResponseBody<Product> result = new AjaxResponseBody();
        try {
            List<Product> listProduct = (categoryID == 0) ? productService.getAllProduct() : productService.getProductsByCategoryID(categoryID);
            if (listProduct.isEmpty()) {
                result.setMsg("no data !");
            } else {
                result.setMsg("success");
            }
            result.setListData(listProduct);
        } catch (Exception ex) {
            result.setListData(null);
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "sort", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponseBody<Product> getProductByCategoryIDAndSort(
            @RequestParam(name = "categoryId") int categoryID, @RequestParam(name = "flat") int flat) {

        AjaxResponseBody<Product> result = new AjaxResponseBody();
        try {
            List<Product> listProduct = productService.getProductsByCategoryIDAndSort(categoryID, flat == 1 );
            if (listProduct.isEmpty()) {
                result.setMsg("no data !");
            } else {
                result.setMsg("success");
            }
            result.setListData(listProduct);
        } catch (Exception ex) {
            result.setListData(null);
            result.setMsg(ex.getMessage());
        }
        return result;
    }


}
