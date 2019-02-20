package Medium;

public class Question201 {
    /**
     * 这个想法太nb了，自己的想法只停留在怎么找到不为零的位，菜的真实
     * last bit of (odd number & even number) is 0.
     * when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
     * Move m and n rigth a position.
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m <<= count;
    }
}
