package school.hei.bankapi.model;

public class BalanceType {
    private int balanceTypeId;
    private String balanceTypeName;


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
