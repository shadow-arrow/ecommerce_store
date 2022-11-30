package hopkq.store.services;

import hopkq.store.entities.AccountDetail;

public interface AccountDetailService {

    AccountDetail save(AccountDetail accountDetail);

    AccountDetail getAccountDetailByID(int id);

}
