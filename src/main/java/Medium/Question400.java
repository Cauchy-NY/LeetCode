package Medium;

public class Question400 {
    public int findNthDigit(int n) {
        // 位数 9 90 900 9000...
        long numOfDigit = 0; // 目标位于numOfDigit位数
        long numCnt = 0;
        long digitCnt = 0;
        while (digitCnt < n) {
            numCnt += Math.pow(10, numOfDigit) * 9;
            digitCnt += Math.pow(10, numOfDigit) * 9 * (numOfDigit + 1);
            numOfDigit++;
        }
        numCnt -= Math.pow(10, numOfDigit - 1) * 9;
        // 目标位于n位数字的第seq位
        long seq = (long) (n - digitCnt + Math.pow(10, numOfDigit - 1) * 9 * (numOfDigit));
        // num-数字，seqOfNum-数字的第几位
        long num = (seq - 1) / numOfDigit + numCnt + 1;
        long seqOfNum = (seq - 1) % numOfDigit;
        return String.valueOf(num).charAt((int) seqOfNum) - '0';
    }

    public static void main(String[] args) {
        Question400 question = new Question400();
        System.out.println(question.findNthDigit(3));
        System.out.println(question.findNthDigit(11));
        System.out.println(question.findNthDigit(189));
        System.out.println(question.findNthDigit(190));
        System.out.println(question.findNthDigit(1000000000));
    }
}
