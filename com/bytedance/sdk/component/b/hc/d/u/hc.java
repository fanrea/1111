package com.bytedance.sdk.component.b.hc.d.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum hc {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int h;

    hc(int i) {
        this.h = i;
    }

    public static hc d(int i) {
        try {
            for (hc hcVar : values()) {
                if (hcVar.h == i) {
                    return hcVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
