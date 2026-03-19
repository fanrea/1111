package com.kwai.video.ksliveplayer.impl;

import android.text.TextUtils;
import com.kwai.video.ksliveplayer.KSLiveAdaptationCell;
import com.kwai.video.ksliveplayer.model.LiveAdaptionModel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveAdaptationCellImpl implements KSLiveAdaptationCell {
    private LiveAdaptionModel mAdaptationModel;
    private String mResolvedUrl;

    public KSLiveAdaptationCellImpl(LiveAdaptionModel liveAdaptionModel) {
        this.mAdaptationModel = liveAdaptionModel;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public int getId() {
        return this.mAdaptationModel.mId;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public int getBitrate() {
        return this.mAdaptationModel.mBitrate;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public String getLiveUrl() {
        if (!TextUtils.isEmpty(this.mResolvedUrl)) {
            return this.mResolvedUrl;
        }
        return this.mAdaptationModel.mUrl;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public String getQualityType() {
        return this.mAdaptationModel.mQualityType;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public String getName() {
        String str = this.mAdaptationModel.mName;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String nameByQualityType = LiveAdaptionModel.getNameByQualityType(this.mAdaptationModel.mQualityType);
        this.mAdaptationModel.mName = nameByQualityType;
        return nameByQualityType;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveAdaptationCell
    public int getMediaType() {
        if (this.mAdaptationModel.mMediaType == null) {
            return 0;
        }
        if (this.mAdaptationModel.mMediaType.equals("AUDIOONLY")) {
            return 3;
        }
        return this.mAdaptationModel.mMediaType.equals("VIDEOONLY") ? 2 : 1;
    }

    public void setResolvedUrl(String str) {
        this.mResolvedUrl = str;
        this.mAdaptationModel.mUrl = str;
    }
}
