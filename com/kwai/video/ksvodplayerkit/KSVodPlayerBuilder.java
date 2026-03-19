package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.KSVodAdaptationModel;
import com.kwai.video.ksvodplayerkit.Utils.VodMediaCodecConfig;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerBuilder {
    private KwaiPlayerVodBuilder mBuilder;
    public Context mContext;
    public Map<String, String> mExtraHeaders;
    public Map<String, String> mHeaders;
    public VodMediaCodecConfig mMediaCodecConfig;
    public int mPreferBandWidth;
    public long mSeekAtStart;
    public boolean mStartOnPrepared;
    public String mUrl;
    public List<String> mUrlList;
    public KSVodVideoContext mVideoContext;
    public KSVodAdaptationModel mVodAdaptationModel;
    public VodPlayEnterType mEnterType = VodPlayEnterType.CLICK;
    public boolean mRetryAutoPlay = true;
    public int mUrlType = 0;
    public String mProductName = "N/A";

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public enum VodPlayEnterType {
        SLIDE,
        CLICK
    }

    public KSVodPlayerBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context con't be null!");
        }
        this.mBuilder = new KwaiPlayerVodBuilder(context);
        this.mContext = context;
    }

    public KwaiPlayerVodBuilder builder() {
        return this.mBuilder;
    }

    public KSVodPlayerBuilder setDataSource(String str) {
        this.mUrl = str;
        return this;
    }

    public KSVodPlayerBuilder setDataSource(List<String> list) {
        this.mUrlList = list;
        return this;
    }

    public KSVodPlayerBuilder setExtraHeaders(Map<String, String> map) {
        this.mExtraHeaders = map;
        return this;
    }

    public KSVodPlayerBuilder setDataManifest(KSVodAdaptationModel kSVodAdaptationModel) {
        this.mVodAdaptationModel = kSVodAdaptationModel;
        this.mUrlType = 1;
        return this;
    }

    public KSVodPlayerBuilder setKwaiManifestV2(String str) {
        this.mUrl = str;
        this.mUrlType = 3;
        return this;
    }

    public KSVodPlayerBuilder setHlsManifest(String str) {
        this.mUrl = str;
        this.mUrlType = 2;
        return this;
    }

    public KSVodPlayerBuilder setHlsPreferBandwidth(int i) {
        this.mPreferBandWidth = i;
        return this;
    }

    public KSVodPlayerBuilder setPlayVideoContext(KSVodVideoContext kSVodVideoContext) {
        this.mVideoContext = kSVodVideoContext;
        return this;
    }

    public KSVodPlayerBuilder setProductName(String str) {
        this.mProductName = str;
        return this;
    }

    public KSVodPlayerBuilder setMediaCodecConfig(VodMediaCodecConfig vodMediaCodecConfig) {
        this.mMediaCodecConfig = vodMediaCodecConfig;
        return this;
    }

    public KSVodPlayerBuilder seekAtStart(long j) {
        this.mSeekAtStart = j;
        return this;
    }

    public KSVodPlayerBuilder setStartOnPrepared(boolean z) {
        this.mStartOnPrepared = z;
        return this;
    }

    public KSVodPlayerBuilder setPlayerEnterType(VodPlayEnterType vodPlayEnterType) {
        this.mEnterType = vodPlayEnterType;
        return this;
    }

    public KSVodPlayerBuilder enableRetryAutoPlay(boolean z) {
        this.mRetryAutoPlay = z;
        return this;
    }

    public KSVodPlayer build() {
        List<String> list;
        KSVodAdaptationModel kSVodAdaptationModel;
        if (this.mContext == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Please set context!");
        }
        String str = this.mUrl;
        if ((str == null || TextUtils.isEmpty(str)) && (((list = this.mUrlList) == null || list.isEmpty()) && ((kSVodAdaptationModel = this.mVodAdaptationModel) == null || kSVodAdaptationModel.vodAdaptationSets == null || this.mVodAdaptationModel.vodAdaptationSets.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Please SetDatasource!");
        }
        return new KSVodPlayer(this);
    }
}
