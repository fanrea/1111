package com.kwai.video.ksvodplayerkit.MultiRate;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodAdaptationSet {
    public int avgBitrate;
    public int height;
    public int maxRate;
    public float quality;
    public List<String> urls;
    public int width;

    public KSVodAdaptationSet(int i, int i2, int i3, int i4, float f, List<String> list) {
        this.avgBitrate = i;
        this.maxRate = i2;
        this.width = i3;
        this.height = i4;
        this.quality = f;
        this.urls = list;
    }

    public KSVodAdaptationSet() {
    }
}
