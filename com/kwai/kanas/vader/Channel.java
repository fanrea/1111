package com.kwai.kanas.vader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public enum Channel {
    REAL_TIME(0),
    HIGH_FREQ(1),
    NORMAL(2);

    private int value;

    Channel(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
