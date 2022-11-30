package hopkq.store.repositories;

import hopkq.store.entities.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order save(Order order);

    List<Order> getOrdersByAccountId(int id);

}