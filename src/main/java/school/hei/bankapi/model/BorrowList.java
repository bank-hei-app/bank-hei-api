package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = BorrowList.tableName , id=BorrowList.iD)
public class BorrowList extends DefaultModel{
    @Column(name = BorrowList.iD)
    private int borrowListId;
    @Column(name = BorrowList.accountId2)
    private int accountId;
    @Column(name = BorrowList.borrowId2)
    private int borrowId;

    public static final String tableName = "borrow_list";
    public static final String iD = "borrow_list_id";
    public static final String accountId2 = "account_id";
    public static final String borrowId2 = "borrow_id";



    public BorrowList(int borrowListId, int accountId, int borrowId) {
        this.borrowListId = borrowListId;
        this.accountId = accountId;
        this.borrowId = borrowId;
    }

    public int getBorrowListId() {
        return borrowListId;
    }

    public void setBorrowListId(int borrowListId) {
        this.borrowListId = borrowListId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public String toString() {
        return "BorrowList{" +
                "borrowListId=" + borrowListId +
                ", accountId=" + accountId +
                ", borrowId=" + borrowId +
                '}';
    }
}
