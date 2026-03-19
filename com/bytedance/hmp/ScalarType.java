package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum ScalarType {
    kUInt8(0),
    kInt(1),
    kUInt16(2),
    kInt16(3),
    kInt32(4),
    kInt64(5),
    kFloat32(6),
    kFloat64(7),
    kHalf(8);

    int value;

    ScalarType(int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
