package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String masach, String tensach, long gia, long soluong, String maloai) {
		// hang trung
		for(giohangbean g : ds) 
			if(g.getMasach().equals(masach)) {
				g.setSoluong(g.getSoluong()+soluong);
				return;
			}
			giohangbean gh=new giohangbean(masach, tensach, gia, soluong, maloai);
			ds.add(gh);
	
	}
	public void xoa(String masach) {
		for(giohangbean g : ds) 
			if(g.getMasach().equals(masach)) {
				ds.remove(g);
				break;			
			}
		
	}
	public long TongTien() {
	long s=0;
	for(giohangbean g : ds) 
		s+=g.getThanhtien();
		return s;
	}

}
