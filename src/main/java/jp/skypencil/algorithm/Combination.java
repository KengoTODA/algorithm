package jp.skypencil.algorithm;

import static jp.skypencil.algorithm.Factorial.factorial;

import java.util.stream.Stream;

/**
 * @see http://topcoder.g.hatena.ne.jp/eller/20090929/1254228452
 * @see http://www2.econ.osaka-u.ac.jp/~tanizaki/class/combinat/combinat.htm
 */
public final class Combination {
    private final int n;
    private final int m;

    public Combination(int n, int m) {
        if (n <= 0 || m <= 0 || n < m) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        this.m = m;
    }

    public Stream<int[]> stream() {
        long count = count();
        return CombinationStrategy
                .selectFor(n)
                .generateStream(n, m)
                .limit(count);
    }

    public long count() {
        return factorial(n).divide(factorial(m)).divide(factorial(n - m)).longValueExact();
    }

}
