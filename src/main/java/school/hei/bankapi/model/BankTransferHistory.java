package school.hei.bankapi.model;

public class BankTransferHistory {
    private int bankTransferHistoryId;
    private int bankTransferId;


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
