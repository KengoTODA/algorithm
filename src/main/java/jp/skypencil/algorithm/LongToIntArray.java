package jp.skypencil.algorithm;

import java.util.Objects;
import java.util.function.Function;

class LongToIntArray implements Function<Long, int[]> {
    private final int arrayLength;

    LongToIntArray(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    @Override
    public int[] apply(Long boxed) {
        Objects.nonNull(boxed);
        long longValue = boxed.longValue();
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            result[i] = indexOfSmallestBitOf(longValue);
            longValue ^= 1 << result[i];
        }
        return result;
    }

    private int indexOfSmallestBitOf(long source) {
        int result = 0;
        while (source % 2 == 0) {
            source >>>= 1;
            result++;
        }
        return result;
    }
}
