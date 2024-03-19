package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = BalanceType.tableName , id = BalanceType.iD)
public class BalanceType {
    @Column(name = BalanceType.iD)
    private int balanceTypeId;
    @Column(name = BalanceType.balanceTypeName2)
    private String balanceTypeName;
    public static final String tableName = "balance_type";
    public static final String iD = "balance_type_id";
    public static final String   balanceTypeName2 = "balance_type_name";

    public BalanceType(int balanceTypeId, String balanceTypeName) {
        this.balanceTypeId = balanceTypeId;
        this.balanceTypeName = balanceTypeName;
    }

    public int getBalanceTypeId() {
        return balanceTypeId;
    }

    public void setBalanceTypeId(int balanceTypeId) {
        this.balanceTypeId = balanceTypeId;
    }

    public String getBalanceTypeName() {
        return balanceTypeName;
    }

    public void setBalanceTypeName(String balanceTypeName) {
        this.balanceTypeName = balanceTypeName;
    }

    @Override
    public String toString() {
        return "BalanceType{" +
                "balanceTypeId=" + balanceTypeId +
                ", balanceTypeName='" + balanceTypeName + '\'' +
                '}';
    }
}
