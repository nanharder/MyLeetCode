package Add;

public class Problem43 {
    public String multiplyV1(String num1, String num2) {
        String target = num1.length() < num2.length() ? num1 : num2;
        StringBuilder sb = new StringBuilder(num1.length() < num2.length() ? num2 : num1);
        String res = "0";
        for (int i = target.length() - 1; i >= 0; i -= 1) {
            int num = target.charAt(i) - '0';
            for (int j = 0; j < num; j += 1) {
                res = addStrings(res, sb.toString());
            }
            sb.append(0);
        }
        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j -= 1;
            }
            if (i >=0 ) {
                sum += num1.charAt(i) - '0';
                i -= 1;
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String multiplyV2(String num1, String num2) {
        String n1 =new StringBuilder(num1).reverse().toString();
        String n2 =new StringBuilder(num2).reverse().toString();
        int m = n1.length();
        int n = n2.length();
        int[] res = new int[m + n];
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                res[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i += 1) {
            int sum = res[i] + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        sb = sb.reverse();
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem43 p = new Problem43();
        System.out.println(p.multiplyV2("23", "3"));
    }
}
