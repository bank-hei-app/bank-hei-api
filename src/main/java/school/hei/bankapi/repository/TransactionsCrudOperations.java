package school.hei.bankapi.repository;

import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.Transaction;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.*;

public class TransactionsCrudOperations extends CrudOperationsImpl<Transaction>{
    @Override
    public Transaction createT(ResultSet resultSet) throws SQLException {
        return new Transaction(
                resultSet.getInt(Transaction.iD),
                resultSet.getInt(Transaction.accountId2),
                resultSet.getDate(Transaction.dateOfTransaction2),
                resultSet.getDouble(Transaction.amount2),
                resultSet.getInt(Transaction.balanceTypeId2),
                resultSet.getInt(Transaction.balanceCategoryId2)
        );
    }
    @Override
    public PreparedStatement createT(PreparedStatementStep pr, Transaction table) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();

        preparedStatement.setInt(1,table.getTransactionId());
        preparedStatement.setInt(2,table.getAccountId());
        preparedStatement.setTimestamp(3, new Timestamp(table.getDateOfTransaction().getTime()));
        preparedStatement.setDouble(4,table.getAmount());
        preparedStatement.setInt(5,table.getBalanceTypeId());
        preparedStatement.setInt(6,table.getBalanceCategoryId());

        preparedStatement.executeUpdate();

        if(table.getBalanceTypeId() == BalanceType.DEBIT.getValue()){
            Connection connection = preparedStatement.getConnection();
            double accountBalance = getAccountBalance(connection, table.getAccountId());

            if (accountBalance >= table.getAmount()) {
                String updateAccountBalanceQuery = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";

                PreparedStatement preparedStatement1 = connection.prepareStatement(updateAccountBalanceQuery);
                preparedStatement1.setDouble(1, table.getAmount());
                preparedStatement1.setInt(2, table.getAccountId());
                preparedStatement1.executeUpdate();
            }else {
                System.out.println("solde insufficient");
            }
        }
        if(table.getBalanceTypeId() == BalanceType.CREDIT.getValue()){
            Connection connection = preparedStatement.getConnection();
            double creditAuthorized = getCreditAuthorized(connection, table.getAccountId());

            if (creditAuthorized == table.getAmount()){
                String updateAccountBalanceQuery = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(updateAccountBalanceQuery);
                preparedStatement1.setDouble(1, table.getAmount());
                preparedStatement1.setInt(2, table.getAccountId());
                preparedStatement1.executeUpdate();
            }else {
                System.out.println("Credit unauthorized");
            }

        }

        return preparedStatement;
    }

    private enum BalanceType {
        DEBIT(1),
        CREDIT(2);

        private final int value;

        BalanceType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private double getAccountBalance(Connection connection, int accountId) throws SQLException {
        String query = "SELECT default_solde FROM account WHERE account_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("default_solde");
                } else {
                    throw new SQLException("Compte non trouvé.");
                }
            }
        }
    }

    private double getCreditAuthorized(Connection connection, int accountId) throws SQLException {
        String query = "SELECT net_salary_per_month FROM account WHERE account_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("net_salary_per_month") / 3; // ⅓ du salaire mensuel net
                } else {
                    throw new SQLException("Compte non trouvé.");
                }
            }
        }
    }
    @Override
    public Class<Transaction> getClassT() {
        return Transaction.class;
    }

    @Override
    public Transaction findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Transaction delete(Integer id) {
        return super.delete(id);
    }

    @Override
    public Transaction update(Integer id, Transaction toUpdate) {
        String sql = "UPDATE " + Transaction.tableName + " SET " +
                Transaction.accountId2 + " = ?, " +
                Transaction.dateOfTransaction2 + " = ?, " +
                Transaction.amount2 + " = ?, " +
                Transaction.balanceTypeId2 + " = ?, " +
                Transaction.balanceCategoryId2 + " = ? " +
                "WHERE " + Transaction.iD + " = ?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toUpdate.getAccountId());
            preparedStatement.setTimestamp(2, new Timestamp(toUpdate.getDateOfTransaction().getTime()));
            preparedStatement.setDouble(3, toUpdate.getAmount());
            preparedStatement.setInt(4, toUpdate.getBalanceTypeId());
            preparedStatement.setInt(5, toUpdate.getBalanceCategoryId());
            preparedStatement.setInt(6, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                return findById(id);
            } else {
                throw new SQLException("The update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred when updating the Transaction object.", e);
        }
    }

}