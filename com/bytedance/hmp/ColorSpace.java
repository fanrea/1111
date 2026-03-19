package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum ColorSpace {
    CS_RGB(0),
    CS_BT709(1),
    CS_UNSPECIFIED(2),
    CS_RESERVED(3),
    CS_FCC(4),
    CS_BT470BG(5),
    CS_SMPTE170M(6),
    CS_SMPTE240M(7),
    CS_YCGCO(8),
    CS_YCOCG(8),
    CS_BT2020_NCL(9),
    CS_BT2020_CL(10),
    CS_SMPTE2085(11),
    CS_CHROMA_DERIVED_NCL(2),
    CS_CHROMA_DERIVED_CL(13),
    CS_ICTCP(14),
    CS_NB(15);

    private final int value;

    ColorSpace(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
