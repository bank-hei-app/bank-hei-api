package school.hei.bankapi.utils;
import java.sql.*;


public class PreparedStatementStep {
    PreparedStatement preparedStatement;
    private int index = 1;

    public PreparedStatementStep(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
    public PreparedStatementStep addValues(Object value, ColumnType type) throws SQLException {
        switch (type){
            case INT -> {
                return addValue((int) value);
            }
            case STRING -> {
                return addValue((String) value);
            }

        }
        return null;
    };

    public PreparedStatementStep addValue(int value) throws SQLException {
        preparedStatement.setInt(index++, value);
        return this;
    };
    public PreparedStatementStep addValue(String value) throws SQLException {
        preparedStatement.setString(index++, value);
        return this;
    };

}
