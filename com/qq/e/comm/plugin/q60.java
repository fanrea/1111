package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum q60 {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);

    private final int a;

    q60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static q60 a(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return POINT;
        }
        if (i == 2) {
            return PERCENT;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return AUTO;
    }
}
