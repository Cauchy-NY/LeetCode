package Medium;

public class Question319 {
    // 第 i 轮会隔 i 盏灯改变一下状态
    // 6 = 1 * 6 = 2 * 3，所以第六盏灯只会在第 1、2、3、6 轮被改变状态
    // 一个数的质因子数就是状态改变次数，灯一开始是黑的，要改变奇数次才会亮
    // 只有完全平方数的质因子是奇数个
    public int bulbSwitch(int n) {
        int count = 1;
        while (count * count <= n)
            count++;
        return --count;
    }
}
