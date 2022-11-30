package hopkq.store.repositories;

import hopkq.store.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetailsByOrderId(int orderId);

}