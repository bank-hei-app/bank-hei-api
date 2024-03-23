package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankTransfer;
import school.hei.bankapi.repository.BankTransferCrudOperations;
import school.hei.bankapi.repository.CrudOperations;

import java.sql.Date;
import java.util.List;

@Service
public class BankTransferService {

    private final CrudOperations<BankTransfer, Integer> bankTransferCrudOperations;

    @Autowired
    public BankTransferService(BankTransferCrudOperations bankTransferCrudOperations) {
        this.bankTransferCrudOperations = bankTransferCrudOperations;
    }

    public List<BankTransfer> findAllBankTransfers() {
        return bankTransferCrudOperations.findAll();
    }

    public BankTransfer findBankTransferById(Integer id) {
        return bankTransferCrudOperations.findById(id);
    }

    public BankTransfer saveBantrasfer(BankTransfer bankTransfer) {
        return bankTransferCrudOperations.save(bankTransfer);
    }

    public List<BankTransfer> saveAllBankTransfers(List<BankTransfer> bankTransfers) {
        return bankTransferCrudOperations.saveAll(bankTransfers);
    }

    public void transferMoney(Account sender, Account receiver, double amount) {
        ((BankTransferCrudOperations) bankTransferCrudOperations).transferMoney(sender, receiver, amount);
    }

    public void executeDebits() {
        ((BankTransferCrudOperations) bankTransferCrudOperations).executeDebits();
    }

    public BankTransfer deleteBankTransfer(Integer id) {
        return bankTransferCrudOperations.delete(id);
    }
    public BankTransfer updateAccount(Integer id , BankTransfer toUpdate) {
        return bankTransferCrudOperations.update(id , toUpdate);
    }
}









