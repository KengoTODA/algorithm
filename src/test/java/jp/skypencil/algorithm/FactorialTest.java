package jp.skypencil.algorithm;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FactorialTest {
    @Test
    public void test() {
        assertThat(Factorial.factorial(0).intValue(), is(1));
        assertThat(Factorial.factorial(1).intValue(), is(1));
        assertThat(Factorial.factorial(2).intValue(), is(2));
        assertThat(Factorial.factorial(3).intValue(), is(6));
        assertThat(Factorial.factorial(10).intValue(), is(3628800));
    }
}
