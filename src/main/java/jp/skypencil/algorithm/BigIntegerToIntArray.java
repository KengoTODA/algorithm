package jp.skypencil.algorithm;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Function;

class BigIntegerToIntArray implements Function<BigInteger, int[]> {
    private final int arrayLength;

    BigIntegerToIntArray(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    @Override
    public int[] apply(BigInteger bigInteger) {
        Objects.nonNull(bigInteger);
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            result[i] = bigInteger.getLowestSetBit();
            bigInteger = bigInteger.clearBit(result[i]);
        }
        return result;
    }
}
