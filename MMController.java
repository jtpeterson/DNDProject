import java.util.*;
import java.io.*;

/* TODO List
* Implement Weapon Templates
* List Monsters by size
* Implement Monster Searching
* Implement Monster Template Searching
* Implement Class Template Searching
* Implement Applying a monster template to a monster
* Implement Applying a class template to a monster
* Implement Adding a new monster
* Implement Adding a feat to a monster
* Implement Removing a monster
* Implement Creating the MonsterManual from a file
* Implement Writing to a file for persistence
* Implement Scraping the Web for Monster Stats
* Implement multi-user functionality
* Implement a UI via Javafx
* Create an .exe to run the program


*/
public class MMController {
	
	Scanner scan = new Scanner(System.in);
	List<Monster> monsterList = new ArrayList<Monster>();
	

	Hashtable<String, Monster> monsterManual = new Hashtable<String, Monster>();
	private String control;
	private ArrayList<Monster> monsters;

	public MMController() {
		control = "";
	}
	public MMController(ArrayList<Monster> monsters) {
		this.monsters = monsters;
		for (Monster mon: monsters) {
			monsterManual.put(mon.getName(), mon);
		}
	}

	public void setcontrol(String s) {
		control = s;
	}

	public String getcontrol() {
		return control;
	}

	public void mainInferface() {
		this.setcontrol("Main");
		//System.out.println(monsterManual.toString());
		System.out.println("Initializing Monster Database...");
		boolean cont = true;
		while(cont) {
			System.out.println("");
			System.out.println("1) Find a Monster.");
			System.out.println("2) Find a Monster Template.");
			System.out.println("3) Find a Class Template.");
			System.out.println("4) Find a Size Template.");
			System.out.println("Please Enter a Command.");
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				break;
			} else if(command.equalsIgnoreCase("help")) {
				System.out.println("");
				System.out.println("Current Working Commands: ");
				System.out.println("quit/q - quits the program");
				System.out.println("1-3 - Key commands to access the system.");
			} else if (command.equalsIgnoreCase("1")) {
				System.out.println("");
				System.out.println("Opening Monsters...");
				cont = this.findMonster();
			} else if (command.equalsIgnoreCase("2")) {
				System.out.println("");
				System.out.println("Opening Monster Templates...");
				cont = this.monsterTemplates();
			} else if (command.equalsIgnoreCase("3")) {
				System.out.println("");
				System.out.println("Opening Class Templates...");
				cont = this.classTemplates();
			} else if (command.equalsIgnoreCase("4")) {
				System.out.println("Opening Size Templates...");
				cont = this.sizeTemplates();
			}
			else {
				System.out.println("");
				System.out.println("Invalid Input. Please Enter a valid command.");
				System.out.println("Type \'help\' for a list of valid commands.");
			}

		}


		System.out.println("Exiting Monster Database...");
		System.out.println("Thank you for using the Database. Goodbye!");

	}


	public boolean findMonster() {
		this.setcontrol("Monster Search");
		boolean search = true;
		while(search) {
			System.out.println("");
			System.out.println("1) Print out a list of available monsters.");
			System.out.println("2) Print Monsters by Size");
			System.out.println("3) Print Monsters by Type");
			System.out.println("");
			System.out.println("Please enter the name of the monster you are looking for.");
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("return")) {
				System.out.println("Returning to Main Menu...");
				System.out.println("");
				search = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				search = false;
				return false;
			} else if (command.equalsIgnoreCase("1")) {
				System.out.println("");
				//for (Monster monster: monsterList) {
				//	System.out.print(monster.getName().toUpperCase() + " ");
				//}
				for(Object key: monsterManual.keySet().toArray()) {
					System.out.println(key);
				}
				System.out.println("");
			} else if (command.equalsIgnoreCase("help")) {
				System.out.println("");
				System.out.println("Current Working Commands: ");
				System.out.println("quit/q - quits the program");
				System.out.println("return - returns to main menu.");
				System.out.println("1 - Lists the monsters in the database.");
				System.out.println("");
			} else if (command.equalsIgnoreCase("2")) {
				System.out.println("Printing Monsters by size...");
				//TODO with a 2D list 
			}
			else {
				System.out.println("Searching Monsters...");
				System.out.println("");
				command = command.toLowerCase();
				if (monsterManual.containsKey(command)) {
					System.out.println("Monster Found!");
					System.out.println("Outputting Monster...");
					search = this.foundMonster(monsterManual.get(command));
				} else {
					System.out.println("You entered: " + command);
					System.out.println("Monster not found. Please enter a valid monster.");
				}

			}
		}
		return false;

	}

	public boolean foundMonster(Monster monster) {
		boolean cont = true;
		while (cont) {
			System.out.println(monster);
			System.out.println("");
			System.out.println("1) Apply a Monster Template");
			System.out.println("2) Apply a Class Template");
			System.out.println("3) Slightly randomize stats");
			System.out.println("4) Tweak Stats");
			System.out.println("5) Change Size of Monster");
			System.out.println("");
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("return")) {
				System.out.println("");
				System.out.println("Returning to Monster Search...");
				System.out.println("");
				cont = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				cont = false;
				return false;
			} else if (command.equalsIgnoreCase("help")) {
				System.out.println("");
				System.out.println("Current Working Commands: ");
				System.out.println("quit/q - quits the program");
				System.out.println("return - returns to main menu.");
				System.out.println("1-5 - Key commands to adjust the monster. Changes in this form will not alter the original monster.");
				System.out.println("Just the users view of it.");
				System.out.println("");
			} else if (command.equalsIgnoreCase("1")) {
				System.out.println("Opening Monster Templates...");
				cont = this.applyMonTempToMon(monster);
			} else if (command.equalsIgnoreCase("2")) {
				System.out.println("Opening Class Templates...");
				cont = this.applyClassTempToMon(monster);
			} else if (command.equalsIgnoreCase("3")) {
				System.out.println("Randomizing Monster Stats");
				System.out.println("This will randomize the core 6 (+/-2), AC, HP, and SR(+/-2)(If applicable).");
				cont = this.randomizeMonster(monster);
			} else if (command.equalsIgnoreCase("4")) {
				System.out.println("Allowing for stat tweaking...");
				cont = this.tweakStats(monster);
			} else if (command.equalsIgnoreCase("5")) {
				System.out.println("Changing Monster Size...");
				cont = this.changeSize(monster);
			}
			else {
				//TODO
				System.out.println("Invalid entry.");
			} 
		}

		return false;
	}

	public boolean applyMonTempToMon(Monster monster) {
		//TODO
		System.out.println("Not yet implemented.");
		System.out.println("Closing Database");
		return false;
	}

	public boolean applyClassTempToMon(Monster monster) {
		//TODO
		System.out.println("Not yet implemented.");
		System.out.println("Closing Database");
		return false;
	}

	public boolean randomizeMonster(Monster monster) {
		//TODO
		System.out.println("Not yet implemented.");
		System.out.println("Closing Database");
		return false;
	}

	public boolean tweakStats(Monster monster) {
		//TODO
		System.out.println("Not yet implemented.");
		System.out.println("Closing Database");
		return false;
	}

	public boolean changeSize(Monster monster) {
		//TODO
		this.setcontrol("Size change");
		boolean search = true;
		while(search) { 
			//still need to implement weapon steps
			System.out.println("");
			System.out.println("Enter the number of size categories you would like to increase/decrease.");
			System.out.println("A negative number will lower the size, a positive number will increase the size.");
			System.out.println("");
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("return")) {
				System.out.println("");
				System.out.println("Returning to Monster...");
				System.out.println("");
				search = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				search = false;
				return false;
			} else if (command.equalsIgnoreCase("help")) {
				System.out.println("");
				System.out.println("Current Working Commands: ");
				System.out.println("quit/q - quits the program");
				System.out.println("return - returns to main menu.");
				System.out.println("-9-0/1-9 Number of steps up or down for the size category. Size category will not go above 10 or below 1.");
				System.out.println("");
			} else if (command.matches("-?[1-9]\\d*|0")) {
				try {
					int input = Integer.parseInt(command);
				} catch(NumberFormatException e) {
					System.out.println("");
					System.out.println("Invalid command. Type \"help\" for a list of valid commands"); 
				}
				int input = Integer.parseInt(command);
				if (input > 0) {
					if (input + monster.getSize().getValue() > 10) {
						input = 10 - monster.getSize().getValue();
					}
					System.out.println("Increasing size of monster by " + input + " steps...");
					int updatedSize = monster.getSize().getValue() + input;
					monster.setSize(monster.getSize().fromInt(updatedSize));
				} else if (input < 0) {
					if (input + monster.getSize().getValue() < 1) {
						input = 9 - monster.getSize().getValue();
					}
					int updatedSize = monster.getSize().getValue() + input;
					monster.setSize(monster.getSize().fromInt(updatedSize));
					input = Math.abs(input);
					System.out.println("Decreasing size of monster by " + input + " steps...");
				} else {
					System.out.println("Not changing monster size at all. Returning to Monster...");
				}
				return true;
				
			} else {
				System.out.println("Invalid entry");
			}

		}
		return false;
	}

	public boolean changeWeaponSize(Monster monster, int sizeChange) {
		ArrayList<ArrayList<String>> weaponStepper = new ArrayList<ArrayList<String>>();
		ArrayList<String> shuriken = new ArrayList<String>();
		shuriken.add("-");
		shuriken.add("-");
		shuriken.add("-");
		shuriken.add("1");
		shuriken.add("1d2");
		shuriken.add("1d3");
		shuriken.add("1d4");
		shuriken.add("1d6");
		shuriken.add("1d8");
		weaponStepper.add(shuriken);
		ArrayList<String> gauntlet = new ArrayList<String>();
		gauntlet.add("-");
		gauntlet.add("-");
		gauntlet.add("1");
		gauntlet.add("1d2");
		gauntlet.add("1d3");
		gauntlet.add("1d4");
		gauntlet.add("1d6");
		gauntlet.add("1d8");
		gauntlet.add("2d6");
		weaponStepper.add(gauntlet);
		ArrayList<String> dagger = new ArrayList<String>();
		dagger.add("-");
		dagger.add("1");
		dagger.add("1d2");
		dagger.add("1d3");
		dagger.add("1d4");
		dagger.add("1d6");
		dagger.add("1d8");
		dagger.add("2d6");
		dagger.add("3d6");
		weaponStepper.add(dagger);
		ArrayList<String> shortspear = new ArrayList<String>();
		shortspear.add("1");
		shortspear.add("1d2");
		shortspear.add("1d3");
		shortspear.add("1d4");
		shortspear.add("1d6");
		shortspear.add("1d8");
		shortspear.add("2d6");
		shortspear.add("3d6");
		shortspear.add("4d6");
		weaponStepper.add(shortspear);
		ArrayList<String> falchion = new ArrayList<String>();
		falchion.add("1d2");
		falchion.add("1d3");
		falchion.add("1d4");
		falchion.add("1d6");
		falchion.add("2d4");
		falchion.add("2d6");
		falchion.add("3d6");
		falchion.add("4d6");
		falchion.add("6d6");
		weaponStepper.add(falchion);
		ArrayList<String> longsword = new ArrayList<String>();
		longsword.add("1d2");
		longsword.add("1d3");
		longsword.add("1d4");
		longsword.add("1d6");
		longsword.add("1d8");
		longsword.add("2d6");
		longsword.add("3d6");
		longsword.add("4d6");
		longsword.add("6d6");
		weaponStepper.add(longsword);
		ArrayList<String> bastardSword = new ArrayList<String>();
		bastardSword.add("1d3");
		bastardSword.add("1d4");
		bastardSword.add("1d6");
		bastardSword.add("1d8");
		bastardSword.add("1d10");
		bastardSword.add("2d8");
		bastardSword.add("3d8");
		bastardSword.add("4d8");
		bastardSword.add("6d8");
		weaponStepper.add(bastardSword);
		ArrayList<String> greataxe = new ArrayList<String>();
		greataxe.add("1d4");
		greataxe.add("1d6");
		greataxe.add("1d8");
		greataxe.add("1d10");
		greataxe.add("1d12");
		greataxe.add("3d6");
		greataxe.add("4d6");
		greataxe.add("6d6");
		greataxe.add("8d6");
		weaponStepper.add(greataxe);
		ArrayList<String> greatsword = new ArrayList<String>();
		greatsword.add("1d4");
		greatsword.add("1d6");
		greatsword.add("1d8");
		greatsword.add("1d10");
		greatsword.add("2d6");
		greatsword.add("3d6");
		greatsword.add("4d6");
		greatsword.add("6d6");
		greatsword.add("8d6");
		weaponStepper.add(greatsword);
		/*int weaponSizeIndex = monster.getSize().getValue() - 1;
		String weapon = 
		for(ArrayList<String> weapon: weaponStepper) {
			if(weapon.get(weaponSizeIndex).equalsIgnoreCase()) {

			}
		}*/
		return true;
	}

	public boolean monsterTemplates() {
		//TODO
		this.setcontrol("Monster Templates");
		System.out.println("Yet to be implemented.");
		boolean search = true;
		while(search) {
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("return")) {
				System.out.println("Returning to Main Menu...");
				System.out.println("");
				search = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				search = false;
				return false;
			}
			return true;
		}
		return false;
	}

	public boolean classTemplates() {
		//TODO
		this.setcontrol("Class Templates");
		boolean search = true;
		while(search) {
			String command = scan.nextLine();
			if (command.equalsIgnoreCase("return")) {
				System.out.println("Returning to Main Menu...");
				System.out.println("");
				search = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				search = false;
				return false;
			}
		}
		return false;
	}

	public boolean sizeTemplates() {
        boolean cont = true;
        while(cont) {
        	for (MonsterSize l: MonsterSize.values()) {
				System.out.println(l);
        	}
        	System.out.println("");
        	System.out.println("Enter the name of a template.");
        	System.out.println("");
        	String command = scan.nextLine();
        	if (command.equalsIgnoreCase("return")) {
				System.out.println("Returning to Main Menu...");
				System.out.println("");
				cont = false;
				return true;
			} else if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q")) {
				cont = false;
				return false;
			} else if (command.equalsIgnoreCase("help")) {
				System.out.println("Current Working Commands: ");
				System.out.println("quit/q - quits the program");
				System.out.println("return - returns to main menu.");
				System.out.println("Enter the name of a template to view the template");
				System.out.println("");
			} else {
				MonsterSize mSize = null;
				for (MonsterSize l: MonsterSize.values()) {
					if (l.toString().equalsIgnoreCase(command)) {
						mSize = l;
					}
				}
				if (mSize == null) {
					System.out.println("Invalid entry.");
				} else {
					System.out.println("");
					System.out.println("Attack and AC Modifier: " + (mSize.getAttackACModifier() - 8));
					System.out.println("Special Attack Modifier: " + (mSize.getSpecialAttackModifier() - 16));
					System.out.println("Hide Modifier: " + (mSize.getHideModifier() - 16));
					System.out.println("");
				}
			}
        }
		return true;
	}
}