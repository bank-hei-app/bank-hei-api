package school.hei.bankapi.model;

public class BorrowList {
    private int borrowListId;
    private int accountId;
    private int borrowId;

    public BorrowList() {
    }

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
