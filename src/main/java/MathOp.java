import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: chernyak
 * Date: 17.06.14
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class MathOp {
    static int a;
    private Scanner scanner;

    public MathOp() {

    }
    
    public void setScanner(Scanner scanner) {
    this.scanner = scanner;
    }

    public int fac() {

        System.out.println("Input n:");
        int result = 0;
        int n = scanner.nextInt();
        result = 1;

        for (int i = 2; i <= n; i++)
                result *= i;

        return result;

    }
}
