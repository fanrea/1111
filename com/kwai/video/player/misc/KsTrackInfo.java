package com.kwai.video.player.misc;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.adrequest.b;
import com.kwai.video.player.KsMediaMeta;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsTrackInfo implements ITrackInfo {
    private KsMediaMeta.KSYStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public KsTrackInfo(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        this.mStreamMeta = kSYStreamMeta;
    }

    public void setMediaMeta(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        this.mStreamMeta = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new KsMediaFormat(this.mStreamMeta);
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getLanguage() {
        KsMediaMeta.KSYStreamMeta kSYStreamMeta = this.mStreamMeta;
        return (kSYStreamMeta == null || TextUtils.isEmpty(kSYStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setTrackType(int i) {
        this.mTrackType = i;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + i.d;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb = new StringBuilder(128);
        int i = this.mTrackType;
        if (i == 1) {
            sb.append(b.InterfaceC0119b.i);
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getResolutionInline());
        } else if (i == 2) {
            sb.append("AUDIO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getSampleRateInline());
        } else if (i == 3) {
            sb.append("TIMEDTEXT");
        } else if (i == 4) {
            sb.append("SUBTITLE");
        } else {
            sb.append("UNKNOWN");
        }
        return sb.toString();
    }
}
