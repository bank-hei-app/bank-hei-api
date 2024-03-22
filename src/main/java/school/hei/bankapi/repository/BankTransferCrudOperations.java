package school.hei.bankapi.repository;

import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankName;
import school.hei.bankapi.model.BankTransfer;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankTransferCrudOperations extends CrudOperationsImpl<BankTransfer> {
    private Map<Integer, LocalDateTime> debitRequests = new HashMap<>();

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

    @Override
    public PreparedStatement createT(PreparedStatementStep pr, BankTransfer model) throws SQLException {
        PreparedStatement preparedStatement = pr.getPreparedStatement();
        preparedStatement.setInt(1, model.getBankTransferId());
        preparedStatement.setDouble(2, model.getAmount());
        preparedStatement.setInt(3, model.getBalanceCategoryId());
        preparedStatement.setInt(4, model.getBalanceTypeId());
        preparedStatement.setDate(5, model.getDateMakeEffect());
        preparedStatement.setDate(6, model.getDateRegister());
        preparedStatement.setString(7, model.getReferenceUnique());
        return preparedStatement;
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

    public void transferMoney(Account sender, Account receiver, double amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        if (sender.getDefaultSolde() >= amount && amount > 0) {
            try {
                connection = ConnectionConfig.getConnection();
                String senderBankName = getBankName(connection, sender.getAccountId());
                String receiverBankName = getBankName(connection, receiver.getAccountId());

                if (senderBankName.equals(receiverBankName)) {
                    executeCreditTransfer(connection, receiver.getAccountId(), amount);
                } else {
                    debitAccount(sender.getAccountId(), amount);
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

    private void executeCreditTransfer(Connection connection, int receiverAccountId, double amount) throws SQLException {
        PreparedStatement statement = null;
        String sql = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, amount);
            statement.setInt(2, receiverAccountId);
            statement.executeUpdate();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void debitAccount(int senderAccountId, double amount) {
        synchronized (debitRequests) {
            debitRequests.put(senderAccountId, LocalDateTime.now());
            System.out.println("Debit of " + amount + " requested for account " + senderAccountId);
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

    public void executeDebits() {
        Connection connection = null;
        PreparedStatement statement = null;
        LocalDateTime now = LocalDateTime.now();
        synchronized (debitRequests) {
            debitRequests.entrySet().removeIf(entry -> now.minusHours(48).isAfter(entry.getValue()));
            for (Map.Entry<Integer, LocalDateTime> entry : debitRequests.entrySet()) {
                int accountId = entry.getKey();
                LocalDateTime requestTime = entry.getValue();
                if (now.minusHours(48).isAfter(requestTime)) {
                    try {
                        connection = ConnectionConfig.getConnection();
                        String sql = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";
                        statement = connection.prepareStatement(sql);
                        statement.setDouble(1, 0.0);
                        statement.setInt(2, accountId);
                        statement.executeUpdate();
                        System.out.println("Debit executed for account " + accountId);
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
                    debitRequests.remove(accountId);
                }
            }
        }
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
}
