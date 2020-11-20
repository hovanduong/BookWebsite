package bean;

public class dangnhapbean {
	private String tendangnhap;
	private String matkhau;
	public dangnhapbean(String tendangnhap, String matkhau) {
		super();
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
}
