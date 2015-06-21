package jp.skypencil.algorithm;
import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(long number) {
        BigInteger result = BigInteger.ONE;
        while (1 < number) {
            result = result.multiply(BigInteger.valueOf(number));
            --number;
        }
        return result;
    }
}
