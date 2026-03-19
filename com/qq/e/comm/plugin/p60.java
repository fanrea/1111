package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum p60 {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    private final int a;

    p60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static p60 a(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i);
    }
}
