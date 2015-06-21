package jp.skypencil.algorithm;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

enum CombinationStrategy {
    DEFAULT {
        @Override
        Stream<int[]> generateStream(int n, int m) {
            return Stream
                    .iterate((1L << m) - 1L, new LongCombinationOperator())
                    .map(new LongToIntArray(m));
        }

        class LongCombinationOperator implements UnaryOperator<Long> {
            @Override
            public Long apply(Long previous) {
                Objects.nonNull(previous);

                long param1 = smallestBitOf(previous);
                long param2 = param1 + previous;
                long param3 = smallestBitOf(param2);
                long param5 = (param3 / param1) >>> 1;
                return param5 - 1 + param2;
            }

            long smallestBitOf(long source) {
                long result = 1L;
                while (source % 2 == 0) {
                    source >>>= 1;
                    result <<= 1;
                }
                return result;
            }
        }
    },
    BIG_INTEGER {
        @Override
        Stream<int[]> generateStream(int n, int m) {
            return Stream.iterate(ONE.shiftLeft(m).subtract(ONE),
                    new BigIntegerCombinationOperator())
                    .map(new BigIntegerToIntArray(m));
        }

        class BigIntegerCombinationOperator implements UnaryOperator<BigInteger> {
            @Override
            public BigInteger apply(BigInteger previous) {
                Objects.nonNull(previous);

                BigInteger param1 = smallestBitOf(previous);
                BigInteger param2 = param1.add(previous);
                BigInteger param3 = smallestBitOf(param2);
                BigInteger param5 = param3.divide(param1).shiftRight(1);
                return param5.subtract(ONE).add(param2);
            }

            BigInteger smallestBitOf(BigInteger source) {
                return ONE.shiftLeft(source.getLowestSetBit());
            }
        }
    };

    private static final int MAX_N = 62;

    abstract Stream<int[]> generateStream(int n, int m);

    static CombinationStrategy selectFor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else if (n <= MAX_N) {
            return DEFAULT;
        } else {
            return BIG_INTEGER;
        }
    }
}
