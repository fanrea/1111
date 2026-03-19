package com.bytedance.hmp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum ColorTransferCharacteristic {
    CTC_RESERVED0(0),
    CTC_BT709(1),
    CTC_UNSPECIFIED(2),
    CTC_RESERVED(3),
    CTC_GAMMA22(4),
    CTC_GAMMA28(5),
    CTC_SMPTE170M(6),
    CTC_SMPTE240M(7),
    CTC_LINEAR(8),
    CTC_LOG(9),
    CTC_LOG_SQRT(10),
    CTC_IEC61966_2_4(11),
    CTC_BT1361_ECG(12),
    CTC_IEC61966_2_1(13),
    CTC_BT2020_10(14),
    CTC_BT2020_12(15),
    CTC_SMPTE2084(16),
    CTC_SMPTEST2084(16),
    CTC_SMPTE428(17),
    CTC_SMPTEST428_1(17),
    CTC_ARIB_STD_B67(18),
    CTC_NB(19);

    private final int value;

    ColorTransferCharacteristic(final int v) {
        this.value = v;
    }

    public int getValue() {
        return this.value;
    }
}
