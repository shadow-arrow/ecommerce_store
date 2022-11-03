package hopkq.store.repositories;

import hopkq.store.entities.StatusAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusAccountRepository extends JpaRepository<StatusAccount, Integer> {
}