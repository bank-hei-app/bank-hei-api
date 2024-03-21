package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.Transaction;
import school.hei.bankapi.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public List<Transaction> AllTransaction(){
        return transactionService.findAllTransactions();
    }
    @PostMapping("/addTransaction")
    public Transaction savetransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable int id){
        return transactionService.findTransactioById(id);
    }
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable int id ,@RequestBody Transaction toUpdate){
        return transactionService.updateTransaction(id,toUpdate);
    }
    @DeleteMapping("/{id}")
    public Transaction deleteTransaction(@PathVariable int id ){
        return transactionService.deleteTransaction(id);
    }

}
