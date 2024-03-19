package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.util.Date;

@Table(table_name = Withdrawal.tableName , id=Withdrawal.iD)
public class Withdrawal {
    @Column(name = Withdrawal.iD)
    private int withdrawalId;
    @Column(name = Withdrawal.accountId2)
    private int accountId;
    @Column(name = Withdrawal.dateOfWithdrawal2)
    private Date dateOfWithdrawal;
    @Column(name = Withdrawal.amount2)
    private double amount;
    @Column(name = Withdrawal.balanceTypeId2)
    private int balanceTypeId;
    @Column(name = Withdrawal.balanceCategoryId2)
    private int balanceCategoryId;

    public static final String tableName = "withdrawal";
    public static final String iD = "withdrawal_id";
    public static final String accountId2 = "account_id";
    public static final String dateOfWithdrawal2 = "date_of_withdrawal";
    public static final String  amount2 = "amount";
    public static final String balanceTypeId2 = "balance_type_id";
    public static final String balanceCategoryId2 = "balance_category_id";



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
