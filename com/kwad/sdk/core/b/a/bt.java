package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.home.config.item.AvatarGuiderConfigItem;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bt implements com.kwad.sdk.core.d<AvatarGuiderConfigItem.AvatarGuiderConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AvatarGuiderConfigItem.AvatarGuiderConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AvatarGuiderConfigItem.AvatarGuiderConfig) bVar, jSONObject);
    }

    private static void a(AvatarGuiderConfigItem.AvatarGuiderConfig avatarGuiderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        avatarGuiderConfig.showByPlayRate = jSONObject.optInt("showByPlayRate", new Integer("70").intValue());
        avatarGuiderConfig.showTimeLength = jSONObject.optInt("showTimeLength", new Integer("3000").intValue());
        avatarGuiderConfig.showMaxTimes = jSONObject.optInt("showMaxTimes", new Integer("7").intValue());
    }

    private static JSONObject b(AvatarGuiderConfigItem.AvatarGuiderConfig avatarGuiderConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showByPlayRate", avatarGuiderConfig.showByPlayRate);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTimeLength", avatarGuiderConfig.showTimeLength);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showMaxTimes", avatarGuiderConfig.showMaxTimes);
        return jSONObject;
    }
}
