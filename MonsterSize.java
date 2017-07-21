public enum MonsterSize {
	FINE(1), DIMINUTIVE(2), TINY(3), SMALL(4), MEDIUM(5), LARGE(6), HUGE(7), GARGANTUAN(8), COLOSSAL(9), COLOSSALPLUS(10);
	private int size;

	MonsterSize(int size) {
		this.size = size;
	}

	public int getValue() {
		return size;
	}

	public static MonsterSize fromInt(int i) {
        for (MonsterSize l: MonsterSize.values()) {
            if (l.getValue() == i) {
                return l;
            }
        }
        return null;
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

    public int getAttackACModifier() {
    	switch (size) {
        case 1:
            return (16);
        case 2:
            return (12);
        case 3:
            return (10);
        case 4:
            return (9);
        case 5:
        	return (8);
        case 6:
        	return (7);
        case 7:
        	return (6);
        case 8:
        	return (4);
        case 9:
        	return (0);
        case 10:
        	return (0);
        default:
            return (0);
    	}
	}

    public int getSpecialAttackModifier() {
    	switch (size) {
        case 1:
            return (0);
        case 2:
            return (4);
        case 3:
            return (8);
        case 4:
            return (12);
        case 5:
        	return (16);
        case 6:
        	return (20);
        case 7:
        	return (24);
        case 8:
        	return (28);
        case 9:
        	return (32);
        case 10:
        	return (32);
        default:
            return (0);
    	}
    }

    public int getHideModifier() {
    	switch (size) {
        case 1:
            return (32);
        case 2:
            return (28);
        case 3:
            return (24);
        case 4:
            return (20);
        case 5:
        	return (16);
        case 6:
        	return (12);
        case 7:
        	return (8);
        case 8:
        	return (4);
        case 9:
        	return (0);
        case 10:
        	return (0);
        default:
            return (0);
    	}
    }
}