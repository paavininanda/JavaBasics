package FirstClass;

public class ComplexNumber {
	private Integer SNo,Real1,Real2,Img1,Img2;
	
	public ComplexNumber(Integer SNo,Integer Real1,Integer Img1, Integer Real2,Integer Img2) {
		this.SNo = SNo;
		this.Real1 = Real1;
		this.Img1 = Img1;
		this.Real2 = Real2;
		this.Img2 = Img2;
	}
	
	Integer getReal1() {
		return this.Real1;
	}
	
	Integer getImg1() {
		return this.Img1;
	}
	
	Integer getReal2() {
		return this.Real2;
	}
	
	Integer getImg2() {
		return this.Img2;
	}
	
	Integer getSNo() {
		return this.SNo;
	}
	
	void setReal1(Integer i) {
		this.Real1=i;
	}
	
	void setReal2(Integer i) {
		this.Real2=i;
	}
	
	void setImg1(Integer i) {
		this.Img1=i;
	}
	
	void seImg2(Integer i) {
		this.Img2=i;
	}
	
	void setSNo(Integer i) {
		this.SNo=i;
	}
}
