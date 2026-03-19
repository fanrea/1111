package com.kwad.sdk.live.audience.model;

import com.kuaishou.android.live.model.Race;
import com.kwad.sdk.live.audience.net.KSLiveJsonParser;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveRaceInfo {
    private static final String ATTACH = "attach";
    private static final String RACE = "race";
    public Race mRace = new Race();
    public String mAttach = "";

    public String toString() {
        return "KSLiveRaceInfo{mRace=" + this.mRace + ", mAttach='" + this.mAttach + "'}";
    }

    public static KSLiveRaceInfo parseFromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        KSLiveRaceInfo kSLiveRaceInfo = new KSLiveRaceInfo();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(RACE);
        if (jSONObjectOptJSONObject != null) {
            kSLiveRaceInfo.mRace = KSLiveJsonUtil.parseRaceFromJson(jSONObjectOptJSONObject);
        }
        kSLiveRaceInfo.mAttach = jSONObject.optString("attach");
        return kSLiveRaceInfo;
    }

    public static KSLiveJsonParser<KSLiveRaceInfo> parser() {
        return new KSLiveJsonParser<KSLiveRaceInfo>() { // from class: com.kwad.sdk.live.audience.model.KSLiveRaceInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kwad.sdk.live.audience.net.KSLiveJsonParser
            public KSLiveRaceInfo parse(String str) {
                return KSLiveRaceInfo.parseFromJson(str);
            }
        };
    }
}
