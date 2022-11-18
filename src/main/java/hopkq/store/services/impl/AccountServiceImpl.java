package hopkq.store.services.impl;

import hopkq.store.entities.Account;
import hopkq.store.repositories.AccountRepository;
import hopkq.store.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByEmail(String email) {

        return accountRepository.getAccountByEmail(email);
    }

    @Override
    public Account login(String email, String password) {

        Account account = getAccountByEmail(email);
        if (account == null) return null;
        else {
            if (account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }
}
