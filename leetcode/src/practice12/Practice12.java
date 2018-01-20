package practice12;

/**
 * 12. Integer to Roman
 *
 * @author Jeffrey
 * @since 2018/01/03 10:48
 */
public class Practice12 {

    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
            if (num == 0){
                break;
            }
        }
        return sb.toString();
    }
}
