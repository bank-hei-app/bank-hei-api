package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.service.AccountService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountService.findAccountById(id);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PostMapping("/creates")
    public List<Account> createAccounts(@RequestBody List<Account> accounts) {
        return accountService.saveAllAccounts(accounts);
    }

    @DeleteMapping("/{id}")
    public Account deleteAccount(@PathVariable Integer id) {
        return accountService.deleteAccount(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Integer id) {
        return accountService.updateAccount(id);
    }
}
