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
           String updateAccountBalanceQuery = "UPDATE account SET default_solde = default_solde - ? WHERE account_id = ?";
           PreparedStatement preparedStatement1 = connection.prepareStatement(updateAccountBalanceQuery);
           preparedStatement1.setDouble(1, table.getAmount());
           preparedStatement1.setInt(2, table.getAccountId());
           preparedStatement1.executeUpdate();
       }
        if(table.getBalanceTypeId() == BalanceType.CREDIT.getValue()){
            Connection connection = preparedStatement.getConnection();
            String updateAccountBalanceQuery = "UPDATE account SET default_solde = default_solde + ? WHERE account_id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(updateAccountBalanceQuery);
            preparedStatement1.setDouble(1, table.getAmount());
            preparedStatement1.setInt(2, table.getAccountId());
            preparedStatement1.executeUpdate();
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
    public Transaction update(Integer id) {
        return super.findById(id);
    }
}
