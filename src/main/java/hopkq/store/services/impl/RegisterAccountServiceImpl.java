package hopkq.store.services.impl;

import hopkq.store.entities.Account;
import hopkq.store.entities.AccountDetail;
import hopkq.store.models.RegisterAccount;
import hopkq.store.repositories.AccountDetailRepository;
import hopkq.store.repositories.AccountRepository;
import hopkq.store.services.RegisterAccountService;
import hopkq.store.utils.DataTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountServiceImpl implements RegisterAccountService {

    @Autowired
    private DataTransferObject dto;

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean handleRegisterAccount(RegisterAccount registerAccount) {

        try {
            AccountDetail accountDetail = dto.convertRegisterAccountToAccountDetail(registerAccount);
            accountDetail = accountDetailRepository.save(accountDetail);
            Account account = dto.convertRegisterAccountToAccount(registerAccount);
            account.setAccountDetailId(accountDetail.getId());
            account = accountRepository.save(account);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
