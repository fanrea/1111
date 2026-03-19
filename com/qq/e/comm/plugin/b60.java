package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum b60 {
    INHERIT(0),
    LTR(1),
    RTL(2);

    private final int a;

    b60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static b60 a(int i) {
        if (i == 0) {
            return INHERIT;
        }
        if (i == 1) {
            return LTR;
        }
        if (i == 2) {
            return RTL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i);
    }
}
