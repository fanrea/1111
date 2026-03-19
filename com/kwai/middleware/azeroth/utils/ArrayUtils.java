package com.kwai.middleware.azeroth.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ArrayUtils {
    public static <T> int search(T[] tArr, T t) {
        for (int i = 0; i < tArr.length; i++) {
            if (t.equals(tArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int search(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static void copyTo(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return;
        }
        System.arraycopy(iArr2, 0, iArr, 0, Math.min(iArr.length, iArr2.length));
    }

    public static int sum(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static int[] copyReversed(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[(length - i) - 1];
        }
        return iArr2;
    }

    public static int[] insert(int[] iArr, int i, int i2) {
        if (i >= iArr.length) {
            throw new IllegalArgumentException();
        }
        int[] iArr2 = new int[iArr.length + 1];
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[i3] = iArr[i3];
        }
        iArr2[i] = i2;
        while (i < iArr.length) {
            int i4 = i + 1;
            iArr2[i4] = iArr[i];
            i = i4;
        }
        return iArr2;
    }

    public static int[] remove(int[] iArr, int i) {
        if (i >= iArr.length) {
            throw new IllegalArgumentException();
        }
        if (iArr.length <= 1) {
            return new int[0];
        }
        int[] iArr2 = new int[iArr.length - 1];
        for (int i2 = 0; i2 < i; i2++) {
            iArr2[i2] = iArr[i2];
        }
        for (int i3 = i + 1; i3 < iArr.length; i3++) {
            iArr2[i3 - 1] = iArr[i3];
        }
        return iArr2;
    }

    public static <T> T[] concat(Class<T> cls, T[]... tArr) {
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
        int length2 = 0;
        for (T[] tArr4 : tArr) {
            System.arraycopy(tArr4, 0, tArr3, length2, tArr4.length);
            length2 += tArr4.length;
        }
        return tArr3;
    }

    public static List<Integer> asList(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (iArr == null) {
            return arrayList;
        }
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static <T> ArrayList<T> asArrayList(T... tArr) {
        if (tArr == null) {
            return new ArrayList<>();
        }
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        try {
            arrayList.addAll(Arrays.asList(tArr));
        } catch (Exception unused) {
            for (T t : tArr) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> T getItem(T[] tArr, int i) {
        if (tArr == null || i < 0 || i >= tArr.length) {
            return null;
        }
        return tArr[i];
    }

    public static <T> boolean contains(T[] tArr, T t) {
        return search(tArr, t) != -1;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (t == tArr[i] || (t != null && t.equals(tArr[i]))) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfFirst(Object[] objArr, Class<?> cls) {
        if (!isEmpty(objArr)) {
            int i = -1;
            for (Object obj : objArr) {
                i++;
                if (obj != null && cls == obj.getClass()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int indexOfObject(Object[] objArr, Class<?> cls, int i) {
        if (objArr == null) {
            return -1;
        }
        while (i < objArr.length) {
            if (cls.isInstance(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOfLast(Object[] objArr, Class<?> cls) {
        if (isEmpty(objArr)) {
            return -1;
        }
        for (int length = objArr.length; length > 0; length--) {
            int i = length - 1;
            Object obj = objArr[i];
            if (obj != null && obj.getClass() == cls) {
                return i;
            }
        }
        return -1;
    }

    public static <T> T getFirst(Object[] objArr, Class<?> cls) {
        int iIndexOfFirst = indexOfFirst(objArr, cls);
        if (iIndexOfFirst != -1) {
            return (T) objArr[iIndexOfFirst];
        }
        return null;
    }

    public static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
    }
}
