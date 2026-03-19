package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum DeviceType {
    kCPU(0),
    kCUDA(1);

    private final int value;

    DeviceType(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
