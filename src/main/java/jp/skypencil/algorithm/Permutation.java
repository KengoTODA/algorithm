package jp.skypencil.algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @see http://topcoder.g.hatena.ne.jp/eller/20090831/1251723649
 */
public final class Permutation {
    private final int size;

    public Permutation(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        this.size = size;
    }

    public Stream<int[]> stream() {
        final long count = count();
        final int[] seed = generateSeed(size);
        return Stream.iterate(seed, new PermutationOperator()).limit(count);
    }

    public Iterator<int[]> iterator() {
        return stream().iterator();
    }

    public long count() {
        return Factorial.factorial(size).longValueExact();
    }

    private static int[] generateSeed(int size) {
        int[] seed = new int[size];
        for (int i = 0; i < size; ++i) {
            seed[i] = i;
        }
        return seed;
    }

    private static class PermutationOperator implements UnaryOperator<int[]> {
        @Override
        public int[] apply(int[] previous) {
            final int length = previous.length;
            final int[] next = Arrays.copyOf(previous, length);
            for (int i = length - 1; i > 0; i--) {
                if (next[i - 1] < next[i]) {
                    int j = length;
                    while (next[i - 1] >= next[--j]);
                    swap(next, i - 1, j);
                    reverse(next, i, length);
                    return next;
                }
            }

            throw new IllegalArgumentException();
        }

        private void swap(int[] array, int index, int anotherIndex) {
            int t = array[index];
            array[index] = array[anotherIndex];
            array[anotherIndex] = t;
        }

        private void reverse(int[] array, int start, int end) {
            while (start < --end) swap(array, start++, end);
        }
    }
}
