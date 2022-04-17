package org.mustabelmo.bigdecimalwrapper.tests;

import org.junit.Test;

import java.math.BigDecimal;

public class TestCompareTo {
    @Test
    public void testEquality() {

        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.ONE.add(BigDecimal.ONE)));

    }
}
