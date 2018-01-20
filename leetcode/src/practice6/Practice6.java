package practice6;

/**
 * n=numRows
 * Δ=2n-2    1                           2n-1                         4n-3
 * Δ=        2                     2n-2  2n                    4n-4   4n-2
 * Δ=        3               2n-3        2n+1              4n-5       .
 * Δ=        .           .               .               .            .
 * Δ=        .       n+2                 .           3n               .
 * Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
 * Δ=2n-2    n                           3n-2                         5n-4
 *
 * @author Jeffrey
 * @since 2017/12/18 10:17
 */
public class Practice6 {

    // 经典,观察问题的本质
    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
            {
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
            {
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "1234";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
