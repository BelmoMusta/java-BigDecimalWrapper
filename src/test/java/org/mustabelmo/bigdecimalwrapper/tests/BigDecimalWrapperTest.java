package org.mustabelmo.bigdecimalwrapper.tests;

import org.junit.Assert;
import org.junit.Test;
import org.mustabelmo.bigdecimalwrapper.BigDecimalWrapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class BigDecimalWrapperTest {
    @Test
    public void testEquality() {
        BigDecimalWrapper wrapper = new BigDecimalWrapper(112.33);
        BigDecimalWrapper wrapper2 = new BigDecimalWrapper(112.330);
        Assert.assertEquals(wrapper, wrapper2);
    }

    @Test
    public void testEqualityTautology() {
        BigDecimalWrapper wrapper = new BigDecimalWrapper(112.33);
        Assert.assertEquals(wrapper, wrapper);
    }

    @Test
    public void testEqualityOtherInstance() {
        BigDecimalWrapper wrapper = new BigDecimalWrapper(112.33);
        Assert.assertNotEquals(wrapper, "wrapper");
    }

    @Test
    public void testEqualityIfNull() {
        BigDecimalWrapper wrapper = null;
        BigDecimalWrapper wrapper2 = new BigDecimalWrapper(112.330);
        Assert.assertNotEquals(wrapper, wrapper2);
    }

    @Test
    public void testEqualityAsStrings() {
        BigDecimalWrapper zeroString = new BigDecimalWrapper("0");
        BigDecimalWrapper oldZero = new BigDecimalWrapper(BigDecimal.ZERO);
        Assert.assertEquals(zeroString, oldZero);
    }


    @Test
    public void testHashCode() {
        BigDecimal bigDecimal = new BigDecimal(114);
        BigDecimalWrapper wrapper = new BigDecimalWrapper(bigDecimal);
        Assert.assertEquals(Objects.hash(bigDecimal), wrapper.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "55.6";
        BigDecimalWrapper wrapper = new BigDecimalWrapper("55.6");
        Assert.assertEquals(expected, wrapper.toString());
    }

    @Test
    public void testToCurrencyFormat() {
        BigDecimal bigDecimal = new BigDecimal("33.49");
        BigDecimalWrapper wrapper = new BigDecimalWrapper(bigDecimal);
        String expected = NumberFormat.getCurrencyInstance().format(bigDecimal);
        Assert.assertEquals(expected, wrapper.toCurrencyFormat());
    }

    @Test
    public void testToCurrencyFormatWithLocale() {
        BigDecimalWrapper wrapper = new BigDecimalWrapper("33.49");
        Assert.assertEquals("$33.49", wrapper.toCurrencyFormat(Locale.US));
    }

    @Test
    public void format() {
        String numberAsString = "123456.75";
        BigDecimalWrapper wrapper = new BigDecimalWrapper(numberAsString);
        String format = "#,###.00";
        DecimalFormat df = new DecimalFormat(format); // locale default
        Assert.assertEquals(df.format(new BigDecimal(numberAsString)), wrapper.format(format));
    }

    @Test
    public void setScale() {
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper(45.230).setScale(2);
        BigDecimalWrapper bigDecimalWrapperScaled = new BigDecimalWrapper(45.23);
        Assert.assertEquals(bigDecimalWrapper, bigDecimalWrapperScaled);
    }

    @Test
    public void testSetScale() {
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper(454.23445).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimalWrapper bigDecimalWrapperScaled = new BigDecimalWrapper(454.23);
        Assert.assertEquals(bigDecimalWrapper, bigDecimalWrapperScaled);
    }

    @Test
    public void testInt() {
        int y = 11;
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper(y);
        Assert.assertEquals("11", bigDecimalWrapper.toString());
    }

    @Test
    public void testLong() {
        long y = 12L;
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper(y);
        Assert.assertEquals("12", bigDecimalWrapper.toString());
    }

    @Test
    public void testDefaultConstructor() {
        BigDecimalWrapper bigDecimalWrapper = new BigDecimalWrapper();
        Assert.assertEquals("0", bigDecimalWrapper.toString());
    }

    @Test
    public void isLessThan() {

        BigDecimalWrapper twelve = new BigDecimalWrapper(12L);
        BigDecimalWrapper eleven = new BigDecimalWrapper(11L);
        Assert.assertTrue(eleven.isLessThan(twelve));
        Assert.assertFalse(twelve.isLessThan(eleven));
    }

    @Test
    public void isGreaterThan() {
        BigDecimalWrapper twelve = new BigDecimalWrapper(12L);
        BigDecimalWrapper eleven = new BigDecimalWrapper(11L);
        Assert.assertTrue(twelve.isGreaterThan(eleven));
        Assert.assertFalse(eleven.isGreaterThan(twelve));
    }

    @Test
    public void isLessThanOrEquals() {
        BigDecimalWrapper twelve = new BigDecimalWrapper(12L);
        BigDecimalWrapper eleven = new BigDecimalWrapper(11L);
        Assert.assertTrue(eleven.isLessThanOrEquals(twelve));
        Assert.assertTrue(eleven.isLessThanOrEquals(eleven));
        Assert.assertTrue(twelve.isLessThanOrEquals(twelve));
        Assert.assertFalse(twelve.isLessThanOrEquals(eleven));
    }

    @Test
    public void isGreaterThanOrEquals() {
        BigDecimalWrapper twelve = new BigDecimalWrapper(12L);
        BigDecimalWrapper eleven = new BigDecimalWrapper(11L);
        Assert.assertTrue(twelve.isGreaterThanOrEquals(eleven));
        Assert.assertTrue(eleven.isGreaterThanOrEquals(eleven));
        Assert.assertTrue(twelve.isGreaterThanOrEquals(twelve));
        Assert.assertFalse(eleven.isGreaterThanOrEquals(twelve));
    }

}
