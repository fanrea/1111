package com.kwad.sdk.live.audience.model;

import com.kuaishou.android.live.model.Race;
import com.kwad.sdk.live.audience.net.KSLiveJsonParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayConfig {
    private static final String ATTACH = "attach";
    public static final Race DEFAULT_RACE = new Race();
    private static final String HOSTS = "socketHostPorts";
    private static final String LOCAL = "locale";
    private static final String MANIFEST = "liveAdaptiveManifest";
    private static final String PLAY_URLS = "playUrls";
    private static final String RACE = "race";
    private static final String STREAM_ID = "liveStreamId";
    public String mAttach;
    public String mLiveManifestJson;
    public String mLiveServiceToken;
    public String mLiveStreamId;
    public String mLocale;
    public List<KSLiveCDNUrl> mPlayUrls = new ArrayList();
    public List<String> mSocketHostPorts = new ArrayList();
    public Race mRace = DEFAULT_RACE;

    public String getLocale() {
        return this.mLocale;
    }

    public String getLiveStreamId() {
        return this.mLiveStreamId;
    }

    public String getAttach() {
        return this.mAttach;
    }

    public List<String> getSocketHostPorts() {
        return this.mSocketHostPorts;
    }

    public Race getRace() {
        return this.mRace;
    }

    public String getLiveServiceToken() {
        return this.mLiveServiceToken;
    }

    public static KSLivePlayConfig parseFromJson(String str) {
        KSLivePlayConfig kSLivePlayConfig = new KSLivePlayConfig();
        JSONObject jSONObject = new JSONObject(str);
        kSLivePlayConfig.mLiveStreamId = jSONObject.optString(STREAM_ID);
        kSLivePlayConfig.mAttach = jSONObject.optString("attach");
        kSLivePlayConfig.mLocale = jSONObject.optString(LOCAL);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(HOSTS);
        if (jSONArrayOptJSONArray != null) {
            kSLivePlayConfig.mSocketHostPorts = KSLiveJsonUtil.parseStringListFromJson(jSONArrayOptJSONArray);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(RACE);
        if (jSONObjectOptJSONObject != null) {
            kSLivePlayConfig.mRace = KSLiveJsonUtil.parseRaceFromJson(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(MANIFEST);
        if (jSONObjectOptJSONObject2 != null) {
            kSLivePlayConfig.mLiveManifestJson = jSONObjectOptJSONObject2.toString();
        } else {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(PLAY_URLS);
            if (jSONArrayOptJSONArray2 != null) {
                kSLivePlayConfig.mPlayUrls = KSLiveCDNUrl.parseFromJson(jSONArrayOptJSONArray2);
            }
        }
        return kSLivePlayConfig;
    }

    public String toString() {
        return "KSLivePlayConfig{mLiveStreamId='" + this.mLiveStreamId + "', mPlayUrls=" + this.mPlayUrls + ", mLiveManifestJson='" + this.mLiveManifestJson + "', mLocale='" + this.mLocale + "', mAttach='" + this.mAttach + "', mSocketHostPorts=" + this.mSocketHostPorts + ", mRace=" + this.mRace + '}';
    }

    public static KSLivePlayConfig createHolderConfig() {
        KSLivePlayConfig kSLivePlayConfig = new KSLivePlayConfig();
        KSLiveCDNUrl kSLiveCDNUrl = new KSLiveCDNUrl();
        kSLiveCDNUrl.mUrl = "http://aliyun-test-pull.voip.yximgs.com/holderurl";
        kSLivePlayConfig.mPlayUrls.add(kSLiveCDNUrl);
        return kSLivePlayConfig;
    }

    public static KSLiveJsonParser<KSLivePlayConfig> parser() {
        return new KSLiveJsonParser<KSLivePlayConfig>() { // from class: com.kwad.sdk.live.audience.model.KSLivePlayConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwad.sdk.live.audience.net.KSLiveJsonParser
            public KSLivePlayConfig parse(String str) {
                return KSLivePlayConfig.parseFromJson(str);
            }
        };
    }
}
