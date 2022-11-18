package hopkq.store.services.impl;

import hopkq.store.entities.Product;
import hopkq.store.models.ShoppingCart;
import hopkq.store.repositories.ProductRepository;
import hopkq.store.services.CartService;
import hopkq.store.utils.DataTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DataTransferObject dto;

    @Override
    public List<ShoppingCart> AddProductToCart(int id, int quantity, List<ShoppingCart> cartList) {

        Product product = productRepository.getProductById(id);
        ShoppingCart shoppingCart = dto.convertProductToShoppingCart(product, quantity);
        if (cartList.isEmpty()) {
            cartList.add(shoppingCart);
        } else {
            boolean checkExist = false;
            for (ShoppingCart sc : cartList) {
                if (sc.getId() == shoppingCart.getId()) {
                    sc.setQuantity(sc.getQuantity() + quantity);
                    checkExist = true;
                }
            }
            if (!checkExist) {
                cartList.add(shoppingCart);
            }
        }

        return cartList;
    }


    public float calculatedTotalPriceCart(List<ShoppingCart> cartList) {
        float total = 0;
        for (ShoppingCart sc : cartList) {
            total += sc.getUnitPrice() * sc.getQuantity();
        }
        return total;
    }

    @Override
    public List<ShoppingCart> updateProductQuantity(List<ShoppingCart> cartList, int id, boolean plus) {

        for (ShoppingCart sc : cartList) {
            if (sc.getId() == id) {
                sc.setQuantity((plus) ? sc.getQuantity() + 1 : sc.getQuantity() - 1);
                if (sc.getQuantity() <= 0) cartList.remove(sc);
            }
        }
        return cartList;
    }

    @Override
    public List<ShoppingCart> removeProductInCart(List<ShoppingCart> cartList, int id) {
        // bug here
        if (id == 0) {
            cartList.removeAll(cartList);
        } else {
            for (ShoppingCart sc : cartList) {
                if (sc.getId() == id) {
                    cartList.remove(sc);
                    return cartList;
                }
            }
        }
        return cartList;
    }
}
