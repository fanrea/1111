package com.bytedance.bmf_mods_lite_api.bean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RoiParams {
    public long roiBackground;
    public int roiH;
    public int roiHStart;
    public int roiMode;
    public int roiW;
    public int roiWStart;

    public RoiParams() {
    }

    public RoiParams(int roiWStart, int roiHStart, int roiW, int roiH, int roiMode, long roiBackground) {
        this.roiWStart = roiWStart;
        this.roiHStart = roiHStart;
        this.roiW = roiW;
        this.roiH = roiH;
        this.roiMode = roiMode;
        this.roiBackground = roiBackground;
    }
}
