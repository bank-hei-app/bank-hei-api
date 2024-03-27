package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.BankTransferHistory;
import school.hei.bankapi.service.BankTransferHistoryService;

import java.util.List;

@RestController
@RequestMapping("/bank-transfer-history")
public class BankTransferHistoryController {

    private final BankTransferHistoryService bankTransferHistoryService;

    @Autowired
    public BankTransferHistoryController(BankTransferHistoryService bankTransferHistoryService) {
        this.bankTransferHistoryService = bankTransferHistoryService;
    }

    @GetMapping
    public List<BankTransferHistory> getAllBankTransferHistories() {
        return bankTransferHistoryService.getAllBankTransferHistories();
    }

    @GetMapping("/{id}")
    public BankTransferHistory getBankTransferHistoryById(@PathVariable Integer id) {
        return bankTransferHistoryService.getBankTransferHistoryById(id);
    }

    @PostMapping("/create")
    public BankTransferHistory createBankTransferHistory(@RequestBody BankTransferHistory bankTransferHistory) {
        return bankTransferHistoryService.createBankTransferHistory(bankTransferHistory);
    }

    @PostMapping("/creates")
    public List<BankTransferHistory> createBankTransferHistories(@RequestBody List<BankTransferHistory> bankTransferHistories) {
        return bankTransferHistoryService.createAllBankTransferHistories(bankTransferHistories);
    }

    @PutMapping("/{id}")
    public BankTransferHistory updateBankTransferHistory(@PathVariable Integer id, @RequestBody BankTransferHistory bankTransferHistory) {
        return bankTransferHistoryService.updateBankTransferHistory(id, bankTransferHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteBankTransferHistory(@PathVariable Integer id) {
        bankTransferHistoryService.deleteBankTransferHistory(id);
    }
}
