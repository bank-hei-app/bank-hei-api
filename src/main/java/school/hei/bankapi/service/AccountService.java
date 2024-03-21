package school.hei.bankapi.service;

import org.springframework.stereotype.Service;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.repository.AccountCrudOperations;
import school.hei.bankapi.repository.CrudOperations;

import java.util.List;
@Service
public class AccountService {

    private final CrudOperations<Account, Integer> accountCrudOperations;

    public AccountService() {
        this.accountCrudOperations = new AccountCrudOperations();
    }

    public List<Account> findAllAccounts() {
        return accountCrudOperations.findAll();
    }

    public Account findAccountById(Integer id) {
        return accountCrudOperations.findById(id);
    }

    public Account saveAccount(Account account) {
        return accountCrudOperations.save(account);
    }

    public List<Account> saveAllAccounts(List<Account> accounts) {
        return accountCrudOperations.saveAll(accounts);
    }

    public Account deleteAccount(Integer id) {
        return accountCrudOperations.delete(id);
    }

    public Account updateAccount(Integer id) {
        return accountCrudOperations.update(id);
    }
}
