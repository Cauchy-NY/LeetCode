package Easy;

public class Question7 {
    public static int reverse(int x) {
        if(x == 0)
            return 0;
        boolean isMinus = false;
        if(x < 0) {
            x = -x;
            isMinus = true;
        }
        char[] reverse = Integer.toString(x).toCharArray();
        int point = reverse.length - 1;
        while(reverse[point] == '0')
            point--;
        StringBuilder sb = new StringBuilder();
        for(int i = point; i >= 0; i--)
            sb.append(reverse[i]);
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        if(isMinus)
            return -result;
        else
            return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(Integer.parseInt("-12"));
    }
}
