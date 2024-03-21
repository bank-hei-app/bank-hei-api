package school.hei.bankapi.service;

import org.springframework.stereotype.Service;
import school.hei.bankapi.model.Transaction;
import school.hei.bankapi.repository.CrudOperations;
import school.hei.bankapi.repository.TransactionsCrudOperations;

import java.util.List;

@Service
public class TransactionService {
    private final CrudOperations<Transaction, Integer> transactionsCrudOperations;

    public TransactionService() {
        this.transactionsCrudOperations = new TransactionsCrudOperations();
    }


    public List<Transaction> findAllTransactions(){
        return transactionsCrudOperations.findAll();
    }
    public Transaction saveTransaction(Transaction transaction){
        return transactionsCrudOperations.save(transaction);
    }
    public Transaction findTransactioById(Integer id){return transactionsCrudOperations.findById(id);}
    public Transaction updateTransaction(Integer id , Transaction toUpdate){return transactionsCrudOperations.update(id , toUpdate);}
    public Transaction deleteTransaction(Integer id){return transactionsCrudOperations.delete(id);}
}
