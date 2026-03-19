package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum c60 {
    FLEX(0),
    NONE(1);

    private final int a;

    c60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static c60 a(int i) {
        if (i == 0) {
            return FLEX;
        }
        if (i == 1) {
            return NONE;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i);
    }
}
