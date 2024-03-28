package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.Borrow;
import school.hei.bankapi.repository.BorrowCrudOperations;

import java.util.List;

@Service
public class BorrowService {

    private final BorrowCrudOperations borrowCrudOperations;

    @Autowired
    public BorrowService(BorrowCrudOperations borrowCrudOperations) {
        this.borrowCrudOperations = borrowCrudOperations;
    }

    public List<Borrow> getAllBorrows() {
        return borrowCrudOperations.findAll();
    }

    public Borrow getBorrowById(Integer id) {
        return borrowCrudOperations.findById(id);
    }

    public Borrow createBorrow(Borrow borrow) {
        return borrowCrudOperations.save(borrow);
    }

    public List<Borrow> createAllBorrows(List<Borrow> borrows) {
        return borrowCrudOperations.saveAll(borrows);
    }

    public Borrow updateBorrow(Integer id, Borrow borrow) {
        return borrowCrudOperations.update(id, borrow);
    }

    public void deleteBorrow(Integer id) {
        borrowCrudOperations.delete(id);
    }
}
