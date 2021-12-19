
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
public class IOtopark {
	public static Dictionary<String, veichle> customers = new Hashtable<String, veichle>(); 
	public static void giris(String plate){
		plate = plate.toLowerCase(); // Veznedar�n salakl���n� gidermek i�in uygulanan bir uygulamad�r.
		if (customers.get(plate) == null) {
			customers.put(plate, new veichle(plate, 1 , new Date().getTime() ));
			System.out.println(plate+ " plakal� ara� giri� yapt�");
		}
		else {
			System.out.println("Bu ara� zaten i�eride.(Ara� �nceden ka�ak ��k�� yapm�� olablir.");
		}
	
		
	}
	public static void cikis(String plate) {
		plate = plate.toLowerCase();
		veichle veh = customers.get(plate);
		if (veh == null) {
			System.out.println("Bu ara� giri�i yap�lmad� (Dikkat! ka�ak giri� :))");
		}		
		else { 
			long duration = new Date().getTime() - veh.getEntryDate();
			long minutes = duration/60000;
			long hours = minutes/60;
			long days = hours/24;
			System.out.println(days+ " g�n, " + hours % 24 + " saat, " + minutes % 60+ " dakika boyunca i�eride kald�.");
			if( duration <= 1200000L) {
				System.out.println("�cretsiz ��k��.");
			}
			else {
				System.out.println("�cret: "+(hours*7 + (minutes%60 > 0 ? 7 : 0) )+ " TL"); //!! This is how capitalism works :)) !! 
			}
		}
	
	
	}
    public static void main(String[] args) throws InterruptedException {
    	String plate = "34 HE 247";
    	giris(plate);
    	veichle veh = customers.get(plate.toLowerCase());
    	veh.setEntryDate(veh.getEntryDate()-(1*3600000 /*saat*/ + 21*60000 /*dakika*/ ) );
    	//Thread.sleep(60000);//  1 dakika beklemedi�iniz s�rece ��k�� yapmayacak. Saniye yapamad�m ��nk� program dakika baz�nda �al���yor.// 
		cikis(plate);
	}
}
