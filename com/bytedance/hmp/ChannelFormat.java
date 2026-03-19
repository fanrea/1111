package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum ChannelFormat {
    kNCHW(0),
    kNHWC(1);

    private final int value;

    ChannelFormat(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
