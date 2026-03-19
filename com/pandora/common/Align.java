package com.pandora.common;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Align {
    public static int align(int value, int align) {
        return (((value + align) - 1) / align) * align;
    }

    public static long align(long value, int align) {
        long j = align;
        return (((value + j) - 1) / j) * j;
    }

    public static int align16(int value) {
        return align(value, 16);
    }

    public static long align16(long value) {
        return align(value, 16);
    }
}
