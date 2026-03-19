package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum e60 {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    private final int a;

    e60(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static e60 a(int i) {
        if (i == 0) {
            return COLUMN;
        }
        if (i == 1) {
            return COLUMN_REVERSE;
        }
        if (i == 2) {
            return ROW;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return ROW_REVERSE;
    }
}
