package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.sql.Date;
import java.util.UUID;


@Table(table_name = Account.tableName, id = Account.iD)
public class Account extends DefaultModel {
    @Column(name = Account.iD)
    private int accountId;
    @Column(name = Account.clientName2)
    private String clientName;
    @Column(name = Account.clientLastName2)
    private String clientLastName;
    @Column(name = Account.dateOfBirth2)
    private Date dateOfBirth;
    @Column(name = Account.netSalaryPerMonth2)
    private double netSalaryPerMonth;
    @Column(name = Account.accountNumber2)
    private UUID accountNumber;
    @Column(name = Account.bankName2)
    private BankName bankName;
    @Column(name = Account.defaultSolde2)
    private double defaultSolde;

    public static final String tableName = "account";
    public static final String iD = "account_id";
    public static final String clientName2 = "client_name";
    public static final String clientLastName2 = "client_last_name";
    public static final String dateOfBirth2 = "date_of_birth";
    public static final String netSalaryPerMonth2 = "net_salary_per_month";
    public static final String accountNumber2 = "account_number";
    public static final String bankName2 = "bank_name";
    public static final String defaultSolde2 = "default_solde";

    public Account(int accountId, String clientName, String clientLastName, Date dateOfBirth, double netSalaryPerMonth,
                   UUID accountNumber, BankName bankName, double defaultSolde) {
        this.accountId = accountId;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.dateOfBirth = dateOfBirth;
        this.netSalaryPerMonth = netSalaryPerMonth;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.defaultSolde = defaultSolde;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = BankName.valueOf(String.valueOf(BankName.valueOf(bankName)));
    }

    public Date getDateOfBirth() {
        return (java.sql.Date) dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getNetSalaryPerMonth() {
        return netSalaryPerMonth;
    }

    public void setNetSalaryPerMonth(double netSalaryPerMonth) {
        this.netSalaryPerMonth = netSalaryPerMonth;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double getDefaultSolde() {
        return defaultSolde;
    }

    public void setDefaultSolde(double defaultSolde) {
        this.defaultSolde = defaultSolde;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", clientName='" + clientName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", netSalaryPerMonth=" + netSalaryPerMonth +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName=" + bankName +
                ", defaultSolde=" + defaultSolde +
                '}';
    }
}
