package hopkq.store.repositories;

import hopkq.store.entities.StatusProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusProductRepository extends JpaRepository<StatusProduct, Integer> {
}