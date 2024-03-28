package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.BankTransferHistory;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BankTransferHistoryCrudOperations extends CrudOperationsImpl<BankTransferHistory> {

    @Override
    public BankTransferHistory createT(ResultSet resultSet) throws SQLException {
        return new BankTransferHistory(
                resultSet.getInt(BankTransferHistory.iD),
                resultSet.getInt(BankTransferHistory.bankTransferId2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BankTransferHistory model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getBankTransferHistoryId());
        preparedStatement.setInt(2, model.getBankTransferId());
        return preparedStatement;
    }

    @Override
    public Class<BankTransferHistory> getClassT() {
        return BankTransferHistory.class;
    }

    @Override
    public BankTransferHistory findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public BankTransferHistory delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public BankTransferHistory update(Integer id, BankTransferHistory toUpdate) {
        String sql = "UPDATE bank_transfer_history SET bank_transfer_id=? WHERE bank_transfer_history_id=?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toUpdate.getBankTransferId());
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return toUpdate;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
