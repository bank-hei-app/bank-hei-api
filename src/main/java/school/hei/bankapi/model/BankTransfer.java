package school.hei.bankapi.model;

import java.util.Date;

public class BankTransfer {
    private int bankTransferId;
    private double amount;
    private int balanceCategoryId;
    private int balanceTypeId;
    private Date dateMakeEffect;
    private Date dateRegister;
    private String referenceUnique;

    public BankTransfer() {
    }

    public BankTransfer(int bankTransferId, double amount, int balanceCategoryId, int balanceTypeId, Date dateMakeEffect, Date dateRegister, String referenceUnique) {
        this.bankTransferId = bankTransferId;
        this.amount = amount;
        this.balanceCategoryId = balanceCategoryId;
        this.balanceTypeId = balanceTypeId;
        this.dateMakeEffect = dateMakeEffect;
        this.dateRegister = dateRegister;
        this.referenceUnique = referenceUnique;
    }

    public int getBankTransferId() {
        return bankTransferId;
    }

    public void setBankTransferId(int bankTransferId) {
        this.bankTransferId = bankTransferId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBalanceCategoryId() {
        return balanceCategoryId;
    }

    public void setBalanceCategoryId(int balanceCategoryId) {
        this.balanceCategoryId = balanceCategoryId;
    }

    public int getBalanceTypeId() {
        return balanceTypeId;
    }

    public void setBalanceTypeId(int balanceTypeId) {
        this.balanceTypeId = balanceTypeId;
    }

    public Date getDateMakeEffect() {
        return dateMakeEffect;
    }

    public void setDateMakeEffect(Date dateMakeEffect) {
        this.dateMakeEffect = dateMakeEffect;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getReferenceUnique() {
        return referenceUnique;
    }

    public void setReferenceUnique(String referenceUnique) {
        this.referenceUnique = referenceUnique;
    }

    @Override
    public String toString() {
        return "BankTransfer{" +
                "bankTransferId=" + bankTransferId +
                ", amount=" + amount +
                ", balanceCategoryId=" + balanceCategoryId +
                ", balanceTypeId=" + balanceTypeId +
                ", dateMakeEffect=" + dateMakeEffect +
                ", dateRegister=" + dateRegister +
                ", referenceUnique='" + referenceUnique + '\'' +
                '}';
    }
}
