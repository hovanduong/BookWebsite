package bo;

import java.util.ArrayList;

import bean.bookbean;
import bean.dangnhapbean;
import bean.giohangbean;
import dao.dangnhapdao;




public class dangnhapbo {
	dangnhapdao dn=new dangnhapdao();
	ArrayList<dangnhapbean> ds;
	public ArrayList<dangnhapbean> ds1 = new ArrayList<dangnhapbean>();
	public ArrayList<dangnhapbean> getDangNhap() throws Exception{
		ds=dn.getDangNhap();
		return ds;	
	}
}
