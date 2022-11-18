package hopkq.store.services;

import hopkq.store.models.ProductModel;
import hopkq.store.models.ShoppingCart;

import java.util.List;

public interface CartService {

    List<ShoppingCart> AddProductToCart(int id, int quantity, List<ShoppingCart> listCart);

    float calculatedTotalPriceCart(List<ShoppingCart> cartList);

    List<ShoppingCart> updateProductQuantity(List<ShoppingCart> cartList, int id, boolean plus);

    List<ShoppingCart> removeProductInCart(List<ShoppingCart> cartList, int id);
}
