package bo;

import java.util.ArrayList;

import bean.bookbean;
import dao.bookdao;

public class bookbo {
	bookdao bdao=new bookdao();
	ArrayList<bookbean> ds;
	public ArrayList<bookbean> getsach() throws Exception{
		ds=bdao.getSach();
		return ds;	
	}
	public ArrayList<bookbean> TimSachTheoMa(String maloai){
		ArrayList<bookbean> tam=new ArrayList<bookbean>();
		for(bookbean s: ds) 
			if(s.getMaloai().trim().equalsIgnoreCase(maloai.trim()))
				tam.add(s);
			return tam;
	}
	public ArrayList<bookbean> TimSach(String key){
		ArrayList<bookbean> tam=new ArrayList<bookbean>();
		for(bookbean s: ds) 
			if(s.getTacgia().toLowerCase().contains(key) || s.getTensach().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
			return tam;
	}
}
