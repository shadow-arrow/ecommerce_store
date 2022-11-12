package hopkq.store.services;

import hopkq.store.models.ProductModel;
import hopkq.store.models.ShoppingCart;

public interface CartService {

    ShoppingCart AddProductToCart(int id, ShoppingCart oldCart);
}
