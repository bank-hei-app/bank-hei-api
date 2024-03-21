package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankName;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

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
    public Account update(Integer id) {
        return super.findById(id);
    }
}
