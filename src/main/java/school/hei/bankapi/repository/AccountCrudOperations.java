package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankName;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Repository
public class AccountCrudOperations extends CrudOperationsImpl<Account > {

    @Override
    public Account createT(ResultSet resultSet) throws SQLException {
        return new Account(
                resultSet.getInt(Account.iD),
                resultSet.getString(Account.clientName2),
                resultSet.getString(Account.clientLastName2),
                resultSet.getDate(Account.dateOfBirth2),
                resultSet.getDouble(Account.netSalaryPerMonth2),
                UUID.fromString(resultSet.getString(Account.accountNumber2)),
                BankName.valueOf(resultSet.getString(Account.bankName2)),
                resultSet.getDouble(Account.defaultSolde2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, Account model) throws SQLException {
        if (isClientAboveLegalAge(model.getDateOfBirth())) {
            PreparedStatement preparedStatement = pr.getPreparedStatement();
            preparedStatement.setInt(1, model.getAccountId());
            preparedStatement.setString(2, model.getClientName());
            preparedStatement.setString(3, model.getClientLastName());
            preparedStatement.setDate(4, new java.sql.Date(model.getDateOfBirth().getTime()));
            preparedStatement.setDouble(5, model.getNetSalaryPerMonth());
            preparedStatement.setObject(6, model.getAccountNumber());
            preparedStatement.setObject(7,model.getBankName() , Types.OTHER);
            preparedStatement.setDouble(8, model.getDefaultSolde());
            return preparedStatement;
        } else {
            throw new IllegalArgumentException("The customer must be 21 years of age or older to create an account.");
        }
    }

    private boolean isClientAboveLegalAge(java.sql.Date dateOfBirth) {
        LocalDate birthDate = dateOfBirth.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears() >= 21;
    }

    @Override
    public Class<Account> getClassT() {
        return Account.class;
    }

    @Override
    public Account findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Account delete(Integer id) {
        return super.delete(id);
    }


    @Override
    public Account update(Integer id, Account toUpdate) {
        String sql = "UPDATE account SET client_name=?, client_last_name=?, date_of_birth=?, net_salary_per_month=?, " +
                "account_number=?, bank_name=?, default_solde=? WHERE account_id=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, toUpdate.getClientName());
            preparedStatement.setString(2, toUpdate.getClientLastName());
            preparedStatement.setDate(3, toUpdate.getDateOfBirth());
            preparedStatement.setDouble(4, toUpdate.getNetSalaryPerMonth());
            preparedStatement.setObject(5, toUpdate.getAccountNumber());
            preparedStatement.setObject(6, toUpdate.getBankName(), Types.OTHER);
            preparedStatement.setDouble(7, toUpdate.getDefaultSolde());
            preparedStatement.setInt(8, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return findById(id);
            } else {
                throw new SQLException("The update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred when updating the Account object.", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
