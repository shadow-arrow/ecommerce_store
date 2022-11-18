package hopkq.store.services;


import hopkq.store.entities.Account;

public interface AccountService {

    Account save(Account Account);

    Account getAccountByEmail(String email);

    Account login(String email, String password);

}
