package school.hei.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.bankapi.model.BorrowList;
import school.hei.bankapi.repository.BorrowListCrudOperations;

import java.util.List;

@Service
public class BorrowListService {

    private final BorrowListCrudOperations borrowListCrudOperations;

    @Autowired
    public BorrowListService(BorrowListCrudOperations borrowListCrudOperations) {
        this.borrowListCrudOperations = borrowListCrudOperations;
    }

    public List<BorrowList> getAllBorrowLists() {
        return borrowListCrudOperations.findAll();
    }

    public BorrowList getBorrowListById(Integer id) {
        return borrowListCrudOperations.findById(id);
    }

    public BorrowList createBorrowList(BorrowList borrowList) {
        return borrowListCrudOperations.save(borrowList);
    }

    public List<BorrowList> createAllBorrowLists(List<BorrowList> borrowLists) {
        return borrowListCrudOperations.saveAll(borrowLists);
    }

    public BorrowList updateBorrowList(Integer id, BorrowList borrowList) {
        return borrowListCrudOperations.update(id, borrowList);
    }

    public void deleteBorrowList(Integer id) {
        borrowListCrudOperations.delete(id);
    }
}
