package bo;

import java.util.ArrayList;

import bean.bookbean;
import bean.dangkybean;
import bean.giohangbean;

public class dangkybo {
	public ArrayList<dangkybean> ds = new ArrayList<dangkybean>();
	public void DangKy(String hoten, String diachi, String sodt, String email, String username, String password) {
			for(dangkybean k : ds) {
				dangkybean dk=new dangkybean(hoten, diachi, sodt, email, username, password);
				ds.add(dk);
			}
	}
	
	
}
