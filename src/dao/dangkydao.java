package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dangkybean;
import bean.loaibean;

public class dangkydao {
	DungChung dc=new DungChung();
		public boolean signUp(String hoten, String diachi, String sodt, String email, String username, String password) {
			 DungChung DC = new DungChung();
			 boolean isOk = false;
			 
			 try {
				 DC.KetNoi();
				 Connection conn = DC.cn;
				 int Key = getPrimaryKey();
				 String query = "INSERT INTO KhachHang(Hoten, DiaChi, Sodt, Email, TenDn, Pass) VALUES (?, ?, ?, ?, ?, ?)";
				 PreparedStatement stmt = conn.prepareStatement(query);
//				 stmt.setInt(1, Key);
				 stmt.setNString(1, hoten);
				 stmt.setNString(2, diachi);
				 stmt.setString(3, sodt);
				 stmt.setString(4, email);
				 stmt.setString(5, username);
				 stmt.setString(6, password);
				 
				 stmt.executeUpdate();
				 isOk = true;
				 stmt.close();
				 conn.close();
			 } catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
			return isOk;
		}
		
		public int getPrimaryKey() throws Exception{
			 DungChung DC = new DungChung();
			 int ID = -1;
			 DC.KetNoi();
			 Connection conn = DC.cn;
			 String query = "SELECT TOP 1 makh from KhachHang ORDER BY makh DESC";
			 PreparedStatement stmt = conn.prepareStatement(query);
			 
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 ID = rs.getInt(1);
			 }
			 stmt.close();
			 conn.close();
			 
			 return ID + 1;
			 
		}
		
		public dangkybean auth(String username, String password) {
			 DungChung DC = new DungChung();
			 
			 try {
				 DC.KetNoi();
				 Connection conn = DC.cn;
				 String query = "SELECT * FROM KhachHang WHERE tendn = ? AND pass = ?";
				 PreparedStatement stmt = conn.prepareStatement(query);
				 stmt.setString(1, username);
				 stmt.setString(2, password);
				 
				 ResultSet rs = stmt.executeQuery();	 
				 while(rs.next()) {
					 String tentk = rs.getString(1);
					 String hoten = rs.getString(2);
					 String diachi = rs.getString(3);
					 String sodt = rs.getString(4);
					 String email = rs.getString(5);
					 String user = rs.getString(6);
					 String pass = rs.getString(7);
					 
					 if (user != null && pass != null) {
						 return new dangkybean(tentk, diachi, sodt, email, user, pass);
					 }
				 }
				 stmt.close();
				 conn.close();
			 } catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
			return null;
		}
		
		public boolean checkUserExist(String username) {
			 DungChung DC = new DungChung();
			 
			 try {
				 DC.KetNoi();
				 Connection conn = DC.cn;
				 String query = "SELECT * FROM KhachHang WHERE tendn = ?";
				 PreparedStatement stmt = conn.prepareStatement(query);
				 stmt.setString(1, username);
				 
				 ResultSet rs = stmt.executeQuery();	 
				 if (rs.next()) {
					 return true;
				 }
				 stmt.close();
				 conn.close();
			 } catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
			return false;
		}
}
