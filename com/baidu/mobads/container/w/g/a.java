package com.baidu.mobads.container.w.g;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public enum a {
    ANR_TAG("anr", 842),
    STUCK_TAG("stuck", 841),
    FRAME_TAG(TypedValues.AttributesType.S_FRAME, 840);

    private final String d;
    private final int e;

    a(String str, int i) {
        this.d = str;
        this.e = i;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.d;
    }
}
