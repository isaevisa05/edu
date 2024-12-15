public class Mage {
    String name, type;
    int level, damage;

    public Mage(String name, int level, int damage, String type) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.type = type;
    }

    String getInfo() {
        String s = ", ";
        return name + s + level + s + damage + s + type;
    }

    String fight(Mage mage) {
        if(mage.type.equals(type)) {
            if(mage.level == level) return "draw";
            if(mage.level > level) {
                return mage.name;
            } else {
                return name;
            }
        }
        switch (mage.type) {
            case "fire":
                if(type.equals("ice")) return mage.name;
                else return name;
            case "ice":
                if(type.equals("earth")) return mage.name;
                else return name;
            case "earth":
                if(type.equals("fire")) return mage.name;
                else return name;
            default:
                return null;
        }
    }
}