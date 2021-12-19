
public class veichle {
 
	
	@SuppressWarnings("unused")
	private String Plate; 
	private int Type;
	private long entryDate;
 
	public veichle ( String Plate, int Type, long entryDate) {
		this.Plate = Plate;
		this.Type = Type;
		this.entryDate = entryDate;	
	}	
	
	
	public long getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(long entryDate) {
		this.entryDate = entryDate;
	}


	public int getType() {
		return Type;
	}


	public void giris() {
		System.out.println("Hoþgeldiniz");
	}
	
	public void cikis() {
		System.out.println("Yine Bekleriz");
	}
	


	public String getPlate() {
		return Plate;
	}

	public void setPlate(String plate) {
		Plate = plate;
	}

	

	public void setType(int type) {
		Type = type;
	}


	
	
	
}
