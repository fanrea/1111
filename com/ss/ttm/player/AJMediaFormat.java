package com.ss.ttm.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AJMediaFormat {
    public int channelCount;
    public int colorFormat;
    public int colorTrans;
    public int height;
    public int sampleRate;
    public int sliceHeight;
    public int stride;
    public int width;

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.sampleRate = 0;
        this.channelCount = 0;
        this.colorFormat = 0;
        this.colorTrans = 0;
        this.sliceHeight = 0;
        this.stride = 0;
    }
}
