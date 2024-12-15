package PN2.P1.Z8;

public class Wizard extends Player {

    int manaLevel;
    String element;

    public Wizard(int hp, int level, String type, String weapon, int manaLevel, String element) {
        super(hp, level, type, weapon);
        this.manaLevel = manaLevel;
        this.element = element;
    }

    @Override
    public String getFullInfo() {
        char p = ' ';
        StringBuilder b = new StringBuilder();
        b.append(hp);
        b.append(p);
        b.append(level);
        b.append(p);
        b.append(type);
        b.append(p);
        b.append(weapon);
        b.append(p);
        b.append(manaLevel);
        b.append(p);
        b.append(element);
        return b.toString();
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public boolean doDamage() {
        if(manaLevel >= 10) {
            manaLevel = manaLevel - 10;
            return true;
        }
        return false;
    }
}
