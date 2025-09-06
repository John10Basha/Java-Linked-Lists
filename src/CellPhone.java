import java.lang.CloneNotSupportedException;

	
public class CellPhone implements Cloneable {
	
	private long serialNum;
	private String brand;
	private double price;
	private int year;
	
	
	// (a) Parameterized constructor that accepts four values and initializes serialNum, brand, year and price to these passed values;  
	public CellPhone(long sn, String b, double p, int y) {
		serialNum = sn;
		brand = b;
		price = p;
		year = y;
		
	}
	
	// (b) Copy constructor, which takes two parameters, a CellPhone object and a long value
	public CellPhone(CellPhone cp, long sn) {
		serialNum = sn;
		brand = cp.brand;
		price = cp.price;
		year = cp.year;
	}
	
	public void setSerialNum(long sn) {
		serialNum = sn;
	}
	
	public long getSerialNum() {
		return serialNum;
	}

	public void setBrand(String b) {
		brand = b;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public double getPrice() {
		return price;
	}
	
	// (c) clone() method.
	@Override
	public CellPhone clone() {
		try 
		{
			CellPhone cloned = (CellPhone) super.clone(); 
			return cloned;
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println("This clone is not supported");
			return null;
		}
		
	}
	
	// (d) Additionally, the class should have a toString() and an equals() methods.
	@Override
	public boolean equals(Object x) {
		if(x == null || this.getClass() != x.getClass()) 
		{
			return false;
		}
		CellPhone cp1 = (CellPhone) x;
		return (this.brand.equals(cp1.brand) && this.price == cp1.price && this.year == cp1.year);
	}
	
	@Override
	// Warning: This method can cause a privacy leak
	// Reason: toString includes sensitive data (Serial Number)
	// Since the serial number is unique to each CellPhone, it is sensitive and should not be displayed in the console output
	public String toString() {
		return "[" +serialNum+ ": " +brand+ " " +price+ "$ " +year+ "]";
	}
	
	

}
