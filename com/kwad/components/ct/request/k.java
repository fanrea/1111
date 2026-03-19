package com.kwad.components.ct.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends com.kwad.sdk.core.network.d {
    private SceneImpl mScene;

    public static class a {
        public com.kwad.components.ct.request.a.a aUG;
        public String aUH;
        public o aUI;
        public String aUg;
        public List<ImpInfo> anZ = new ArrayList(1);
    }

    public k(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (ImpInfo impInfo : aVar.anZ) {
            aa.a(jSONArray, impInfo.toJson());
            if (this.mScene == null) {
                this.mScene = impInfo.adScene;
            }
        }
        putBody("impInfo", jSONArray);
        putBody("contentInfo", aVar.aUG);
        if (aVar.aUI != null) {
            putBody("preloadInfo", aVar.aUI);
        }
        if (!TextUtils.isEmpty(aVar.aUH)) {
            putBody("pushStr", aVar.aUH);
        } else if (!TextUtils.isEmpty(aVar.aUg)) {
            putBody("mediaShareStr", aVar.aUg);
        }
        putBody("appTag", ag.aoD());
        if (this.mScene.getPageScene() == 9) {
            putBody("sdkType", 3);
            putBody("livePromotionId", this.mScene.getPromoteId());
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "comment", this.mScene.getComment());
            putBody("liveExt", jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        long userCommRateBuying = this.mScene.getUserCommRateBuying();
        long userCommRateSharing = this.mScene.getUserCommRateSharing();
        if (userCommRateBuying >= 0 && userCommRateBuying <= 100 && userCommRateSharing >= 0 && userCommRateSharing <= 100) {
            aa.putValue(jSONObject2, "userCommRateBuying", userCommRateBuying);
            aa.putValue(jSONObject2, "userCommRateSharing", userCommRateSharing);
            putBody("ecInfoParam", jSONObject2);
        }
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Ta();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final SceneImpl getScene() {
        return this.mScene;
    }
}
