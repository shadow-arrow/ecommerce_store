package hopkq.store.models;

import hopkq.store.entities.OrderDetail;
import hopkq.store.entities.ShippingAddress;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailModel {

    List<OrderDetail> listOrderDetail;

    ShippingAddress shippingAddress;

}
