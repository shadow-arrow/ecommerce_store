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

    List<Product> getProductsByCategoryId(int id);

    @Query(value = "SELECT * FROM products Where Category_Id = ?1  order by Price ASC", nativeQuery = true)
    List<Product> getProductsByCategoryIdAndOrderByPriceAsc(int id);

    @Query(value = "SELECT * FROM products Where Category_Id = ?1  order by Price DESC ", nativeQuery = true)
    List<Product> getProductsByCategoryIdAndOrderByPriceDesc(int id);

    @Query(value = "SELECT * FROM products  order by Price ASC", nativeQuery = true)
    List<Product> sortAllProductByPriceAsc();

    @Query(value = "SELECT * FROM products  order by Price DESC ", nativeQuery = true)
    List<Product> sortAllProductByPriceDesc();

    Product getProductById(int id);

}