package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.Borrow;
import school.hei.bankapi.service.BorrowService;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public List<Borrow> getAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @GetMapping("/{id}")
    public Borrow getBorrowById(@PathVariable Integer id) {
        return borrowService.getBorrowById(id);
    }

    @PostMapping("/create")
    public Borrow createBorrow(@RequestBody Borrow borrow) {
        return borrowService.createBorrow(borrow);
    }

    @PostMapping("/creates")
    public List<Borrow> createBorrows(@RequestBody List<Borrow> borrows) {
        return borrowService.createAllBorrows(borrows);
    }

    @PutMapping("/{id}")
    public Borrow updateBorrow(@PathVariable Integer id, @RequestBody Borrow borrow) {
        return borrowService.updateBorrow(id, borrow);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrow(@PathVariable Integer id) {
        borrowService.deleteBorrow(id);
    }
}
