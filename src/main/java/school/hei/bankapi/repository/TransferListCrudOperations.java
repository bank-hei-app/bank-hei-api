package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.BankTransferList;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository

public class TransferListCrudOperations extends CrudOperationsImpl<BankTransferList> {

    @Override
    public BankTransferList createT(ResultSet resultSet) throws SQLException {
        return new BankTransferList(
                resultSet.getInt(BankTransferList.iD),
                resultSet.getInt(BankTransferList.bankTransferId2),
                resultSet.getInt(BankTransferList.accountSenderId2),
                resultSet.getInt(BankTransferList.accountRecipientId2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BankTransferList model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getBankTransferListId());
        preparedStatement.setInt(2, model.getBankTransferId());
        preparedStatement.setInt(3, model.getAccountSenderId());
        preparedStatement.setInt(4, model.getAccountRecipientId());
        return preparedStatement;
    }

    @Override
    public Class<BankTransferList> getClassT() {
        return BankTransferList.class;
    }

    @Override
    public BankTransferList findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public BankTransferList delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public BankTransferList update(Integer id, BankTransferList toUpdate) {
        String sql = "UPDATE bank_transfer_list SET bank_transfer_id=?, account_sender_id=?, account_recipients_id=? WHERE bank_transfer_list_id=?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toUpdate.getBankTransferId());
            preparedStatement.setInt(2, toUpdate.getAccountSenderId());
            preparedStatement.setInt(3, toUpdate.getAccountRecipientId());
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return toUpdate;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toUpdate;
    }
}
