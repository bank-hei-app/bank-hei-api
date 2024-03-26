






package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BalanceCategory;
import school.hei.bankapi.service.BalanceCategoryService;

import java.util.List;

@RestController
@RequestMapping("/balance-categories")
public class BalanceCategoryController {

    private final BalanceCategoryService balanceCategoryService;

    @Autowired
    public BalanceCategoryController(BalanceCategoryService balanceCategoryService) {
        this.balanceCategoryService = balanceCategoryService;
    }

    @GetMapping
    public List<BalanceCategory> getAllBalanceCategories() {
        return balanceCategoryService.getAllBalanceCategories();
    }

    @GetMapping("/{id}")
    public BalanceCategory getBalanceCategoryById(@PathVariable Integer id) {
        return balanceCategoryService.getBalanceCategoryById(id);
    }

    @PostMapping("/create")
    public BalanceCategory createBalanceCategory(@RequestBody BalanceCategory balanceCategory) {
        return balanceCategoryService.createBalanceCategory(balanceCategory);
    }

    @PostMapping("/creates")
    public List<BalanceCategory> createBalanceCategorys(@RequestBody List<BalanceCategory> balanceCategories) {
        return balanceCategoryService.createAllBalanceCategory(balanceCategories);
    }
    @PutMapping("/{id}")
    public BalanceCategory updateBalanceCategory(@PathVariable Integer id, @RequestBody BalanceCategory balanceCategory) {
        return balanceCategoryService.updateBalanceCategory(id, balanceCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteBalanceCategory(@PathVariable Integer id) {
        balanceCategoryService.deleteBalanceCategory(id);
    }
}
