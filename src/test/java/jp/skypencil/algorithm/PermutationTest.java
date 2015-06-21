package jp.skypencil.algorithm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PermutationTest {

    @Test
    public void testPermutationFor1() {
        List<int[]> result = new Permutation(1).stream().collect(Collectors.toList());
        assertThat(result.size(), is(1));
        assertThat(result.get(0), is(equalTo(new int[]{0})));
    }

    @Test
    public void testPermutationFor2() {
        List<int[]> result = new Permutation(2).stream().collect(Collectors.toList());
        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(equalTo(new int[]{0, 1})));
        assertThat(result.get(1), is(equalTo(new int[]{1, 0})));
    }

    @Test
    public void testPermutationFor3() {
        List<int[]> result = new Permutation(3).stream().collect(Collectors.toList());
        assertThat(result.size(), is(6));
        assertThat(result.get(0), is(equalTo(new int[]{0, 1, 2})));
        assertThat(result.get(1), is(equalTo(new int[]{0, 2, 1})));
        assertThat(result.get(2), is(equalTo(new int[]{1, 0, 2})));
        assertThat(result.get(3), is(equalTo(new int[]{1, 2, 0})));
        assertThat(result.get(4), is(equalTo(new int[]{2, 0, 1})));
        assertThat(result.get(5), is(equalTo(new int[]{2, 1, 0})));
    }

}
