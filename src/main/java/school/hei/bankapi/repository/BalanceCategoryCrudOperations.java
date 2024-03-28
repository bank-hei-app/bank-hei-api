package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.BalanceCategory;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BalanceCategoryCrudOperations extends CrudOperationsImpl<BalanceCategory> {

    @Override
    public BalanceCategory createT(ResultSet resultSet) throws SQLException {
        return new BalanceCategory(
                resultSet.getInt(BalanceCategory.iD),
                resultSet.getString(BalanceCategory.balanceCategoryName2),
                resultSet.getString(BalanceCategory.description2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BalanceCategory model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getBalanceCategoryId());
        preparedStatement.setString(2, model.getBalanceCategoryName());
        preparedStatement.setString(3, model.getDescription());
        return preparedStatement;
    }

    @Override
    public Class<BalanceCategory> getClassT() {
        return BalanceCategory.class;
    }

    @Override
    public BalanceCategory findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public BalanceCategory delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public BalanceCategory update(Integer id, BalanceCategory toUpdate) {
        String sql = "UPDATE balance_category SET balance_category_name=?, description=? WHERE balance_category_id=?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, toUpdate.getBalanceCategoryName());
            preparedStatement.setString(2, toUpdate.getDescription());
            preparedStatement.setInt(3, id);

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
