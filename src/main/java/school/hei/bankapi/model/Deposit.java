package school.hei.bankapi.model;

import java.util.Date;

public class Deposit {
    private int depositId;
    private int accountId;
    private Date dateOfDeposit;
    private double amount;
    private int balanceTypeId;
    private int balanceCategoryId;

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
