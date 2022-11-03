package hopkq.store.repositories;

import hopkq.store.entities.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Integer> {
}