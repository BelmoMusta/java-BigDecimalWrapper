package org.mustabelmo.bigdecimalwrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

public class BigDecimalWrapper extends Number {
	private final BigDecimal innerDecimal;
	
	public BigDecimalWrapper(BigDecimal innerDecimal) {
		this.innerDecimal = innerDecimal;
	}
	
	@Override
	public int intValue() {
		return innerDecimal.intValue();
	}
	
	@Override
	public long longValue() {
		return innerDecimal.longValue();
	}
	
	@Override
	public float floatValue() {
		return innerDecimal.floatValue();
	}
	
	@Override
	public double doubleValue() {
		return innerDecimal.doubleValue();
	}
	
	public static BigDecimal valueOf(long val) {return BigDecimal.valueOf(val);}
	
	public static BigDecimal valueOf(double val) {return BigDecimal.valueOf(val);}
	
	public BigDecimal add(BigDecimal augend) {return innerDecimal.add(augend);}
	
	public BigDecimal add(BigDecimal augend, MathContext mc) {return innerDecimal.add(augend, mc);}
	
	public BigDecimal subtract(BigDecimal subtrahend) {return innerDecimal.subtract(subtrahend);}
	
	public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {return innerDecimal.subtract(subtrahend, mc);}
	
	public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {return innerDecimal.divide(divisor, scale, roundingMode);}
	
	public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {return innerDecimal.divide(divisor,
			roundingMode);}
	
	public BigDecimal divide(BigDecimal divisor) {return innerDecimal.divide(divisor);}
	
	public BigDecimal divide(BigDecimal divisor, MathContext mc) {return innerDecimal.divide(divisor, mc);}
	
	public BigDecimal[] divideAndRemainder(BigDecimal divisor) {return innerDecimal.divideAndRemainder(divisor);}
	
	public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {return innerDecimal.divideAndRemainder(divisor, mc);}
	
	public BigDecimal sqrt(MathContext mc) {return innerDecimal.sqrt(mc);}
	
	public BigDecimal pow(int n) {return innerDecimal.pow(n);}
	
	public BigDecimal abs(MathContext mc) {return innerDecimal.abs(mc);}
	
	public BigDecimal negate() {return innerDecimal.negate();}
	
	public int compareTo(BigDecimal val) {return innerDecimal.compareTo(val);}
	
	@Override
	public String toString() {return innerDecimal.toString();}
	
	public String toPlainString() {return innerDecimal.toPlainString();}
	
	public BigInteger toBigInteger() {return innerDecimal.toBigInteger();}
	
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
}
