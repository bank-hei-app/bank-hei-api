package school.hei.bankapi.model;

import java.util.Date;

public class Account {
    private int accountId;
    private String clientName;
    private String clientLastName;
    private Date dateOfBirth;
    private double netSalaryPerMonth;
    private String accountNumber;
    private int bankId;
    private double defaultSolde;

    public Account(int accountId, String clientName, String clientLastName, Date dateOfBirth, double netSalaryPerMonth,
                   String accountNumber, double defaultSolde, int bankId) {
        this.accountId = accountId;
        this.clientName = clientName;
        this.clientLastName = clientLastName;
        this.dateOfBirth = dateOfBirth;
        this.netSalaryPerMonth = netSalaryPerMonth;
        this.accountNumber = accountNumber;
        this.defaultSolde = defaultSolde;
        this.bankId = bankId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
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
                ", bankId=" + bankId +
                ", defaultSolde=" + defaultSolde +
                '}';
    }
}
