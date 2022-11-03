package hopkq.store.repositories;

import hopkq.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products Where Status in (?1)", nativeQuery = true)
    List<Product> findAllByStatusIn(String[] status);

}