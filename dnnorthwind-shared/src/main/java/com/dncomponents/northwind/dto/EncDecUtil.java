package com.dncomponents.northwind.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class EncDecUtil {

    public static Integer getInt(Double value) {
        return value == null ? null : value.intValue();
    }

    public static Double setInt(Integer value) {
        return value == null ? null : Double.valueOf(value);
    }

    public static Date getDate(Double value) {
        return value == null ? null : new Date(value.longValue());
    }

    public static Double setDate(Date value) {
        return value == null ? null : (double) value.getTime();
    }

    public static Double setShort(Short value) {
        return value == null ? null : Double.valueOf(value);
    }

    public static Byte getByte(Double value) {
        return value == null ? null : value.byteValue();
    }

    public static Double setByte(Byte value) {
        return value == null ? null : Double.valueOf(value);
    }

    public static Long getLong(String value) {
        return value == null ? null : Long.valueOf(value);
    }

    public static String setLong(Long value) {
        return value == null ? null : value.toString();
    }

    public static BigInteger getBigInteger(String value) {
        return value == null ? null : new BigInteger(value);
    }

    public static String setBigInteger(BigInteger value) {
        return value == null ? null : value.toString();
    }

    public static BigDecimal getBigDecimal(String value) {
        return value == null ? null : new BigDecimal(value);
    }

    public static String setBigDecimal(BigDecimal value) {
        return value == null ? null : value.toString();
    }

}
