package hopkq.store.services.impl;

import hopkq.store.entities.Account;
import hopkq.store.entities.AccountDetail;
import hopkq.store.models.RegisterAccount;
import hopkq.store.services.RegisterAccountService;
import hopkq.store.utils.DataTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountServiceImpl implements RegisterAccountService {

    @Autowired
    private DataTransferObject dto;

    @Override
    public boolean handleRegisterAccount(RegisterAccount registerAccount) {

        Account account = dto.convertRegisterAccountToAccount(registerAccount);
        AccountDetail accountDetail = dto.convertRegisterAccountToAccountDetail(registerAccount);


        return false;
    }
}
