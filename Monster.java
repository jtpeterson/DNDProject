/* TODO list
* Implement every type of stat
* Determine base skill ranks of a creature
* Determine new skill ranks of a creature if main 6 stats are adjusted
* Getters and Setters for every type of stat (ugh) This will be necessary for templates to work without overwriting the OG monster
* Note: Setters may be unnecessary, but should be created just in case they are needed down the line

*/

public class Monster {
	private int hp;
	private int ac;
	private String name;
	public Monster() {
		//do nothing, this is so everything compiles when MonsterMain is compiled.
	}
	public Monster(String name, int hp, int ac) {
		this.name = name.toLowerCase();
		this.hp = hp;
		this.ac = ac;
	}
	public String toString() {
		//System.out.printf("Name: \n" + name);
		//System.out.println("hp: " + hp);
		//System.out.println("ac: " + ac);
		String builder = "Name: " + name.toUpperCase() + "\nHP: " + hp + "\nAC: " + ac;
		//System.out.println(builder);
		return builder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAC() {
		return ac;
	}

	public void setAC(int ac) {
		this.ac = ac;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}


}