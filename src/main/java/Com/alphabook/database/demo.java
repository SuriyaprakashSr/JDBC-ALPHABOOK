package Com.alphabook.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class demo {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		AlphaBookCurd alphaBookCurd = new AlphaBookCurd();
		System.out.println("ENTER YOUR USER NAME");
		String userName1 = scanner.next();
		System.out.println("ENTER YOUR PASSWORD");
		String password1 = scanner.next();
		if(alphaBookCurd.login(userName1,password1)==true) {
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("1.UpDate status \n 2.exit");
			int choice3 = scanner.nextInt();
			switch(choice3) {
			case 1:
			System.out.println("ENTER YOUR USER  NAME TO UPDATE");
			String userName2= scanner.next();
			System.out.println("ENTER YOUR NEW PASSWORD TO UPDATE");
			String password2 = scanner.next();
			alphaBookCurd.Updatedatabase(userName2, password2);break;
			
			case 2: System.exit(0);;
			default:System.out.println("ENTER VALID CHOICE");
		}
		
		}
		
		
			}

}
