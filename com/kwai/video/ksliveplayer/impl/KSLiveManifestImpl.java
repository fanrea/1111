package com.kwai.video.ksliveplayer.impl;

import com.baidu.mobstat.forbes.Config;
import com.kwai.video.ksliveplayer.KSLiveAdaptationCell;
import com.kwai.video.ksliveplayer.KSLiveManifest;
import com.kwai.video.ksliveplayer.model.LiveAdaptionModel;
import com.kwai.video.ksliveplayer.model.LiveAdaptiveManifestModel;
import com.kwai.video.ksliveplayer.model.LiveAdaptiveManifestModel_JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveManifestImpl implements KSLiveManifest {
    private List<KSLiveAdaptationCell> mLiveAdaptationList = new ArrayList();
    private LiveAdaptiveManifestModel mManifestModel;

    public KSLiveManifestImpl(String str) {
        this.mManifestModel = LiveAdaptiveManifestModel_JsonUtils.fromJson(str);
        Iterator<LiveAdaptionModel> it = this.mManifestModel.mAdaptationSet.mRepresentation.iterator();
        while (it.hasNext()) {
            this.mLiveAdaptationList.add(new KSLiveAdaptationCellImpl(it.next()));
        }
    }

    public KSLiveManifestImpl(LiveAdaptiveManifestModel liveAdaptiveManifestModel) {
        this.mManifestModel = liveAdaptiveManifestModel;
        Iterator<LiveAdaptionModel> it = this.mManifestModel.mAdaptationSet.mRepresentation.iterator();
        while (it.hasNext()) {
            this.mLiveAdaptationList.add(new KSLiveAdaptationCellImpl(it.next()));
        }
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveManifest
    public String getManifestVersion() {
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mManifestModel;
        if (liveAdaptiveManifestModel == null) {
            return null;
        }
        return liveAdaptiveManifestModel.mVersion;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveManifest
    public String getManifestType() {
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mManifestModel;
        if (liveAdaptiveManifestModel == null) {
            return null;
        }
        return liveAdaptiveManifestModel.mType;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveManifest
    public boolean isCdnFreeTraffic() {
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mManifestModel;
        if (liveAdaptiveManifestModel == null) {
            return false;
        }
        return liveAdaptiveManifestModel.mIsFreeTrafficCdn;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveManifest
    public List<KSLiveAdaptationCell> getLiveAdaptationCells() {
        if (this.mManifestModel == null) {
            return null;
        }
        return this.mLiveAdaptationList;
    }

    @Override // com.kwai.video.ksliveplayer.KSLiveManifest
    public boolean isHideAuto() {
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mManifestModel;
        if (liveAdaptiveManifestModel == null) {
            return false;
        }
        return liveAdaptiveManifestModel.mHideAuto;
    }

    public LiveAdaptiveManifestModel getManifestModel() {
        return this.mManifestModel;
    }

    public String toJsonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        LiveAdaptiveManifestModel liveAdaptiveManifestModel = this.mManifestModel;
        if (liveAdaptiveManifestModel != null) {
            try {
                jSONObject.put(Config.INPUT_DEF_VERSION, liveAdaptiveManifestModel.mVersion);
                jSONObject.put("type", this.mManifestModel.mType);
                jSONObject.put("freeTrafficCdn", this.mManifestModel.mIsFreeTrafficCdn);
                jSONObject.put("hideAuto", this.mManifestModel.mHideAuto);
                jSONObject.put("host", this.mManifestModel.mHost);
                JSONObject jSONObject2 = new JSONObject();
                if (this.mManifestModel.mAdaptationSet != null) {
                    jSONObject2.put("gopDuration", this.mManifestModel.mAdaptationSet.mGopDuration);
                    List<LiveAdaptionModel> list = this.mManifestModel.mAdaptationSet.mRepresentation;
                    JSONArray jSONArray = new JSONArray();
                    for (LiveAdaptionModel liveAdaptionModel : list) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("url", liveAdaptionModel.mUrl);
                        jSONObject3.put("id", liveAdaptionModel.mId);
                        jSONObject3.put("bitrate", liveAdaptionModel.mBitrate);
                        jSONObject3.put("qualityType", liveAdaptionModel.mQualityType);
                        jSONObject3.put("mediaType", liveAdaptionModel.mMediaType);
                        jSONObject3.put("name", liveAdaptionModel.mName);
                        jSONObject3.put("level", liveAdaptionModel.mLevel);
                        jSONObject3.put("defaultSelect", liveAdaptionModel.mIsDefaultSelect);
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject2.put("representation", jSONArray);
                }
                jSONObject.put("adaptationSet", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }
}
