package school.hei.bankapi.repository;

import school.hei.bankapi.model.Account;
import school.hei.bankapi.model.BankTransfer;
import school.hei.bankapi.model.Transaction;
import school.hei.bankapi.utils.PreparedStatementStep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransferCrudOperations extends CrudOperationsImpl<BankTransfer> {

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
        preparedStatement.setDate(5, new java.sql.Date(model.getDateMakeEffect().getTime()));
        preparedStatement.setDate(6, new java.sql.Date(model.getDateRegister().getTime()));
        preparedStatement.setString(7, model.getReferenceUnique());
        return preparedStatement;
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
        return super.delete(id);
    }

    @Override
    public BankTransfer update(Integer id) {
        return super.findById(id);
    }

}
