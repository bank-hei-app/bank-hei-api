package school.hei.bankapi.model;

import org.springframework.boot.BootstrapRegistry;
import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.util.Date;
@Table(table_name = Borrow.tableName , id = Borrow.iD)
public class Borrow extends DefaultModel{
    @Column(name = Borrow.iD)
    private int borrowId;
    @Column(name = Borrow.amount2)
    private double amount;
    @Column(name = Borrow.percent2)
    private double percent;
    @Column(name = Borrow.dateOfBorrow2)
    private Date dateOfBorrow;

    public static final String tableName = "borrow";

    public static final String iD = "borrow_id";
    public static final String amount2 = "amount";
    public static final String percent2 = "percent";
    public static final String dateOfBorrow2 = "date_of_borrow";


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
