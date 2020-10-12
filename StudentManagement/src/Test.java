import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

/**
 * This was mainly used to test certain codes where I was Stuck
 * @author Anurag
 */
public class Test {
	
	public static void main(String[] args) throws IOException {
//		String nameRules = "[A-Z][a-z]{1,10}[ ][A-Z][a-z]{1,10}";
//		String name = "Anurag Kumar";
//		boolean temp = name.matches(nameRules);
//		System.out.println(temp);
		
		String mobile;
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		mobile = br.readLine();
		System.out.println(mobile);
		
//		long millis=;  
//		java.sql.Date date=new java.sql.Date(System.currentTimeMillis());  
//		System.out.println(date);
	
//		String dt = "2020-02-16";
//		Date date=new Date(System.currentTimeMillis());
//		
//		//LocalDate localdate = LocalDate.parse(dt);
//		Date daete = Date.valueOf(dt);
//		if( date.compareTo(daete)>0)
//			System.out.println(date + " is after " + daete);
		
//		char a= 's';
//		a = Character.toUpperCase(a);
//		System.out.println(a);
	}
}