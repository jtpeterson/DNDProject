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
	  	ArrayList<Monster> monsters = new ArrayList();
	  	Hashtable<String, String> testDevilSpecAbils = new Hashtable<String, String>();
		ArrayList<String> testDevilFeats = new ArrayList<String>();
		Monster beardedDevil = new Monster(MonsterSize.MEDIUM, 45, 19, 15, 15, 17, 6, 10, 10, 6, 8, 7, 5, "Bearded Devil", 6, 8, "A lawful evil-aligned plane", "Solitary, pair, team (3-5), or squad (6-10)", 5, "Always lawful evil", "At will— greater teleport (self plus 50 pounds of objects only). Caster level 12th.", "Standard", "	7–9 HD (Medium); 10–18 HD (Large)", 6, "Every bearded devil carries a sawtoothed glaive. A bearded devil stands 6 feet tall and weighs about 225 pounds.", "Bearded devils are aggressive and love to fight. They revel in their battle frenzy, spreading mayhem among their foes. A bearded devil’s natural weapons, as well as any weapons it wields, are treated as evil-aligned and lawful-aligned for the purpose of overcoming damage reduction.", testDevilSpecAbils, testDevilFeats, "Outsider (Devil, Extraplanar, Evil, Lawful)");
	  	monsters.add(beardedDevil);
	  	MMController controller = new MMController(monsters);


		//for compilation purposes, can be removed in final version, maybe. no promises
		//If I ever get this into an .exe file or a gradle run
		Monster monster = new Monster();
		controller.mainInferface();
	}
}