package jp.skypencil.algorithm;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CombinationTest {

    @Test
    public void testCount() {
        assertThat(new Combination(63, 1).count(), is(63L));
        assertThat(new Combination(10, 1).count(), is(10L));
        assertThat(new Combination(3, 2).count(), is(3L));
    }

    @Test
    public void testCombination1of3() {
        List<int[]> combinations = new Combination(3, 1).stream()
                .collect(Collectors.toList());

        assertArrayEquals(combinations.get(0), new int[]{0});
        assertArrayEquals(combinations.get(1), new int[]{1});
        assertArrayEquals(combinations.get(2), new int[]{2});
    }

    @Test
    public void testCombination2of3() {
        List<int[]> combinations = new Combination(3, 2).stream()
                .collect(Collectors.toList());

        assertArrayEquals(combinations.get(0), new int[]{0,1});
        assertArrayEquals(combinations.get(1), new int[]{0,2});
        assertArrayEquals(combinations.get(2), new int[]{1,2});
    }

    @Test
    public void testCombination1of63() {
        List<int[]> combinations = new Combination(63, 1).stream()
                .collect(Collectors.toList());

        for (int i = 0; i < 63; ++i) {
            assertArrayEquals(combinations.get(i), new int[]{i});
        }
    }
}
