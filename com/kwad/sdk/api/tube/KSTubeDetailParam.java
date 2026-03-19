package com.kwad.sdk.api.tube;

import android.text.TextUtils;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeDetailParam implements Serializable {
    private static final long serialVersionUID = 6410531748213171372L;
    private String mDetailData;
    private KSTubeParam mKSTubeParam;
    private KSTubeChannelData mTubeChannelData;

    private KSTubeDetailParam() {
    }

    public static KSTubeDetailParam obtain() {
        return new KSTubeDetailParam();
    }

    public KSTubeDetailParam setKSTubeParam(KSTubeParam kSTubeParam) {
        this.mKSTubeParam = kSTubeParam;
        return this;
    }

    public KSTubeDetailParam setDetailData(String str) {
        this.mDetailData = str;
        return this;
    }

    public KSTubeDetailParam setTubeChannelData(KSTubeChannelData kSTubeChannelData) {
        this.mTubeChannelData = kSTubeChannelData;
        return this;
    }

    public KSTubeParam getKSTubeParam() {
        return this.mKSTubeParam;
    }

    public String getDetailData() {
        return this.mDetailData;
    }

    public KSTubeChannelData getTubeChannelData() {
        return this.mTubeChannelData;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.mDetailData) || this.mKSTubeParam == null || getTubeChannelData() == null) ? false : true;
    }
}
