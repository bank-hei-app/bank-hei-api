package school.hei.bankapi.model;

import java.util.Date;

public class Withdrawal {
    private int withdrawalId;
    private int accountId;
    private Date dateOfWithdrawal;
    private double amount;
    private int balanceTypeId;
    private int balanceCategoryId;



    public Withdrawal(int withdrawalId, int accountId, Date dateOfWithdrawal, double amount, int balanceTypeId, int balanceCategoryId) {
        this.withdrawalId = withdrawalId;
        this.accountId = accountId;
        this.dateOfWithdrawal = dateOfWithdrawal;
        this.amount = amount;
        this.balanceTypeId = balanceTypeId;
        this.balanceCategoryId = balanceCategoryId;
    }

    public int getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(int withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getDateOfWithdrawal() {
        return dateOfWithdrawal;
    }

    public void setDateOfWithdrawal(Date dateOfWithdrawal) {
        this.dateOfWithdrawal = dateOfWithdrawal;
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
        return "Withdrawal{" +
                "withdrawalId=" + withdrawalId +
                ", accountId=" + accountId +
                ", dateOfWithdrawal=" + dateOfWithdrawal +
                ", amount=" + amount +
                ", balanceTypeId=" + balanceTypeId +
                ", balanceCategoryId=" + balanceCategoryId +
                '}';
    }
}
