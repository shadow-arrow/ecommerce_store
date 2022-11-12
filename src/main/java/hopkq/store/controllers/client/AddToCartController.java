package hopkq.store.controllers.client;


import hopkq.store.models.ShoppingCart;
import hopkq.store.services.CartService;
import hopkq.store.services.CategoryService;
import hopkq.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("addtocart")
public class AddToCartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addProductToCart(@ModelAttribute("cart") ShoppingCart shoppingCart, ModelMap modelMap,
                                   @RequestParam(name = "id") int id) {

        shoppingCart = cartService.AddProductToCart(id, shoppingCart);
        modelMap.addAttribute("cart", shoppingCart);
        return "cart";
    }


    @ModelAttribute("cart")
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
/*        boolean derect = true;

        Product product = new ProductModel().getOneProduct(id);
        Cart cart = new Cart(id, product.getName(), product.getPrice(), 1);

        HttpSession session = request.getSession();
        List<Cart> listOrder = null;
        listOrder = (ArrayList<Cart>) session.getAttribute("listCart");

        boolean flat = true;
        if (listOrder == null) {
            listOrder = new ArrayList<>();
            listOrder.add(cart);
            session.setAttribute("listCart", listOrder);
        } else {
            for (Cart c : listOrder) {
                if (c.getProductId() == id) {
                    c.setQuantity(c.getQuantity() + 1);
                    flat = false;
                }
            }
            if (flat) {
                listOrder.add(cart);
                flat = true;
            }
            session.setAttribute("listCart", listOrder);
        }
        if (derect) {
            response.sendRedirect("products.jsp");
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product-detail.jsp").forward(request, response);
        }
*/