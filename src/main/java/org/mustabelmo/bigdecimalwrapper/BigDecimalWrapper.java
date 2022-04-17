package org.mustabelmo.bigdecimalwrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import static java.math.BigDecimal.ROUND_UNNECESSARY;

public class BigDecimalWrapper {
    private final BigDecimal innerDecimal;

    public BigDecimalWrapper() {
        this(BigInteger.ZERO);
    }

    public BigDecimalWrapper(BigDecimal innerDecimal) {
        this.innerDecimal = Objects.requireNonNull(innerDecimal);
    }

    public BigDecimalWrapper(int i) {
        this(BigDecimal.valueOf(i));
    }

    public BigDecimalWrapper(long i) {
        this(BigDecimal.valueOf(i));
    }

    public BigDecimalWrapper(double i) {
        this(BigDecimal.valueOf(i));
    }

    public BigDecimalWrapper(String i) {
        this(new BigDecimal(i));
    }

    public BigDecimalWrapper(BigInteger i) {
        this(BigDecimal.valueOf(i.intValue()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BigDecimalWrapper that = (BigDecimalWrapper) o;
        return innerDecimal.compareTo(that.innerDecimal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerDecimal);
    }

    @Override
    public String toString() {
        return innerDecimal.toString();
    }

    public String toCurrencyFormat(Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(innerDecimal);
    }

    public String toCurrencyFormat() {
        return toCurrencyFormat(Locale.getDefault());
    }

    public String format(String format) {
        return format(format, Locale.getDefault());
    }

    public String format(String format, Locale locale) {
        DecimalFormat df = new DecimalFormat(format, new DecimalFormatSymbols(locale));
        return df.format(innerDecimal);
    }

    public BigDecimalWrapper setScale(int scale) {
        return setScale(scale, ROUND_UNNECESSARY);
    }

    public BigDecimalWrapper setScale(int scale, int roundingMode) {
        return new BigDecimalWrapper(innerDecimal.setScale(scale, roundingMode));
    }


    public boolean isLessThan(BigDecimal another) {
        return innerDecimal.compareTo(another) < 0;
    }

    public boolean isGreaterThan(BigDecimal another) {
        return innerDecimal.compareTo(another) > 0;
    }

    public boolean isLessThanOrEquals(BigDecimal another) {
        return innerDecimal.compareTo(another) <= 0;
    }

    public boolean isGreaterThanOrEquals(BigDecimal another) {
        return innerDecimal.compareTo(another) >= 0;
    }

    public boolean isLessThan(BigDecimalWrapper another) {
        return isLessThan(another.innerDecimal);
    }

    public boolean isGreaterThan(BigDecimalWrapper another) {
        return isGreaterThan(another.innerDecimal);
    }

    public boolean isLessThanOrEquals(BigDecimalWrapper another) {
        return isLessThanOrEquals(another.innerDecimal);
    }

    public boolean isGreaterThanOrEquals(BigDecimalWrapper another) {
        return isGreaterThanOrEquals(another.innerDecimal);
    }


}
