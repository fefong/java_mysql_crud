package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public abstract class database {

	private final String driver = "com.mysql.jdbc.Driver";
	private final String user = "root";
	private final String password = "";
	protected final String database = "database_test";
	private final String ssl = "?autoReconnect=true&useSSL=false";
	private static final String ip = "localhost";
	private static final String port = "3307";
	private final String url = "jdbc:mysql://" + ip + ":" + port + "/";

	protected static Connection cn = null;

	protected static ResultSet rs = null;
	protected static Statement st = null;
	protected static PreparedStatement ps = null;
	protected static java.sql.CallableStatement stmt = null;

	Logger logger = Logger.getLogger(database.class.getName());

	protected boolean conect() {

		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url + database, user, password);

			return true;
		} catch (ClassNotFoundException e) {
			logger.warning(e.getMessage());
			return false;
		} catch (SQLException e) {
			logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
			return false;
		}

	}

	protected boolean disconect() {

		try {
			cn.close();
		} catch (SQLException e) {
			logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
		}

		return false;
	}

	protected boolean isClosed() {
		try {

			return cn.isClosed();
		} catch (SQLException e) {
			logger.warning(String.format("Code: %s | Message: %s", e.getErrorCode(), e.getMessage()));
			return true;
		}
	}

	public String info() {

		StringBuilder format = new StringBuilder();
		format.append("*-----------------------------------------*\n");
		format.append(" Driver:  %s\n");
		format.append(" URL:  %s\n");
		format.append(" Database:  %s\n");
		format.append(" User:  %s\n");
		format.append("*-----------------------------------------*\n");
		Object[] args = new Object[] {driver, url, database, user};

		return String.format(format.toString(), args);
	}

}
