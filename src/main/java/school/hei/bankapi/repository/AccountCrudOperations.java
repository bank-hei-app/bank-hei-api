package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class AccountCrudOperations extends CrudOperationsImpl<Account> {

    @Override
    public Account createT(ResultSet resultSet) throws SQLException {
        return new Account(
                resultSet.getInt(Account.iD),
                resultSet.getString(Account.clientName2),
                resultSet.getString(Account.clientLastName2),
                resultSet.getDate(Account.dateOfBirth2),
                resultSet.getDouble(Account.netSalaryPerMonth2),
                resultSet.getString(Account.accountNumber2),
                resultSet.getInt(Account.bankId2),
                resultSet.getDouble(Account.defaultSolde2)
        );
    }

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, Account model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getAccountId());
        preparedStatement.setString(2, model.getClientName());
        preparedStatement.setString(3, model.getClientLastName());
        preparedStatement.setDate(4, new java.sql.Date(model.getDateOfBirth().getTime()));
        preparedStatement.setDouble(5, model.getNetSalaryPerMonth());
        preparedStatement.setString(6, model.getAccountNumber());
        preparedStatement.setInt(7, model.getBankId());
        preparedStatement.setDouble(8, model.getDefaultSolde());
        return preparedStatement;
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
    public Account update(Integer id) {
        return super.findById(id);
    }
}
