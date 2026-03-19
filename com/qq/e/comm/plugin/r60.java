package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum r60 {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    private final int a;

    r60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static r60 a(int i) {
        if (i == 0) {
            return NO_WRAP;
        }
        if (i == 1) {
            return WRAP;
        }
        if (i == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i);
    }
}
