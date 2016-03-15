import java.io.*;
import java.util.*;

public class PhoneDirectory {
	
	String get_info;      //to return getNumber(name)
	
	public void addEntry(String name, String phone_number) throws IOException{
		
		Properties property = new Properties();
		OutputStream outfile = new FileOutputStream("src/main/resources/PhoneDirectory.txt", true);
		
		property.setProperty(name, phone_number);
		
		property.store(outfile, null);  //store value to the directory
		outfile.close();
	}
	
	public void deleteEntry(String name) throws IOException{
		
		Properties property = new Properties();
		
		InputStream infile = new FileInputStream("src/main/resources/PhoneDirectory.txt");   //delete the contents
		property.load(infile);
		property.remove(name);
		infile.close();
		
		OutputStream outfile = new FileOutputStream("src/main/resources/PhoneDirectory.txt"); //after deletion
		property.store(outfile, null);
		outfile.close();
		
	}
	
//Input a person's name and get phone number
	public String getNumber(String name) throws IOException{
		
		Properties property = new Properties();
		InputStream infile = new FileInputStream("src/main/resources/PhoneDirectory.txt");
		property.load(infile);
		get_info = property.getProperty(name);
		infile.close();
		
		System.out.println(get_info);
		return get_info;
		
	}
	
//Change the phone number of people	
	public void changeEntry(String name, String phone_number) throws IOException{
		
		Properties property = new Properties();
		
		InputStream infile = new FileInputStream("src/main/resources/PhoneDirectory.txt");
		property.load(infile);
		property.replace(name, phone_number);
		infile.close();
		
		OutputStream outfile = new FileOutputStream("src/main/resources/PhoneDirectory.txt"); 
		property.store(outfile, null);
		outfile.close();
	}
	
	//Construcor
	
	public PhoneDirectory(String location_File) throws IOException
	{
		
	}
}
