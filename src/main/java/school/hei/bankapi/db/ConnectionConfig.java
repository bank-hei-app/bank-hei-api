package school.hei.bankapi.db;

import school.hei.bankapi.exeption.DatabaseConnectionException;

import java.sql.*;

public class ConnectionConfig {
    private static final String URL = System.getenv("PG_URL");
    private static final String USERNAME = System.getenv("PG_USERNAME");
    private static final String PASSWORD = System.getenv("PG_PASSWORD");
  public static Connection getConnection(String URL , String USERNAME , String PASSWORD ){
      try {
          Class.forName("org.postgresql.Driver");
          return DriverManager.getConnection(URL , USERNAME , PASSWORD);
      } catch (SQLException | ClassNotFoundException e) {
          throw new DatabaseConnectionException(e.getMessage());
      }
  }
  public static Connection getConnection(){
      return getConnection(URL ,USERNAME , PASSWORD);
  }


}
