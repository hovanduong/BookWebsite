package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dangnhapbean;
import bean.loaibean;

public class dangnhapdao {
	DungChung dc=new DungChung();
	public ArrayList<dangnhapbean> getDangNhap() throws Exception{
		ArrayList<dangnhapbean> ds=new ArrayList<dangnhapbean>();
	
		// buoc 1: ket noi 
		dc.KetNoi();
		//buoc 2: thiet lap cau lenh sql
		String sql="select * from KhachHang";
		//lay du lieu ve
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		//b4: duye qua cac don vi 
		while(rs.next()) {
			String tendangnhap=rs.getString("tendn");
			String matkhau=rs.getString("pass");
			
			dangnhapbean dn=new dangnhapbean(tendangnhap, matkhau);
			ds.add(dn);
		}
		// dong ket noi 
		rs.close();
		dc.cn.close();
		return ds;
		
	}
}
