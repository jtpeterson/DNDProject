/* File to run to start the Monster Directory.
* Created for readability purposes.
*/
import java.util.*;
public class MonsterMain {
	
	
	public static void main(String[] args) {
		MMController controller = new MMController();

		//for compilation purposes, can be removed in final version, maybe. no promises
		//If I ever get this into an .exe file or a gradle run
		Monster monster = new Monster();
		controller.mainInferface();
	}
}