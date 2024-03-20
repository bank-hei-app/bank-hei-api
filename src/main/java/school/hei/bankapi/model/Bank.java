package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = Bank.tableName , id = Bank.iD)
public class Bank extends  DefaultModel{
    @Column(name = Bank.iD)
    private int bankId;
    @Column(name = Bank.bankName2)
    private String bankName;

    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public static final String tableName = "bank";
    public static final String iD = "bank_id";
    public static final String bankName2 = "bank_name";

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}

