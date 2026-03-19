package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.audience.model.KSLiveTopUser;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.z;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean YH = true;
    ImpInfo Tk;
    private int YG;

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    public a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, cVar);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Tk, aVar.YQ, aVar.YR, aVar.YT);
        this.YG = aVar.YS ? 1 : 0;
    }

    public a(ImpInfo impInfo, List<String> list, boolean z, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Tk = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.abA(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i = this.YG;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        String strWO = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.d.g(DevelopMangerComponents.class)).WO() : "";
        if (!TextUtils.isEmpty(strWO)) {
            putBody("universeDebugParam", strWO);
        }
        String strD = d(impInfo);
        if (!TextUtils.isEmpty(strD)) {
            putBody("sdkDebugReqInfo", strD);
        }
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", ag.aoD());
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Tk.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g gVarAbH = com.kwad.sdk.core.request.model.g.abH();
        if (rewardCallbackExtraByKey != null) {
            gVarAbH.fL(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(gVarAbH, adLabelFromAdScene);
        }
        putBody(KSLiveTopUser.KEY_USER_INFO, gVarAbH);
        if (com.kwad.components.ad.f.a.qq.booleanValue()) {
            try {
                com.kwad.sdk.components.a aVar = (com.kwad.sdk.components.a) com.kwad.sdk.components.d.g(com.kwad.sdk.components.a.class);
                if (aVar != null) {
                    putBody("adBrowseParam", aVar.WN());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        if (adLabelImpl.thirdAge != 0) {
            gVar.thirdAge = adLabelImpl.thirdAge;
        }
        if (adLabelImpl.thirdGender != 0) {
            gVar.thirdGender = adLabelImpl.thirdGender;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            aa.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            aa.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            aa.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            aa.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        aa.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void ba(int i) {
        this.YG = i;
    }

    public final int getAdNum() {
        return this.Tk.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        if (com.kwad.components.ad.f.a.qq.booleanValue()) {
            try {
                if (((com.kwad.sdk.components.a) com.kwad.sdk.components.d.g(com.kwad.sdk.components.a.class)) != null) {
                    return com.kwad.sdk.h.TE();
                }
            } catch (Throwable unused) {
            }
        }
        return com.kwad.sdk.h.SW();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Tk;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (YH && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) z.callMethodOrThrow(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                YH = false;
            }
        }
        return "";
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        s.dy(true);
        b.sx().sy();
        super.onCreate();
    }
}
