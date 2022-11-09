package Com.alphabook.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		
		AlphaBookUser alphaBookUser = new AlphaBookUser();
		
		AlphaBookCurd alphaBookCurd = new AlphaBookCurd();
		
		
		
		
			while(true) {
				System.out.println("WELCOME TO ALPHABOOK DATABASE");
				System.out.println("PLEASE PRESS 1 FOR SIGNIN");
				System.out.println("PLEASE PRESS 2 FOR LOGIN");
				System.out.println("PLEASE PRESS 3 FOR EXIT ");
				
				System.out.println("ENTER YOUR CHOICE");
				int choice =scanner.nextInt();
				
				switch (choice) {
				case 1: {
					System.out.println("ENTER YOUR FIRST NAME");
					String firstName = scanner.next();
					System.out.println("ENTER YOUR LAST NAME");
					String lastName = scanner.next();
					System.out.println("ENTER YOUR CONTACT NUMBER");
					long phone = scanner.nextLong();
					System.out.println("ENTER YOUR GENDER");
					String gender = scanner.next();
					System.out.println("ENTER YOUR DATE OF BIRTH IN THE FORMATE OF dd-MM-yyyy");
					String dob = scanner.next();
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date 	jud = sdf.parse(dob);
						long l = jud.getTime();
						java.sql.Date  jsd = new java.sql.Date(l);
						
					System.out.println("ENTER YOUR USER NAME");
					String userName = scanner.next();
					System.out.println("ENTER YOUR PASSWORD");
					String password = scanner.next();
					
					alphaBookUser.setFirstName(firstName);
					alphaBookUser.setLastName(lastName);
					alphaBookUser.setContactNumber(phone);
					alphaBookUser.setGender(gender);
					alphaBookUser.setDate_of_birth(jsd);
					alphaBookUser.setUserName(userName);
					alphaBookUser.setPassword(password);
					System.out.println("PRESS 1 FOR SIGH UP");
					System.out.println("PRESS 2 FOR EXIT");
					int choice1 = scanner.nextInt();
					
					switch(choice1) {
					case 1:alphaBookCurd.insertData(alphaBookUser);break;
					
					case 2:System.exit(0);
					default:System.out.println("PLEASE ENTER VALID OPTION");
					}
					
					
				}break;
				case 2:
					System.out.println("ENTER YOUR USER NAME");
					String userName1 = scanner.next();
					System.out.println("ENTER YOUR PASSWORD");
					String password1 = scanner.next();
					if(alphaBookCurd.login(userName1,password1)==true) {
						System.out.println("ENTER YOUR CHOICE");
						System.out.println("1.UpDate status \n 2.Get details \n1 3.exit");
						int choice3 = scanner.nextInt();
						switch(choice3) {
						case 1:
						System.out.println("ENTER YOUR USER  NAME TO UPDATE");
						String userName2= scanner.next();
						System.out.println("ENTER YOUR NEW PASSWORD TO UPDATE");
						String password2 = scanner.next();
						alphaBookCurd.Updatedatabase(userName2, password2);break;
						
						
						
						case 2:alphaBookCurd.getDataByUserName(userName1);
						case 3: System.exit(0) ;
						default:System.out.println("ENTER VALID CHOICE");
					}
					
					}
					
					
					
					
					
					break;
					
				case 3: System.exit(0);
				System.out.println("EXIT SUCESSFULL");;

				
				
				
				default:System.out.println("PLEASE ENTER VALID CHOICE");
				}
			}
		
		
		
		
		
		//alphaBookCurd.deleteData("tom@gmail.com");
		//alphaBookCurd.getData();
		//alphaBookCurd.getDataByUserName("suriya@gmail.com");
		//alphaBookCurd.Updatedatabase("suriya@gmail.com","vjhvuy8888");
		
	}
}
