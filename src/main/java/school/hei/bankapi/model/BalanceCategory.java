package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = BalanceCategory.tableName, id = BalanceCategory.iD)
public class BalanceCategory extends DefaultModel{
    @Column(name = BalanceCategory.iD)
    private int balanceCategoryId;
    @Column(name = BalanceCategory.balanceCategoryName2)
    private String balanceCategoryName;
    @Column(name = BalanceCategory.description2)
    private String description;


    public static final String tableName = "balance_category";
    public static final String iD = "balance_category_id";
    public static final String balanceCategoryName2 = "balance_category_name";
    public static final String  description2 = "description";
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
