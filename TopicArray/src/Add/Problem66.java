package Add;

/**
 * plus one
 */
public class Problem66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = digits.length - 1; i >= 0; i -= 1) {
            digits[i] += 1;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length; i += 1) {
            result[i] = 0;
        }
        return result;
    }
}
