package school.hei.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.bankapi.model.BorrowList;
import school.hei.bankapi.service.BorrowListService;

import java.util.List;

@RestController
@RequestMapping("/borrow-lists")
public class BorrowListController {

    private final BorrowListService borrowListService;

    @Autowired
    public BorrowListController(BorrowListService borrowListService) {
        this.borrowListService = borrowListService;
    }

    @GetMapping
    public List<BorrowList> getAllBorrowLists() {
        return borrowListService.getAllBorrowLists();
    }

    @GetMapping("/{id}")
    public BorrowList getBorrowListById(@PathVariable Integer id) {
        return borrowListService.getBorrowListById(id);
    }

    @PostMapping("/create")
    public BorrowList createBorrowList(@RequestBody BorrowList borrowList) {
        return borrowListService.createBorrowList(borrowList);
    }

    @PostMapping("/creates")
    public List<BorrowList> createBorrowLists(@RequestBody List<BorrowList> borrowLists) {
        return borrowListService.createAllBorrowLists(borrowLists);
    }

    @PutMapping("/{id}")
    public BorrowList updateBorrowList(@PathVariable Integer id, @RequestBody BorrowList borrowList) {
        return borrowListService.updateBorrowList(id, borrowList);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowList(@PathVariable Integer id) {
        borrowListService.deleteBorrowList(id);
    }
}
