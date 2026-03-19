package com.android.gdt.qone.report.beat;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum BeatType {
    NORMAL(0, 0),
    INIT(1, 1),
    REGISTER(2, 2),
    AUDIT(3, 4),
    NET_CHANGE(4, 8),
    FORGROUND(5, 0),
    BACKGROUND(6, 0);

    private final int controlBit;
    private final int type;

    BeatType(int i, int i2) {
        this.type = i;
        this.controlBit = i2;
    }

    public final int a() {
        return this.controlBit;
    }

    public final int b() {
        return this.type;
    }
}
