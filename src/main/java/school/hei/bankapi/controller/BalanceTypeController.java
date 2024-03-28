
package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import school.hei.bankapi.model.BalanceType;
import school.hei.bankapi.service.BalanceTypeService;

import java.util.List;

@RestController
@RequestMapping("/balance-types")
public class BalanceTypeController {

    private final BalanceTypeService balanceTypeService;

    @Autowired
    public BalanceTypeController(BalanceTypeService balanceTypeService) {
        this.balanceTypeService = balanceTypeService;
    }

    @GetMapping
    public List<BalanceType> getAllBalanceTypes() {
        return balanceTypeService.getAllBalanceTypes();
    }

    @GetMapping("/{id}")
    public BalanceType getBalanceTypeById(@PathVariable Integer id) {
        return balanceTypeService.getBalanceTypeById(id);
    }

    @PostMapping("/create")
    public BalanceType createBalanceType(@RequestBody BalanceType balanceType) {
        return balanceTypeService.createBalanceType(balanceType);
    }

    @PostMapping("/creates")
    public List<BalanceType> createBalanceTypes(@RequestBody List<BalanceType> balanceTypes) {
        return balanceTypeService.createAllBalanceTypes(balanceTypes);
    }

    @PutMapping("/{id}")
    public BalanceType updateBalanceType(@PathVariable Integer id, @RequestBody BalanceType balanceType) {
        return balanceTypeService.updateBalanceType(id, balanceType);
    }

    @DeleteMapping("/{id}")
    public void deleteBalanceType(@PathVariable Integer id) {
        balanceTypeService.deleteBalanceType(id);
    }
}
