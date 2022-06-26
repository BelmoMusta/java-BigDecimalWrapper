package org.mustabelmo.bigdecimalwrapper.tests;

import org.junit.Assert;
import org.junit.Test;
import org.mustabelmo.bigdecimalwrapper.BigDecimalWrapper;

import java.math.BigDecimal;

public class TestEquals {
    @Test
    public void testEquality() {
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper(12);
        BigDecimalWrapper bigDecimalWrapper2 = new BigDecimalWrapper(13);
        Assert.assertNotEquals(bigDecimalWrapper2, (bigDecimalWrapper));
        Assert.assertNotEquals(bigDecimalWrapper2, (null));
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.ONE.add(BigDecimal.ONE)));

    }
}
