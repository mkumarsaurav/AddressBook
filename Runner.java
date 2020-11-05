import java.io.*;
import java.util.*;

public class Runner extends AddressBook {

		
		public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(System.in);
			
			Runner r = new Runner();
			int valid=1;
			while(valid==1) {
			System.out.println("Enter Below Option for a Record: ");
			System.out.println("1)Add 2)Search 3)Edit 4)Delete 5)Exit");
			int option = sc.nextInt();
			
			switch(option) {
			
				case 1:
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Enter Your Details");
					
					System.out.println("First Name: ");
					String firstName = sc1.nextLine();
					
					System.out.println("Last Name: ");
					String lastName  = sc1.nextLine();
					
					System.out.println("Address: ");
					String address   = sc1.nextLine();
					
					System.out.println("City: ");
					String city      = sc1.nextLine();
					
					System.out.println("State: ");
					String state     = sc1.nextLine();
					
					System.out.println("Zip: ");
					String   zip       = sc1.nextLine();
					
					System.out.println("Phone Number: ");
					String    phone     = sc1.nextLine();
					
					String filepath = "C:/Users/w/Desktop/AddBook/output.txt";
					
					r.saveRecord(firstName,lastName,address,city,state,zip,phone,filepath);
					
					break;
				
				case 2:
					System.out.println("Enter First Name to Search: ");
					Scanner sc2 = new Scanner(System.in);
					String name2 = sc2.next();
					r.readRecord(name2);
					break;
					
				case 3:
					System.out.println("Enter Details to Edit: ");
					Scanner sc3 = new Scanner(System.in);
					System.out.println("First Name: ");
					String newfirstName = sc3.nextLine();
					
					System.out.println("Last Name: ");
					String newlastName  = sc3.nextLine();
					
					System.out.println("Address: ");
					String newaddress   = sc3.nextLine();
					
					System.out.println("City: ");
					String newcity      = sc3.nextLine();
					
					System.out.println("State: ");
					String newstate     = sc3.nextLine();
					
					System.out.println("Zip: ");
					String   newzip       = sc3.nextLine();
					
					System.out.println("Phone Number: ");
					String    newphone     = sc3.next();
					
					r.editRecord(newfirstName,newlastName,newaddress,newcity,newstate,newzip,newphone);
					break;
					
					
				case 4:
					System.out.println("Enter First Name to Delete: ");
					Scanner sc4 = new Scanner(System.in);
					String name1 = sc4.next();
					r.removeRecord(name1);
					break;
				
				case 5:
					valid=0;
					break;
				default:
					System.out.println("Enter Valid Choice!!");
					break;
			
			}
			//sc.close();
		}
		}
}