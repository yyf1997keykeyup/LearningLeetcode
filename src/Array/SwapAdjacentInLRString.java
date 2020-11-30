package Array;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (start.charAt(i) == 'X') count++;
            if (end.charAt(i) == 'X') count--;
        }
        if (count != 0) return false;

        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            if (i == n || j == n)
                return i == n && j == n;

            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}
