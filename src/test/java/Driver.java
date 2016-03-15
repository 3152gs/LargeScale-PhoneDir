
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		PhoneDirectory my_directory = new PhoneDirectory("/phoneDir/src/main/resources/PhoneDirectory.txt");
		my_directory.addEntry("Gauri","12345678"); //add an entry
		my_directory.addEntry("Gary","567800000"); //add an entry
		my_directory.getNumber("Gauri");      //add to the directory
		my_directory.changeEntry("Gauri", "2022129340");  //change the content of the directory
		my_directory.deleteEntry("Gary"); //delete an entry from directory
		}

}