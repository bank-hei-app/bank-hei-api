package school.hei.bankapi.model;

import school.hei.bankapi.utils.annotations.Column;
import school.hei.bankapi.utils.annotations.Table;

@Table(table_name = BankTransferList.tableName , id=BankTransferList.iD)
public class BankTransferList {
    @Column(name = BankTransferList.iD)
    private int bankTransferListId;
    @Column(name = BankTransferList.bankTransferId2)
    private int bankTransferId;
    @Column(name = BankTransferList.accountSenderId2)
    private int accountSenderId;
    @Column(name = BankTransferList.accountRecipientId2)
    private int accountRecipientId;

    public static final String tableName = "bank_transfer_list";
    public static final String iD = "bank_transfer_list_id";
    public static final String bankTransferId2 = "bank_transfer_id";
    public static final String accountSenderId2 = "account_sender_id";
    public static final String  accountRecipientId2 = "account_recipients_id";

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
