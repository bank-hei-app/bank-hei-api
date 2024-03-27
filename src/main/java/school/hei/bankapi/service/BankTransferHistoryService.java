package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.BankTransferHistory;
import school.hei.bankapi.repository.BankTransferHistoryCrudOperations;

import java.util.List;

@Service
public class BankTransferHistoryService {

    private final BankTransferHistoryCrudOperations bankTransferHistoryCrudOperations;

    @Autowired
    public BankTransferHistoryService(BankTransferHistoryCrudOperations bankTransferHistoryCrudOperations) {
        this.bankTransferHistoryCrudOperations = bankTransferHistoryCrudOperations;
    }

    public List<BankTransferHistory> getAllBankTransferHistories() {
        return bankTransferHistoryCrudOperations.findAll();
    }

    public BankTransferHistory getBankTransferHistoryById(Integer id) {
        return bankTransferHistoryCrudOperations.findById(id);
    }

    public BankTransferHistory createBankTransferHistory(BankTransferHistory bankTransferHistory) {
        return bankTransferHistoryCrudOperations.save(bankTransferHistory);
    }

    public List<BankTransferHistory> createAllBankTransferHistories(List<BankTransferHistory> bankTransferHistories) {
        return bankTransferHistoryCrudOperations.saveAll(bankTransferHistories);
    }

    public BankTransferHistory updateBankTransferHistory(Integer id, BankTransferHistory bankTransferHistory) {
        return bankTransferHistoryCrudOperations.update(id, bankTransferHistory);
    }

    public void deleteBankTransferHistory(Integer id) {
        bankTransferHistoryCrudOperations.delete(id);
    }
}
