import java.io.*;
import java.util.*;

public class AddressBook {

	
	private Scanner sc;

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
	
	public int saveAs() {
		sc = new Scanner(System.in);
		System.out.println("Enter 1.)Save 2.)Save As");
		int choice=sc.nextInt();
		int ch=0;
		switch(choice) {
			case 1:
				ch=1;
				System.out.println("Saving...");
				break;
			case 2:
				System.out.println("Saving as .csv extension");				
				ch=2;
				break;
			default:
				System.out.println("Enter Valid Choice!!");
				break;
		}
		return ch;
	}
	public void removeRecord( String name) throws FileNotFoundException {
		
		String tempFile = "C:/Users/w/Desktop/AddBook/temp.txt";
		//File of = new File("C:/Users/w/Desktop/AddBook/output.txt");
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
			FileWriter     fw = new FileWriter(newFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter    pw = new PrintWriter(bw);
			Scanner sc = new Scanner(oldFile);
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
			removeBlankLines();
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
	
	public void readRecord(String name) throws FileNotFoundException {
		
		boolean found = false;
		String firstName=""; 
		String lastName="";
		String address=""; 
		String city="";
		String state="";
		String zip = "";
		String phone ="";
		
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
				System.out.println("Record not found");
			}
		
		sc.close();
	}
	
	public void editRecord(String newfirstName,String newlastName,String newaddress, String newcity,String newstate,String newzip,String newphone) {
		
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
			removeBlankLines();
		}		
		catch(Exception e){
			System.err.println("File not found "+e);
		}
	}
	public void removeBlankLines() {

		String inputFile ="C:/Users/w/Desktop/AddBook/output.txt";
		try {
			
			BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFile));
			String inputFileLine;
			String newFile = "C:/Users/w/Desktop/AddBook/temp.txt";
	
			PrintWriter outputFile = new PrintWriter(new FileWriter(newFile));
			while((inputFileLine = inputFileReader.readLine()) != null) {
				if(inputFileLine.length() == 0)
					continue;
				outputFile.println(inputFileLine);
			} 
			inputFileReader.close();
			outputFile.close();
			File inFile=new File(inputFile);
			File outFile=new File(newFile);
			File dump=new File(inputFile);
			inFile.delete();
			outFile.renameTo(dump);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}