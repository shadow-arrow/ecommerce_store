package hopkq.store.services;

import hopkq.store.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> getOrderDetailByOrderId(int id);

}
