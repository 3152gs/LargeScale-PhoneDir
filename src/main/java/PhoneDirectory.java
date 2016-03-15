import java.io.*;
import java.util.*;

public class PhoneDirectory {
	
	String get_info, location_File, name, number;    
		
	//Construcor
	
		HashMap<String,String> Phone_hashMap= new HashMap<String,String>();
		
		public PhoneDirectory(String location) throws IOException
		{
		
			location_File= location;
			
			
			File fileName = new File(location);
			String line=null;
			try{
				FileReader fileReader = new FileReader(fileName);			
				BufferedReader bufferedReader = new BufferedReader(fileReader);	
				while((line=bufferedReader.readLine())!=null){
					String[] value = line.split(" ");
					name=value[0];
					number=value[1];
					Phone_hashMap.put(name,number);
				}
				bufferedReader.close();
			}
			
			catch(FileNotFoundException ex){
				System.out.println("Unable to open file");
			}
			catch(IOException ex){
				System.out.println("File not opened.");
			}
		}
	
//Add a new entry
	public void addEntry(String name,String number) throws IOException{
		Phone_hashMap.put(name,number);
	}
	
//Delete an entry
	public void deleteEntry(String name) {
		
		if(Phone_hashMap.get(name)!=null){
			Phone_hashMap.remove(name);
			}		
		else{
			System.out.println("Name not found");
			}
	}
	
	
//Input a person's name and get phone number
	public String getNumber(String name) throws IOException{
		String phoneNumber = Phone_hashMap.get(name);
		return phoneNumber;		
	}
	
//Change the phone number of people	
	public void changeEntry(String name, String number){
		if(Phone_hashMap.get(name)==null){
			System.out.println("Name not found.");
		}
		else{
			Phone_hashMap.put(name,number);
		}
	
	}

//Write into the same file
	public void write(){
		File fileObject = new File(location_File);
		Iterator iter = Phone_hashMap.entrySet().iterator();
		try{
			FileWriter fileWriting = new FileWriter(fileObject);
			BufferedWriter bufferWriting = new BufferedWriter (fileWriting);
			while(iter.hasNext()){
				HashMap.Entry pair = (HashMap.Entry)iter.next();
				bufferWriting.write(pair.getKey()+""+ pair.getValue());
				bufferWriting.newLine();
			}
		}
	catch(FileNotFoundException ex){
		System.out.println("File not found");
	}
	catch(IOException ex){
		System.out.println("File not found");
	}

}
}



