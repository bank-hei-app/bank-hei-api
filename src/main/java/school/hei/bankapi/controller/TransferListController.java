
package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.BankTransferList;
import school.hei.bankapi.service.TransferListService;

import java.util.List;

@RestController
@RequestMapping("/bank-transfer-lists")
public class TransferListController {

    private final TransferListService transferListService;

    @Autowired
    public TransferListController(TransferListService transferListService) {
        this.transferListService = transferListService;
    }

    @GetMapping
    public List<BankTransferList> getAllBankTransferLists() {
        return transferListService.getAllBankTransferLists();
    }

    @GetMapping("/{id}")
    public BankTransferList getBankTransferListById(@PathVariable Integer id) {
        return transferListService.getBankTransferListById(id);
    }

    @PostMapping("/create")
    public BankTransferList createBankTransferList(@RequestBody BankTransferList bankTransferList) {
        return transferListService.createBankTransferList(bankTransferList);
    }

    @PostMapping("/creates")
    public List<BankTransferList> createBankTransferLists(@RequestBody List<BankTransferList> bankTransferLists) {
        return transferListService.createAllBankTransferLists(bankTransferLists);
    }

    @PutMapping("/{id}")
    public BankTransferList updateBankTransferList(@PathVariable Integer id, @RequestBody BankTransferList bankTransferList) {
        return transferListService.updateBankTransferList(id, bankTransferList);
    }

    @DeleteMapping("/{id}")
    public void deleteBankTransferList(@PathVariable Integer id) {
        transferListService.deleteBankTransferList(id);
    }
}
