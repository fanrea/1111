package com.baidu.mobads.container.w.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public enum a {
    DROPPED_BEST(0, "best"),
    DROPPED_NORMAL(1, "normal"),
    DROPPED_MIDDLE(2, "middle"),
    DROPPED_HIGH(3, "high"),
    DROPPED_FROZEN(4, "frozen");

    private final int f;
    private final String g;

    a(int i, String str) {
        this.f = i;
        this.g = str;
    }

    public int b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }
}
