/**
 * Created with IntelliJ IDEA.
 * User: chernyak
 * Date: 17.06.14
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class MathOp {
    public MathOp() {
    }

    public int fac(int a) {

        int n = a;
        int result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }
}
