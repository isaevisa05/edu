public class Programmer {
    String name, company;
    String position = "intern";

    public Programmer(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void work() {
        switch (position) {
            case "intern":
                this.position = "junior";
                return;
            case "junior":
                this.position = "middle";
                return;
            case "middle":
                this.position = "senior";
                return;
            case "senior":
                this.position = "lead";
                return;
            default:
                return;
        }
    }
}
