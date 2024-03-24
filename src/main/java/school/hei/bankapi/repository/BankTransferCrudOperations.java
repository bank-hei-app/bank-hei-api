package school.hei.bankapi.repository;

import org.springframework.stereotype.Repository;
import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankTransfer;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository

public class BankTransferCrudOperations extends CrudOperationsImpl<BankTransfer> {


    @Override
    public BankTransfer createT(ResultSet resultSet) throws SQLException {
        return new BankTransfer(
                resultSet.getInt(BankTransfer.iD),
                resultSet.getDouble(BankTransfer.amount2),
                resultSet.getInt(BankTransfer.balanceCategoryId2),
                resultSet.getInt(BankTransfer.balanceTypeId2),
                resultSet.getDate(BankTransfer.dateMakeEffect2),
                resultSet.getDate(BankTransfer.dateRegister2),
                resultSet.getString(BankTransfer.referenceUnique2)
        );
    }


    public void supplyBalance(double montant, int balanceCategoryId, int balanceTypeId, Date dateMakeEffect, Date dateRegister, String referenceUnique) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionConfig.getConnection();
            String query = "INSERT INTO bank_transfer (amount, balance_category_id, balance_type_id, date_make_effect, date_register, reference_unique) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setDouble(1, montant);
            statement.setInt(2, balanceCategoryId);
            statement.setInt(3, balanceTypeId);
            statement.setDate(4, new java.sql.Date(dateMakeEffect.getTime()));
            statement.setDate(5, new java.sql.Date(dateRegister.getTime()));
            statement.setString(6, referenceUnique);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void transferMoney(Account sender, Account receiver , Double amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        if (sender.getDefaultSolde()  > 0  || sender.getDefaultSolde() >= amount) {
            try {
                connection = ConnectionConfig.getConnection();
                String senderBankName = getBankName(connection, sender.getAccountId());
                String receiverBankName = getBankName(connection, receiver.getAccountId());

                if (senderBankName.equals(receiverBankName)) {
                    executeCreditTransferSameBankName(connection, receiver );
                    executeDebitTransferSameBankName(connection,sender);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException("Balance Insufficient");
        }
    }


    private String getBankName(Connection connection, int accountId) throws SQLException {
        PreparedStatement statement = null;
        String query = "SELECT bank_name FROM account WHERE account_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, accountId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("bank_name");
                }
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        throw new SQLException("Account not found");
    }



    private void executeCreditTransferSameBankName(Connection connection, Account receiver) throws SQLException {
        String sql = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, receiver.getAccountId());
            statement.executeUpdate();
        }
    }
    private void executeDebitTransferSameBankName(Connection connection, Account sender) throws SQLException {
        String sql = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, sender.getAccountId());
            statement.executeUpdate();
        }
    }


    
    @Override
    public Class<BankTransfer> getClassT() {
        return BankTransfer.class;
    }

    @Override
    public BankTransfer findById(Integer id) {
        return super.findById(id);
    }
    
    @Override
    public BankTransfer delete(Integer id) {
        String sql = "DELETE FROM bank_transfer WHERE bank_transfer_id = ?";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public BankTransfer update(Integer id, BankTransfer toUpdate) {
        String sql = "UPDATE bank_transfer SET amount=?, balance_category_id=?, balance_type_id=?, " +
                "date_make_effect=?, date_register=?, reference_unique=? WHERE bank_transfer_id=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDouble(1, toUpdate.getAmount());
            preparedStatement.setInt(2, toUpdate.getBalanceCategoryId());
            preparedStatement.setInt(3, toUpdate.getBalanceTypeId());
            preparedStatement.setDate(4, toUpdate.getDateMakeEffect());
            preparedStatement.setDate(5, toUpdate.getDateRegister());
            preparedStatement.setString(6, toUpdate.getReferenceUnique());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();



            return findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
