package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum ColorRange {
    CR_UNSPECIFIED(0),
    CR_MPEG(1),
    CR_JPEG(2),
    CR_NB(3);

    private final int value;

    ColorRange(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
