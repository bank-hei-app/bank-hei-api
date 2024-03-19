package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.util.Date;
@Table(table_name = Deposit.tableName, id=Deposit.iD)
public class Deposit {
    @Column(name = Deposit.iD)
    private int depositId;

    @Column(name = Deposit.accountId2)
    private int accountId;
    @Column(name = Deposit.dateOfDeposit2)
    private Date dateOfDeposit;
    @Column(name = Deposit.amount2)
    private double amount;
    @Column(name = Deposit.balanceTypeId2)
    private int balanceTypeId;
    @Column(name = Deposit.balanceCategoryId2)
    private int balanceCategoryId;

    public static final String tableName = "deposit";
    public static final String iD = "deposit_id";
    public static final String accountId2 = "account_id";
    public static final String dateOfDeposit2 = "date_of_deposit";
    public static final String amount2 = "amount";
    public static final String balanceTypeId2 = "balance_type_id";
    public static final String  balanceCategoryId2 = "balance_category_id";

    public Deposit(int depositId, int accountId, Date dateOfDeposit, double amount, int balanceTypeId, int balanceCategoryId) {
        this.depositId = depositId;
        this.accountId = accountId;
        this.dateOfDeposit = dateOfDeposit;
        this.amount = amount;
        this.balanceTypeId = balanceTypeId;
        this.balanceCategoryId = balanceCategoryId;
    }

    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getDateOfDeposit() {
        return dateOfDeposit;
    }

    public void setDateOfDeposit(Date dateOfDeposit) {
        this.dateOfDeposit = dateOfDeposit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBalanceTypeId() {
        return balanceTypeId;
    }

    public void setBalanceTypeId(int balanceTypeId) {
        this.balanceTypeId = balanceTypeId;
    }

    public int getBalanceCategoryId() {
        return balanceCategoryId;
    }

    public void setBalanceCategoryId(int balanceCategoryId) {
        this.balanceCategoryId = balanceCategoryId;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", accountId=" + accountId +
                ", dateOfDeposit=" + dateOfDeposit +
                ", amount=" + amount +
                ", balanceTypeId=" + balanceTypeId +
                ", balanceCategoryId=" + balanceCategoryId +
                '}';
    }
}
