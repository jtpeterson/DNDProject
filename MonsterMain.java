/* File to run to start the Monster Directory.
* Created for readability purposes.
*/
import java.util.*;
import java.io.*;
public class MonsterMain {
	
	
	public static void main(String[] args) {
		try {
	     File file = new File("monsters.txt");
	     /*If file gets created then the createNewFile() 
	      * method would return true or if the file is 
	      * already present it would return false
	      */
             boolean fvar = file.createNewFile();
	     if (fvar){
	          System.out.println("File has been created successfully");
	     }
    	} catch (IOException e) {
    		System.out.println("Exception Occurred:");
	        e.printStackTrace();
	  }
	  MMController controller = new MMController();


		//for compilation purposes, can be removed in final version, maybe. no promises
		//If I ever get this into an .exe file or a gradle run
		Monster monster = new Monster();
		controller.mainInferface();
	}
}