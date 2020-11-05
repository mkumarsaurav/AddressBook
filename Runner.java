import java.io.*;
import java.util.*;

public class Runner extends AddressBook {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		Runner r = new Runner();
		try (Scanner sc = new Scanner(System.in)) {

					boolean flag=true;
					int option;
					while(flag) {
						System.out.println("Enter Below Option for a Record: ");
						System.out.println("1)Add 2)Search 3)Edit 4)Delete 5)Exit");
						
						option=sc.nextInt();
				
						
						switch(option) {
					
							case 1:
					
								String details[]=r.getDetails();
								
								String filepath = "C:/Users/w/Desktop/AddBook/output.txt";
								
								int ch=r.saveAs();
								if(ch==1) {
									r.saveRecord(details[0],details[1],details[2],details[3],details[4],details[5],details[6],filepath);
								}
								else if(ch==2) {
									String filepath1 = "C:/Users/w/Desktop/AddBook/output.csv";
									r.saveRecord(details[0],details[1],details[2],details[3],details[4],details[5],details[6],filepath1);
								}
								else
									System.out.println("Record Not Saved");
								break;
							
							case 2:
								System.out.println("Enter First Name to Search: ");
								Scanner sc2 = new Scanner(System.in);
								String name2 = sc2.next();
								r.readRecord(name2);
								break;
								
							case 3:
								System.out.println("Enter Details to Edit: ");
								String newdetails[]=r.getDetails();
								r.editRecord(newdetails[0],newdetails[1],newdetails[2],newdetails[3],newdetails[4],newdetails[5],newdetails[6]);
								break;
								
								
							case 4:
								System.out.println("Enter First Name to Delete: ");
								Scanner sc4 = new Scanner(System.in);
								String name1 = sc4.next();
								r.removeRecord(name1);
								break;
						
							case 5:
								flag=false;
								break;
							default:
								System.out.println("Enter Valid Choice!!");
								break;
					
						}				
				}
		}
	}
}