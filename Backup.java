import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Backup {
	
	public static final String PATH = "c:/miTienda/";
	
	public String getFormatDay(int day) {
	return(day > 10) ? "" + day : "0"+day;
	}
	
	public void doBackup() {
		// Directorio Raiz de los Backups
		File dirBackup= new File(PATH + "Backup");	
				
		//Directorio de los Backups
		Calendar cal = Calendar.getInstance();
		String month = getFormatDay(cal.get(Calendar.MONTH));
		String format = ""+cal.get(Calendar.YEAR) + month;
		dirBackup = new File(dirBackup, format);
		if(!dirBackup.exists()) {
					dirBackup.mkdirs();
			}
		//Movemos la base de datos
		File origen = new File(PATH+ "database.db");
		format = "db-"+cal.get(Calendar.DAY_OF_MONTH);
		File destino = new File(dirBackup, "");
		origen.renameTo(destino);
				
	}

	
	public static void main(String[] args) {
		// ejecutamos el backup
		Backup bck = new Backup();
		bck.doBackup();
	}
	
}
