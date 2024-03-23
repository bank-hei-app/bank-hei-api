package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

import java.sql.Date;
@Table(table_name = BankTransfer.tableName, id = BankTransfer.iD)
public class BankTransfer extends DefaultModel {
    @Column(name = BankTransfer.iD)
    private int bankTransferId;
    @Column(name = BankTransfer.amount2)
    private double amount;
    @Column(name = BankTransfer.balanceCategoryId2)
    private int balanceCategoryId;
    @Column(name = BankTransfer.balanceTypeId2)
    private int balanceTypeId;
    @Column(name = BankTransfer.dateMakeEffect2)
    private Date dateMakeEffect;
    @Column(name = BankTransfer.dateRegister2)
    private Date dateRegister;
    @Column(name = BankTransfer.referenceUnique2)
    private String referenceUnique;


    public static final String tableName = "bank_transfer";
    public static final String iD = "bank_transfer_id";
    public static final  String amount2 = "amount";
    public static final  String balanceCategoryId2 = "balance_category_id";
    public static final  String balanceTypeId2 = "balance_type_id";
    public static final  String dateMakeEffect2 = "date_make_effect";
    public static final  String   dateRegister2 = "date_register";
    public static final  String referenceUnique2 = "reference_unique";



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

    public java.sql.Date getDateMakeEffect() {
        return (java.sql.Date) dateMakeEffect;
    }

    public void setDateMakeEffect(Date dateMakeEffect) {
        this.dateMakeEffect = dateMakeEffect;
    }

    public java.sql.Date getDateRegister() {
        return (java.sql.Date) dateRegister;
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
