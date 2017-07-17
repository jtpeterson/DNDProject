public enum MonsterSize {
	FINE(1), DIMINUTIVE(2), TINY(3), SMALL(4), MEDIUM(5), LARGE(6), HUGE(7), GARGANTUAN(8), COLOSSAL(9), COLOSSALPLUS(10);
	private final int size;

	MonsterSize(int size) {
		this.size = size;
	}

	public int getValue() {
		return size;
	}

	public String toString() {
        switch (size) {
        case 1:
            return ("Fine");
        case 2:
            return ("Diminutive");
        case 3:
            return ("Tiny");
        case 4:
            return ("Small");
        case 5:
        	return ("Medium");
        case 6:
        	return ("Large");
        case 7:
        	return ("Huge");
        case 8:
        	return ("Gargantuan");
        case 9:
        	return ("Colossal");
        case 10:
        	return ("Colossal+");
        default:
            return ("hacker");
        }
    }
}