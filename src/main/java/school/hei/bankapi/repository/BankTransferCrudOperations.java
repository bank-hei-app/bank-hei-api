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
        PreparedStatement statement = null;

        if (sender.getDefaultSolde()  > 0  || sender.getDefaultSolde() >= amount) {
            try {

                String senderBankName = getBankName( sender.getAccountId());
                String receiverBankName = getBankName( receiver.getAccountId());

                if (senderBankName.equals(receiverBankName)) {
                    executeCreditTransferSameBankName( receiver );
                    executeDebitTransferSameBankName(sender);
                }
                else {
                    executeDebits();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException("Balance Insufficient");
        }
    }


    private String getBankName( int accountId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "SELECT bank_name FROM account WHERE account_id = ?";
        try {
            connection = ConnectionConfig.getConnection();
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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        throw new SQLException("Account not found");
    }



    private void executeCreditTransferSameBankName( Account receiver) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, receiver.getAccountId());
            statement.executeUpdate();
        }
        finally {
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
    }
    private void executeDebitTransferSameBankName( Account sender) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";

        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sender.getAccountId());
            statement.executeUpdate();
        }
        finally {
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
    }

    public void executeDebitTransferDifferentBankName( int accountId, String destinationBankName, LocalDateTime requestTime) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        if (!destinationBankName.equals(getBankName(accountId))) {
            synchronized (debitRequests) {
                debitRequests.put(accountId, requestTime);
            }
        } else {

            if (now.minusHours(48).isAfter(requestTime)) {
                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    connection = ConnectionConfig.getConnection();
                    String sql = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";
                    statement = connection.prepareStatement(sql);
                    statement.setInt(1, accountId);
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
            }
        }
    }

    public void executeDebits() throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        synchronized (debitRequests) {
            debitRequests.entrySet().removeIf(entry -> now.minusHours(48).isAfter(entry.getValue()));
            for (Map.Entry<Integer, LocalDateTime> entry : debitRequests.entrySet()) {
                int accountId = entry.getKey();
                LocalDateTime requestTime = entry.getValue();
                executeDebitTransferDifferentBankName(accountId, getBankName(accountId), requestTime);
                debitRequests.remove(accountId);
            }
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
