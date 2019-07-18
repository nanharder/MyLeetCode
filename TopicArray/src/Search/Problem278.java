package Search;

public class Problem278 {
    public int firstBadVersion(int n) {
        int upperbound = n;
        int lowerbound = 1;
        while (upperbound > lowerbound) {
            int divide = (upperbound - lowerbound) / 2 + lowerbound;
            if (isBadVersion(divide)) {
                upperbound = divide;
            } else {
                lowerbound = divide + 1;
            }
        }
        return lowerbound;
    }

    /**
     * my simple test method
     */
    private boolean isBadVersion(int version) {
        return (version >= 4);
    }

    public static void main(String[] args) {
        Problem278 p = new Problem278();
        System.out.println(p.firstBadVersion(5));
    }
}
