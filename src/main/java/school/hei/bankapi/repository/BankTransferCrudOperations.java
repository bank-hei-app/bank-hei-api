package school.hei.bankapi.repository;

import school.hei.bankapi.db.ConnectionConfig;
import school.hei.bankapi.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BankTransferCrudOperations {
    private Map<Integer, LocalDateTime> debitRequests = new HashMap<>();

    public void transferMoney(Account sender, Account receiver, double amount) {
        if (sender.getDefaultSolde() >= amount && amount > 0) {
            try (Connection connection = ConnectionConfig.getConnection()) {
                String senderBankName = getBankName(connection, sender.getAccountId());
                String receiverBankName = getBankName(connection, receiver.getAccountId());

                if (senderBankName.equals(receiverBankName)) {
                    executeCreditTransfer(connection, receiver.getAccountId(), amount);
                } else {
                    debitAccount(sender.getAccountId(), amount);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Balance Insufficient");
        }
    }

    private String getBankName(Connection connection, int accountId) throws SQLException {
        String query = "SELECT bank_name FROM account WHERE account_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("bank_name");
                }
            }
        }
        throw new SQLException("Account not found");
    }

    private void executeCreditTransfer(Connection connection, int receiverAccountId, double amount) throws SQLException {
        String sql = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, amount);
            statement.setInt(2, receiverAccountId);
            statement.executeUpdate();
        }
    }

    private void debitAccount(int senderAccountId, double amount) {
        synchronized (debitRequests) {
            debitRequests.put(senderAccountId, LocalDateTime.now());
            System.out.println("Debit of " + amount + " requested for account " + senderAccountId);
        }
    }

    public void executeDebits() {
        LocalDateTime now = LocalDateTime.now();
        synchronized (debitRequests) {
            debitRequests.entrySet().removeIf(entry -> now.minusHours(48).isAfter(entry.getValue()));
            for (Map.Entry<Integer, LocalDateTime> entry : debitRequests.entrySet()) {
                int accountId = entry.getKey();
                LocalDateTime requestTime = entry.getValue();
                if (now.minusHours(48).isAfter(requestTime)) {
                    try (Connection connection = ConnectionConfig.getConnection()) {
                        String sql = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";
                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                            statement.setDouble(1, 0.0);
                            statement.setInt(2, accountId);
                            statement.executeUpdate();
                            System.out.println("Debit executed for account " + accountId);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    debitRequests.remove(accountId);
                }
            }
        }
    }
}
