package com.bytedance.adsdk.hc.hc.u.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static Object d(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i / number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(i / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(i / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object d(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Long.valueOf(j / number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(j / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(j / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(j / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object d(float f, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Float.valueOf(f / number.intValue());
        }
        if (number instanceof Long) {
            return Float.valueOf(f / number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(f / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(f / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object d(double d, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Double.valueOf(d / number.intValue());
        }
        if (number instanceof Long) {
            return Double.valueOf(d / number.longValue());
        }
        if (number instanceof Float) {
            return Double.valueOf(d / number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(d / number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object d(Number number, Number number2) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d(number.intValue(), number2);
        }
        if (number instanceof Long) {
            return d(number.longValue(), number2);
        }
        if (number instanceof Float) {
            return d(number.floatValue(), number2);
        }
        if (number instanceof Double) {
            return d(number.doubleValue(), number2);
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }
}
