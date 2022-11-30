package hopkq.store.services.impl;


import hopkq.store.entities.OrderDetail;
import hopkq.store.repositories.OrderDetailRepository;
import hopkq.store.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {


    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
        return orderDetailRepository.getOrderDetailsByOrderId(orderId);
    }
}
