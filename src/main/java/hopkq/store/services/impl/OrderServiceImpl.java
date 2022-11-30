package hopkq.store.services.impl;

import hopkq.store.entities.Order;
import hopkq.store.entities.OrderDetail;
import hopkq.store.entities.ShippingAddress;
import hopkq.store.models.InformationOrder;
import hopkq.store.models.ShoppingCart;
import hopkq.store.repositories.OrderDetailRepository;
import hopkq.store.repositories.OrderRepository;
import hopkq.store.repositories.ShippingAddressRepository;
import hopkq.store.services.CartService;
import hopkq.store.services.OrderService;
import hopkq.store.utils.DataTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private DataTransferObject dto;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Override
    public void saveInformationOrders(List<ShoppingCart> cartList, int accountId, InformationOrder informationOrder) {
        try {
            OrderDetail orderDetail = null;
            Order order = dto.createOrder(accountId, informationOrder.getNote(), cartService.calculatedTotalPriceCart(cartList));
            order = orderRepository.save(order);
            for (ShoppingCart shoppingCart : cartList) {
                orderDetail = dto.createOrderDetail(order.getId(), shoppingCart);
                orderDetail = orderDetailRepository.save(orderDetail);
            }
            ShippingAddress shippingAddress = dto.createShippingAddress(order.getId(), informationOrder);
            shippingAddress = shippingAddressRepository.save(shippingAddress);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrdersByUser(int id) {
        //  return orderRepository.getOrdersByAccountId(id, Sort.by(Sort.Direction.DESC, "createDate"));
        List<Order> listData = orderRepository.getOrdersByAccountId(id);
        listData.sort(Comparator.comparing(Order::getCreateDate).reversed());

        return listData;
    }
}
