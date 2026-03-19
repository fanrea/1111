package com.kwai.video.ksvodplayerkit.Utils;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodMediaCodecConfig {
    public int mediaCodecAvcHeightLimit;
    public int mediaCodecAvcWidthLimit;
    public int mediaCodecHevcHeightLimit;
    public int mediaCodecHevcWidthLimit;
    public int mediaCodecMaxNum;
    public boolean supportAvcMediaCodec;
    public boolean supportHevcMediaCodec;
    public boolean useMediaCodecByteBuffer;

    public VodMediaCodecConfig() {
    }

    public VodMediaCodecConfig(boolean z, boolean z2, int i, int i2, boolean z3, int i3, int i4, int i5) {
        this.useMediaCodecByteBuffer = z;
        this.supportAvcMediaCodec = z2;
        this.mediaCodecAvcWidthLimit = i;
        this.mediaCodecAvcHeightLimit = i2;
        this.supportHevcMediaCodec = z3;
        this.mediaCodecHevcWidthLimit = i3;
        this.mediaCodecHevcHeightLimit = i4;
        this.mediaCodecMaxNum = i5;
    }
}
