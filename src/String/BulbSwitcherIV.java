package String;

public class BulbSwitcherIV {
    public int minFlips(String target) {
        int n = target.length();
        int count = 0;
        char status = '0';
        for (int i = 0; i < n; i++) {
            if (status != target.charAt(i)) {
                count++;
            }
            status = count % 2 == 1 ? '1' : '0';
        }
        return count;
    }
}
