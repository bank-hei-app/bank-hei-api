package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankTransfer;
import school.hei.bankapi.service.BankTransferService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/bank-transfers")
public class BankTransferController {

    private final BankTransferService bankTransferService;

    @Autowired
    public BankTransferController(BankTransferService bankTransferService) {
        this.bankTransferService = bankTransferService;
    }

    @GetMapping
    public List<BankTransfer> getAllBankTransfers() {
        return bankTransferService.findAllBankTransfers();
    }

    @GetMapping("/{id}")
    public BankTransfer getBankTransferById(@PathVariable Integer id) {
        return bankTransferService.findBankTransferById(id);
    }

    @PostMapping("/create")
    public BankTransfer saveBankTransfer(@RequestBody BankTransfer bankTransfer) {
        return bankTransferService.saveBantrasfer(bankTransfer);
    }

    @PostMapping("/creates")
    public List<BankTransfer> saveAllBankTransfers(@RequestBody List<BankTransfer> bankTransfers) {
        return bankTransferService.saveAllBankTransfers(bankTransfers);
    }

    @PostMapping("/transfer-money")
    public void transferMoney(@RequestBody Account sender, @RequestBody Account receiver, @RequestParam double amount) {
        bankTransferService.transferMoney(sender, receiver, amount);
    }



    @DeleteMapping("/{id}")
    public BankTransfer deleteBankTransfer(@PathVariable Integer id) {
        return bankTransferService.deleteBankTransfer(id);
    }

    @PutMapping("/{id}")
    public BankTransfer updateBankTransfer(@PathVariable Integer id, @RequestBody BankTransfer toUpdate) {
        return bankTransferService.updateAccount(id, toUpdate);
    }
}
