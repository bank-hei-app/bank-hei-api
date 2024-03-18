package school.hei.bankapi.model;

public class BalanceCategory {
    private int balanceCategoryId;
    private String balanceCategoryName;
    private String description;


    public BalanceCategory(int balanceCategoryId, String balanceCategoryName, String description) {
        this.balanceCategoryId = balanceCategoryId;
        this.balanceCategoryName = balanceCategoryName;
        this.description = description;
    }

    public int getBalanceCategoryId() {
        return balanceCategoryId;
    }

    public void setBalanceCategoryId(int balanceCategoryId) {
        this.balanceCategoryId = balanceCategoryId;
    }

    public String getBalanceCategoryName() {
        return balanceCategoryName;
    }

    public void setBalanceCategoryName(String balanceCategoryName) {
        this.balanceCategoryName = balanceCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BalanceCategory{" +
                "balanceCategoryId=" + balanceCategoryId +
                ", balanceCategoryName='" + balanceCategoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
