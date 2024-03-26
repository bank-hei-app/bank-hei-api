package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.hei.bankapi.model.BalanceCategory;
import school.hei.bankapi.repository.BalanceCategoryCrudOperations;
import school.hei.bankapi.repository.CrudOperations;

import java.util.List;

@Service
public class BalanceCategoryService {

    private final CrudOperations<BalanceCategory, Integer> balanceCategoryCrudOperations;

    @Autowired
    public BalanceCategoryService(BalanceCategoryCrudOperations balanceCategoryCrudOperations) {
        this.balanceCategoryCrudOperations = balanceCategoryCrudOperations;
    }

    public List<BalanceCategory> getAllBalanceCategories() {
        return balanceCategoryCrudOperations.findAll();
    }

    public BalanceCategory getBalanceCategoryById(Integer id) {
        return balanceCategoryCrudOperations.findById(id);
    }

    public BalanceCategory createBalanceCategory(BalanceCategory balanceCategory) {
        return balanceCategoryCrudOperations.save(balanceCategory);
    }

    public List<BalanceCategory> createAllBalanceCategory(List<BalanceCategory> balanceCategories) {
        return balanceCategoryCrudOperations.saveAll(balanceCategories);
    }
    public BalanceCategory updateBalanceCategory(Integer id, BalanceCategory balanceCategory) {
        return balanceCategoryCrudOperations.update(id, balanceCategory);
    }

    public void deleteBalanceCategory(Integer id) {
        balanceCategoryCrudOperations.delete(id);
    }
}

