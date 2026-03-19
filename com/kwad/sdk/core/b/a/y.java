package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class y implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdInsertScreenInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer(PointType.SIGMOB_APP).intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer(PointType.SIGMOB_APP).intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    private static JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adInsertScreenInfo.cycleAggregateSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateSwitch", adInsertScreenInfo.cycleAggregateSwitch);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        if (adInsertScreenInfo.cycleAggregateStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateStyle", adInsertScreenInfo.cycleAggregateStyle);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        if (adInsertScreenInfo.autoCloseTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "autoCloseTime", adInsertScreenInfo.autoCloseTime);
        }
        if (adInsertScreenInfo.retainWindowStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowStyle", adInsertScreenInfo.retainWindowStyle);
        }
        if (adInsertScreenInfo.retainWindowText != null && !adInsertScreenInfo.retainWindowText.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        if (adInsertScreenInfo.retainWindowBasedAdShowCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowBasedAdShowCount", adInsertScreenInfo.retainWindowBasedAdShowCount);
        }
        if (adInsertScreenInfo.retainWindowDailyShowCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowDailyShowCount", adInsertScreenInfo.retainWindowDailyShowCount);
        }
        return jSONObject;
    }
}
