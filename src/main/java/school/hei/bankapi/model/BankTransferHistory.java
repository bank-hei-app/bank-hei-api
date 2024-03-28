package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = BankTransferHistory.tableName , id = BankTransferHistory.iD)
public class BankTransferHistory extends  DefaultModel {
    @Column(name = BankTransferHistory.iD)
    private int bankTransferHistoryId;
    @Column(name = BankTransferHistory.bankTransferId2)
    private int bankTransferId;
    public static final String tableName = "bank_transfer_history";
    public static final String iD = "bank_transfer_history_id";
    public static final String bankTransferId2 = "bank_transfer_id";

    public BankTransferHistory(int bankTransferHistoryId, int bankTransferId) {
        this.bankTransferHistoryId = bankTransferHistoryId;
        this.bankTransferId = bankTransferId;
    }

    public int getBankTransferHistoryId() {
        return bankTransferHistoryId;
    }

    public void setBankTransferHistoryId(int bankTransferHistoryId) {
        this.bankTransferHistoryId = bankTransferHistoryId;
    }

    public int getBankTransferId() {
        return bankTransferId;
    }

    public void setBankTransferId(int bankTransferId) {
        this.bankTransferId = bankTransferId;
    }

    @Override
    public String toString() {
        return "BankTransferHistory{" +
                "bankTransferHistoryId=" + bankTransferHistoryId +
                ", bankTransferId=" + bankTransferId +
                '}';
    }
}
