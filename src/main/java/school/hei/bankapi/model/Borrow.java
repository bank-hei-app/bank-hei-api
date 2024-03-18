package school.hei.bankapi.model;

import java.util.Date;

public class Borrow {
    private int borrowId;
    private double amount;
    private double percent;
    private Date dateOfBorrow;



    public Borrow(int borrowId, double amount, double percent, Date dateOfBorrow) {
        this.borrowId = borrowId;
        this.amount = amount;
        this.percent = percent;
        this.dateOfBorrow = dateOfBorrow;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", amount=" + amount +
                ", percent=" + percent +
                ", dateOfBorrow=" + dateOfBorrow +
                '}';
    }
}
