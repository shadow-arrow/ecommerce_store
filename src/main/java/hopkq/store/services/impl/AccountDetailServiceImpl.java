package hopkq.store.services.impl;

import hopkq.store.entities.AccountDetail;
import hopkq.store.repositories.AccountDetailRepository;
import hopkq.store.services.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    @Autowired
    private AccountDetailRepository accountDetailRepository;


    @Override
    public AccountDetail save(AccountDetail accountDetail) {

        return accountDetailRepository.save(accountDetail);
    }

    @Override
    public AccountDetail getAccountDetailByID(int id) {
        return accountDetailRepository.getAccountDetailById(id);
    }


}
