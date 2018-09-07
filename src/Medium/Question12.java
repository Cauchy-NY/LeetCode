package Medium;

public class Question12 {
    public String intToRoman(int num) {
        int[] ints = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num>0){
            if(num-ints[index]>=0){
                num-=ints[index];
                sb.append(romans[index]);
            }
            else
                index++;
        }
        return sb.toString();
    }
}
