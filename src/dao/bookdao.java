package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.bookbean;
import bean.loaibean;

public class bookdao {
	DungChung dc=new DungChung();
		public ArrayList<bookbean> getSach() throws Exception{
			ArrayList<bookbean> ds=new ArrayList<bookbean>();
			/*ds.add(new bookbean("s1","csdl1","Ho van duong1",1000,"a1.jpg","toan"));
			ds.add(new bookbean("s2","csdl2","Ho van duong2",1000,"a2.jpg","tin"));
			ds.add(new bookbean("s3","csdl3","Ho van duong3",1000,"a3.jpg","tin"));
			ds.add(new bookbean("s4","Toan1","Van cao1",1000,"a4.jpg","tin"));
			ds.add(new bookbean("s5","Toan2","Van cao2",1000,"a5.jpg","tin"));
			ds.add(new bookbean("s6","Toan3","Van cao3",1000,"a6.jpg","tin"));*/
			dc.KetNoi();
			//buoc 2: thiet lap cau lenh sql
			String sql="select * from sach";
			//lay du lieu ve
			PreparedStatement cmd=dc.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			//b4: duye qua cac don vi 
			while(rs.next()) {
				String masach=rs.getString("masach");
				String tensach=rs.getString("tensach");
				String tacgia=rs.getString("tacgia");
				long gia=rs.getLong("gia");
				String anh=rs.getString("anh");
				String maloai=rs.getString("maloai");
				bookbean book=new bookbean(masach, tensach, tacgia, gia, anh, maloai);
				ds.add(book);
			
	}
			// dong ket noi 
			rs.close();
			dc.cn.close();
			return ds;

		}
}

