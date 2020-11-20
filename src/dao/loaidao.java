package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	DungChung dc=new DungChung();
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds=new ArrayList<loaibean>();
	/*	ds.add(new loaibean("tin","cong nghe thong tin"));
		ds.add(new loaibean("toan","toan hoc"));
		ds.add(new loaibean("ly","ly hoc"));
		ds.add(new loaibean("sinh","sinh hoc"));*/
		// buoc 1: ket noi 
		dc.KetNoi();
		//buoc 2: thiet lap cau lenh sql
		String sql="select * from loai";
		//lay du lieu ve
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		//b4: duye qua cac don vi 
		while(rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			loaibean loai=new loaibean(maloai,tenloai);
			ds.add(loai);
		}
		// dong ket noi 
		rs.close();
		dc.cn.close();
		return ds;
		
	}
}
