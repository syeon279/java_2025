package jsp_basic;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {
	public static Connection conn;
	
	public DBManager( ) {
		super();
	}
	
	public Connection getConnection() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mbasic");
			conn = ds.getConnection();
			System.out.println("............시작" + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
