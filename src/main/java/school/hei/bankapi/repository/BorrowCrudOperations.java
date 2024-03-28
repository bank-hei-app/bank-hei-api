package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Borrow;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowCrudOperations extends CrudOperationsImpl<Borrow> {

    @Override
    public Borrow createT(ResultSet resultSet) throws SQLException {
        return new Borrow(
                resultSet.getInt(Borrow.iD),
                resultSet.getDouble(Borrow.amount2),
                resultSet.getBigDecimal(Borrow.percent2),
                resultSet.getDate(Borrow.dateOfBorrow2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, Borrow model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setDouble(1, model.getAmount());
        preparedStatement.setBigDecimal(2, model.getPercent());
        preparedStatement.setDate(3, model.getDateOfBorrow());
        return preparedStatement;
    }

    @Override
    public Class<Borrow> getClassT() {
        return Borrow.class;
    }

    @Override
    public Borrow findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Borrow delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public Borrow update(Integer id, Borrow toUpdate) {
        String sql = "UPDATE borrow SET amount=?, percent=?, date_of_borrow=? WHERE borrow_id=?";
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, toUpdate.getAmount());
            preparedStatement.setBigDecimal(2, toUpdate.getPercent());
            preparedStatement.setDate(3, toUpdate.getDateOfBorrow());
            preparedStatement.setInt(4, id);

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
