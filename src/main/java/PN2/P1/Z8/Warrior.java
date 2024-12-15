package PN2.P1.Z8;

public class Warrior extends Player {

    String armor;

    public Warrior(int hp, int level, String type, String weapon, String armor) {
        super(hp, level, type, weapon);
        this.armor = armor;
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
        b.append(armor);
        return b.toString();
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public boolean doDamage() {
        return true;
    }
}
