package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.BorrowList;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowListCrudOperations extends CrudOperationsImpl<BorrowList> {

    @Override
    public BorrowList createT(ResultSet resultSet) throws SQLException {
        return new BorrowList(
                resultSet.getInt(BorrowList.iD),
                resultSet.getInt(BorrowList.accountId2),
                resultSet.getInt(BorrowList.borrowId2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BorrowList model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getAccountId());
        preparedStatement.setInt(2, model.getBorrowId());
        return preparedStatement;
    }

    @Override
    public Class<BorrowList> getClassT() {
        return BorrowList.class;
    }

    @Override
    public BorrowList findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public BorrowList delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public BorrowList update(Integer id, BorrowList toUpdate) {
        String sql = "UPDATE borrow_list SET account_id=?, borrow_id=? WHERE borrow_list_id=?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toUpdate.getAccountId());
            preparedStatement.setInt(2, toUpdate.getBorrowId());
            preparedStatement.setInt(3, id);

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
