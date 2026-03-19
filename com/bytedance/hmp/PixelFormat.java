package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum PixelFormat {
    PF_NONE(-1),
    PF_YUV420P(0),
    PF_YUV422P(4),
    PF_YUV444P(5),
    PF_NV12(23),
    PF_NV21(24),
    PF_GRAY8(8),
    PF_RGB24(2),
    PF_RGBA32(26),
    PF_GRAY16(30),
    PF_YUVA420P(33),
    PF_RGB48(35),
    PF_RGBA64(107);

    private final int value;

    PixelFormat(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
