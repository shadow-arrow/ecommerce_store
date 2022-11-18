package hopkq.store.repositories;

import hopkq.store.entities.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Integer> {

    AccountDetail save(AccountDetail accountDetail);



}