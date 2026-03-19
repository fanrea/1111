package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum o60 {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);

    private final int a;

    o60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static o60 a(int i) {
        if (i == 0) {
            return VISIBLE;
        }
        if (i == 1) {
            return HIDDEN;
        }
        if (i == 2) {
            return SCROLL;
        }
        throw new IllegalArgumentException("Unknown enum value: " + i);
    }
}
