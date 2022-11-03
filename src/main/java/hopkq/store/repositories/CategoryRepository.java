package hopkq.store.repositories;

import hopkq.store.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM baloshop.categories", nativeQuery = true)
    List<Category> getAllCategory();

}