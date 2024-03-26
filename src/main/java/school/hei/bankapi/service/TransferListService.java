package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.BankTransferList;
import school.hei.bankapi.repository.TransferListCrudOperations;

import java.util.List;

@Service
public class TransferListService {

    private final TransferListCrudOperations transferListCrudOperations;

    @Autowired
    public TransferListService(TransferListCrudOperations transferListCrudOperations) {
        this.transferListCrudOperations = transferListCrudOperations;
    }

    public List<BankTransferList> getAllBankTransferLists() {
        return transferListCrudOperations.findAll();
    }

    public BankTransferList getBankTransferListById(Integer id) {
        return transferListCrudOperations.findById(id);
    }

    public BankTransferList createBankTransferList(BankTransferList bankTransferList) {
        return transferListCrudOperations.save(bankTransferList);
    }

    public List<BankTransferList> createAllBankTransferLists(List<BankTransferList> bankTransferLists) {
        return transferListCrudOperations.saveAll(bankTransferLists);
    }

    public BankTransferList updateBankTransferList(Integer id, BankTransferList bankTransferList) {
        return transferListCrudOperations.update(id, bankTransferList);
    }

    public void deleteBankTransferList(Integer id) {
        transferListCrudOperations.delete(id);
    }
}

