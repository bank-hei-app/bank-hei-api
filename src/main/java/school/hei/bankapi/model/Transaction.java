package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.util.Date;

@Table(table_name = Transaction.tableName, id = Transaction.iD)
public class Transaction extends DefaultModel {
    @Column(name = Transaction.iD)
    private int transactionId;
    @Column(name = Transaction.accountId2)
    private int accountId;
    @Column(name = Transaction.dateOfTransaction2)
    private Date dateOfTransaction;
    @Column(name = Transaction.amount2)
    private double amount;
    @Column(name = Transaction.balanceTypeId2)
    private int balanceTypeId;
    @Column(name = Transaction.balanceCategoryId2)
    private int balanceCategoryId;

    public static final String tableName = "transactions";
    public static final String iD = "transaction_id";
    public static final String accountId2 = "account_id";
    public static final String dateOfTransaction2 = "date_of_transaction";
    public static final String amount2 = "amount";
    public static final String balanceTypeId2 = "balance_type_id";
    public static final String balanceCategoryId2 = "balance_category_id";

    public Transaction(int transactionId, int accountId, Date dateOfTransaction, double amount,
                       int balanceTypeId, int balanceCategoryId) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.balanceTypeId = balanceTypeId;
        this.balanceCategoryId = balanceCategoryId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
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
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", dateOfTransaction=" + dateOfTransaction +
                ", amount=" + amount +
                ", balanceTypeId=" + balanceTypeId +
                ", balanceCategoryId=" + balanceCategoryId +
                '}';
    }
}