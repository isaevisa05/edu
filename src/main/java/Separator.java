import java.util.ArrayList;

public class Separator {

    int[] array;

    public Separator(int[] array) {
        this.array = array;
    }

    public int[] even() {
        int k = 0, l = 0;
        for (int r : array) {
            if(r % 2 == 0) k++;
        }

        int[] r = new int[k];

        for (int rr : array) {
            if(rr % 2 != 0) continue;
            r[l] = rr;
            l++;
        }

        return r;
    }

    public int[] odd() {
        int k = 0, l = 0;
        for (int r : array) {
            if(r % 2 != 0) k++;
        }

        int[] r = new int[k];

        for (int rr : array) {
            if(rr % 2 == 0) continue;
            r[l] = rr;
            l++;
        }

        return r;
    }

    public int[] evenR() {
        ArrayList<Integer> r = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) continue;
            r.add(i);
        }
        return r.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] oddR() {
        ArrayList<Integer> r = new ArrayList<>();
        for (int i : array) {
            if (i % 2 != 0) continue;
            r.add(i);
        }
        return r.stream().mapToInt(Integer::intValue).toArray();
    }
}
