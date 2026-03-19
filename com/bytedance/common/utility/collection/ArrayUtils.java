package com.bytedance.common.utility.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> list) {
        if (list == null) {
            return null;
        }
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    public static List<Long> toList(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static <T> T[] combineArray(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) copyOfRange(tArr, 0, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> T[] insert(T[] tArr, int i, T t) {
        T t2;
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + 1));
        int i2 = 0;
        while (i2 < tArr2.length) {
            if (i2 < i) {
                t2 = tArr[i2];
            } else {
                t2 = i2 == i ? t : tArr[i2 - 1];
            }
            tArr2[i2] = t2;
            i2++;
        }
        return tArr2;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, i, tArr2, 0, iMin);
        return tArr2;
    }
}
