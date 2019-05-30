package sqlserver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public final class EncapsulatedMSSQLDriver implements Driver {

  public static Driver msSqlDriver;

  private String encapsulatedPrefix = "jdbc:encapsulated-sqlserver://";
  private String msSqlPrefix = "jdbc:sqlserver://";

  static {
    msSqlDriver = new SQLServerDriver();
  }

  public Connection connect(String Url, Properties suppliedProperties) throws SQLException {
    suppliedProperties.setProperty("password", getPassword());
    DriverManager.registerDriver(msSqlDriver);
    return msSqlDriver.connect(Url.replaceFirst(encapsulatedPrefix, msSqlPrefix), suppliedProperties);
  }

  public boolean acceptsURL(String url) throws SQLException {
    return msSqlDriver.acceptsURL(url.replaceFirst(encapsulatedPrefix, msSqlPrefix));
  }

  public DriverPropertyInfo[] getPropertyInfo(String Url, Properties Info) throws SQLException {
    return msSqlDriver.getPropertyInfo(Url.replaceFirst(encapsulatedPrefix, msSqlPrefix), Info);
  }

  public int getMajorVersion() {
    return msSqlDriver.getMajorVersion();
  }

  public int getMinorVersion() {
    return msSqlDriver.getMinorVersion();
  }

  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return msSqlDriver.getParentLogger();
  }

  public boolean jdbcCompliant() {
    return msSqlDriver.jdbcCompliant();
  }

  private String getPassword() {
    // return password from what ever ways you prefer
    // 1. read encrypted password from a config/properties file in current system
    // 2. get password from db server (ssh)
    // decrypt the obtained password and return
    return "";
  }
}
