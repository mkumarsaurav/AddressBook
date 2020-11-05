import java.io.*;
import java.util.*;

public class AddressBook {

	
	public void saveRecord(String firstName,String lastName,
			String address, String city,String state,String zip ,String phone,String filepath)
	{

		try {
			FileWriter fw = new FileWriter(filepath,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(firstName+","+lastName+","+address+","+city+","+state+","+zip+","+phone);
			pw.flush();
			pw.close();
			System.out.println("Record saved");
		}
		catch(Exception e) {
			System.out.println("Record not saved");
		}
	
	}
	
	public void removeRecord( String name) throws FileNotFoundException {
		
		String tempFile = "C:/Users/w/Desktop/AddBook/temp.txt";
		File oldFile = new File("C:/Users/w/Desktop/AddBook/output.txt");
		File newFile = new File(tempFile);
		String firstName=""; 
		String lastName="";
		String address=""; 
		String city="";
		String state="";
		String zip = "";
		String phone ="";
		
		try {
			FileWriter     fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter    pw = new PrintWriter(bw);
			Scanner sc = new Scanner(new File( "C:/Users/w/Desktop/AddBook/output.txt"));
			sc.useDelimiter("[,\n]");
			
			while (sc.hasNext()) {
				firstName=sc.next();
				lastName=sc.next();
				address=sc.next(); 
				city=sc.next();
				state=sc.next();
				zip =sc.next();
				phone =sc.next();
				if(!name.equals(firstName)) {
					pw.println(firstName+","+lastName+","+address+","+city+","+state+","+zip+","+phone);
				}
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File("C:/Users/w/Desktop/AddBook/output.txt");
			newFile.renameTo(dump);
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	public void readRecord(String name) {
		
		boolean found = false;
		String firstName=""; 
		String lastName="";
		String address=""; 
		String city="";
		String state="";
		String zip = "";
		String phone ="";
		
		try {
			Scanner sc = new Scanner(new File("C:/Users/w/Desktop/AddBook/output.txt"));
			sc.useDelimiter("[,\n]");
			
			while(sc.hasNext() && !found) {
				firstName=sc.next();
				lastName=sc.next();
				address=sc.next(); 
				city=sc.next();
				state=sc.next();
				zip =sc.next();
				phone =sc.next();
				
				if(name.equals(firstName)) {
					found = true;
				}
				
			}
			if(found) {
				System.out.println("First Name: "+firstName);
				System.out.println("Last Name: "+lastName);
				System.out.println("Address: "+address);
				System.out.println("City: "+city);
				System.out.println("State: "+state);
				System.out.println("Zip: "+zip);
				System.out.println("Phone Number: "+phone);
			}
			else {
				System.err.println("Record not found");
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public void editRecord(String newfirstName,String newlastName,
			String newaddress, String newcity,String newstate,String newzip,String newphone) {
		
		String tempFile = "C:/Users/w/Desktop/AddBook/temp.txt";
		File oldFile = new File("C:/Users/w/Desktop/AddBook/output.txt");
		File newFile = new File(tempFile);
		String firstName=""; 
		String lastName="";
		String address=""; 
		String city="";
		String state="";
		String zip = "";
		String phone ="";
		try {
			FileWriter     fw = new FileWriter(tempFile,true);  //does not overrides but appends,writes when there is any value
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter    pw = new PrintWriter(bw);
			Scanner sc = new Scanner(new File("C:/Users/w/Desktop/AddBook/output.txt"));
			sc.useDelimiter("[,\n]");
			
			while(sc.hasNext()){
				firstName=sc.next();
				lastName=sc.next();
				address=sc.next(); 
				city=sc.next();
				state=sc.next();
				zip =sc.next();
				phone =sc.next();
				
				if(firstName.equals(newfirstName)) {
					pw.println(newfirstName+","+newlastName+","+newaddress+","+newcity+","+newstate+","+newzip+","+newphone);
				}
				else {
					pw.println(firstName+","+lastName+","+address+","+city+","+state+","+zip+","+phone);
				}
				
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File("C:/Users/w/Desktop/AddBook/output.txt");
			newFile.renameTo(dump);
		}
		catch(Exception e){
			System.err.println("File not found");
		}
	}
}