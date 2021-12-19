
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
public class IOtopark {
	public static Dictionary<String, veichle> customers = new Hashtable<String, veichle>(); 
	public static void giris(String plate){
		plate = plate.toLowerCase(); // Veznedarýn salaklýðýný gidermek için uygulanan bir uygulamadýr.
		if (customers.get(plate) == null) {
			customers.put(plate, new veichle(plate, 1 , new Date().getTime() ));
			System.out.println(plate+ " plakalý araç giriþ yaptý");
		}
		else {
			System.out.println("Bu araç zaten içeride.(Araç önceden kaçak çýkýþ yapmýþ olablir.");
		}
	
		
	}
	public static void cikis(String plate) {
		plate = plate.toLowerCase();
		veichle veh = customers.get(plate);
		if (veh == null) {
			System.out.println("Bu araç giriþi yapýlmadý (Dikkat! kaçak giriþ :))");
		}		
		else { 
			long duration = new Date().getTime() - veh.getEntryDate();
			long minutes = duration/60000;
			long hours = minutes/60;
			long days = hours/24;
			System.out.println(days+ " gün, " + hours % 24 + " saat, " + minutes % 60+ " dakika boyunca içeride kaldý.");
			if( duration <= 1200000L) {
				System.out.println("Ücretsiz çýkýþ.");
			}
			else {
				System.out.println("Ücret: "+(hours*7 + (minutes%60 > 0 ? 7 : 0) )+ " TL"); //!! This is how capitalism works :)) !! 
			}
		}
	
	
	}
    public static void main(String[] args) throws InterruptedException {
    	String plate = "34 HE 247";
    	giris(plate);
    	veichle veh = customers.get(plate.toLowerCase());
    	veh.setEntryDate(veh.getEntryDate()-(1*3600000 /*saat*/ + 21*60000 /*dakika*/ ) );
    	//Thread.sleep(60000);//  1 dakika beklemediðiniz sürece çýkýþ yapmayacak. Saniye yapamadým çünkü program dakika bazýnda çalýþýyor.// 
		cikis(plate);
	}
}
