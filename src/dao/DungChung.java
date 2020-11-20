package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
		// buoc 1: Xác định hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// buoc 2: ket noi
		String url="jdbc:sqlserver://ADMIN:1433;databaseName=QlSach;user=sa;password=123456";
		cn=DriverManager.getConnection(url);
		System.out.print("Da ket noi");
	}
}
