package hopkq.store.services;


import hopkq.store.entities.Order;
import hopkq.store.models.InformationOrder;
import hopkq.store.models.ShoppingCart;

import java.util.List;

public interface OrderService {

    void saveInformationOrders(List<ShoppingCart> cartList, int accountId, InformationOrder informationOrder);

    List<Order> getAllOrdersByUser(int id);

}
