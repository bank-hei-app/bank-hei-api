package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.BalanceType;
import school.hei.bankapi.repository.BalanceTypeCrudOperations;
import school.hei.bankapi.repository.CrudOperations;

import java.util.List;

@Service
public class BalanceTypeService {

    private final CrudOperations<BalanceType, Integer> balanceTypeCrudOperations;

    @Autowired
    public BalanceTypeService(BalanceTypeCrudOperations balanceTypeCrudOperations) {
        this.balanceTypeCrudOperations = balanceTypeCrudOperations;
    }

    public List<BalanceType> getAllBalanceTypes() {
        return balanceTypeCrudOperations.findAll();
    }

    public BalanceType getBalanceTypeById(Integer id) {
        return balanceTypeCrudOperations.findById(id);
    }

    public BalanceType createBalanceType(BalanceType balanceType) {
        return balanceTypeCrudOperations.save(balanceType);
    }

    public List<BalanceType> createAllBalanceTypes(List<BalanceType> balanceTypes) {
        return balanceTypeCrudOperations.saveAll(balanceTypes);
    }

    public BalanceType updateBalanceType(Integer id, BalanceType balanceType) {
        return balanceTypeCrudOperations.update(id, balanceType);
    }

    public void deleteBalanceType(Integer id) {
        balanceTypeCrudOperations.delete(id);
    }
}
