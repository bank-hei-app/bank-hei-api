package school.hei.bankapi.model;

public class BankTransferList {
    private int bankTransferListId;
    private int bankTransferId;
    private int accountSenderId;
    private int accountRecipientId;



    public BankTransferList(int bankTransferListId, int bankTransferId, int accountSenderId, int accountRecipientId) {
        this.bankTransferListId = bankTransferListId;
        this.bankTransferId = bankTransferId;
        this.accountSenderId = accountSenderId;
        this.accountRecipientId = accountRecipientId;
    }

    public int getBankTransferListId() {
        return bankTransferListId;
    }

    public void setBankTransferListId(int bankTransferListId) {
        this.bankTransferListId = bankTransferListId;
    }

    public int getBankTransferId() {
        return bankTransferId;
    }

    public void setBankTransferId(int bankTransferId) {
        this.bankTransferId = bankTransferId;
    }

    public int getAccountSenderId() {
        return accountSenderId;
    }

    public void setAccountSenderId(int accountSenderId) {
        this.accountSenderId = accountSenderId;
    }

    public int getAccountRecipientId() {
        return accountRecipientId;
    }

    public void setAccountRecipientId(int accountRecipientId) {
        this.accountRecipientId = accountRecipientId;
    }

    @Override
    public String toString() {
        return "BankTransferList{" +
                "bankTransferListId=" + bankTransferListId +
                ", bankTransferId=" + bankTransferId +
                ", accountSenderId=" + accountSenderId +
                ", accountRecipientId=" + accountRecipientId +
                '}';
    }
}
