package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.BalanceType;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BalanceTypeCrudOperations extends CrudOperationsImpl<BalanceType> {

    @Override
    public BalanceType createT(ResultSet resultSet) throws SQLException {
        return new BalanceType(
                resultSet.getInt(BalanceType.iD),
                resultSet.getString(BalanceType.balanceTypeName2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BalanceType model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getBalanceTypeId());
        preparedStatement.setString(2, model.getBalanceTypeName());
        return preparedStatement;
    }

    @Override
    public Class<BalanceType> getClassT() {
        return BalanceType.class;
    }

    @Override
    public BalanceType findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public BalanceType delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public BalanceType update(Integer id, BalanceType toUpdate) {
        String sql = "UPDATE balance_type SET balance_type_name=? WHERE balance_type_id=?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, toUpdate.getBalanceTypeName());
            preparedStatement.setInt(2, id);

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
