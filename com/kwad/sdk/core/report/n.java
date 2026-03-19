package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n extends e {
    public String OV;
    public String OW;
    public long OY;
    public String QX;
    public long YA;
    public long YB;
    public long YC;
    public String Yt;
    public long actionType;
    public transient SceneImpl adScene;
    public long adZ;
    public int afw;
    public long authorId;
    public long bBn;
    public long bEK;
    public JSONObject bEL;
    public JSONObject bEM;
    public long bEN;
    public long bEO;
    public long bEP;
    public long bEQ;
    public long bER;
    public long bET;
    public URLPackage bEU;
    public String bEV;
    public JSONArray bEW;
    public JSONArray bEX;
    public a bEY;
    public int bEZ;
    public int bFA;
    public JSONArray bFB;
    public long bFC;
    public long bFD;
    public JSONArray bFE;
    public String bFF;
    public String bFG;
    public String bFH;
    public String bFI;
    public String bFJ;
    public String bFL;
    public String bFM;
    public int bFN;
    public long bFQ;
    public long bFR;
    public String bFS;
    public int bFa;
    public int bFb;
    public int bFc;
    public String bFd;
    public int bFe;
    public int bFf;
    public String bFg;
    public JSONObject bFh;
    public JSONArray bFi;
    public int bFj;
    public int bFk;
    public int bFl;
    public JSONArray bFn;
    public boolean bFo;
    public String bFp;
    public long bFs;
    public int bFt;
    public String bFu;
    public long bFv;
    public long bFw;
    public long bFx;
    public long bFy;
    public String bFz;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sdkApiVersion;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long bES = -1;
    public int bws = 0;
    public long bFm = 0;
    public int bFq = 0;
    public int bFr = -1;
    public int bFK = 0;
    public int bFO = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String bFP = BuildConfig.VERSION_NAME;

    public n(long j) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 2;
        this.bFS = "";
        this.actionType = j;
    }

    public n(long j, AdTemplate adTemplate) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 2;
        this.bFS = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public n(long j, AdTemplate adTemplate, String str) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 2;
        this.bFS = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.QX = str;
    }

    public n(String str, String str2, boolean z) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 2;
        this.bFS = "";
        if (z) {
            try {
                parseJson(new JSONObject(str2));
                return;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                return;
            }
        }
        this.actionId = str;
        this.bFS = str2;
    }

    public n JU() {
        aZ(this.mAdTemplate);
        return this;
    }

    public final void abm() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.bFj = jVar.sN() ? 1 : 0;
        this.bFk = jVar.sO();
        this.bFl = jVar.sP();
    }

    protected void aZ(AdTemplate adTemplate) {
        try {
            this.bFa = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.bFq = sVar.wR();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.abs();
            try {
                this.OY = t.abt();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            this.bEK = t.abw();
            SceneImpl sceneImpl = this.adScene;
            if (sceneImpl != null) {
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && adTemplate.mAdScene != null) {
                SceneImpl sceneImpl2 = adTemplate.mAdScene;
                this.adScene = sceneImpl2;
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.bEN = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.eM(adTemplate);
                String strEN = com.kwad.sdk.core.response.b.e.eN(adTemplate);
                if (!TextUtils.isEmpty(strEN)) {
                    try {
                        this.bEL = new JSONObject(strEN);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                }
                String strEO = com.kwad.sdk.core.response.b.e.eO(adTemplate);
                if (!TextUtils.isEmpty(strEO)) {
                    try {
                        this.bEM = new JSONObject(strEO);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.eI(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.eL(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.bg(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
                    this.creativeId = adInfoEP.adBaseInfo.creativeId;
                    this.bEO = com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000;
                    this.authorId = adInfoEP.advertiserInfo.userId;
                }
                this.bEZ = adTemplate.mMediaPlayerType;
                this.bFb = adTemplate.mIsLeftSlipStatus;
                this.bFc = adTemplate.mPhotoResponseType;
                if (adTemplate.mPageInfo != null) {
                    this.pageType = adTemplate.mPageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.bh(adTemplate);
            }
            this.bEY = a.abn();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e4);
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.bFa = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.bFf = jSONObject.optInt("num");
        this.bFe = jSONObject.optInt("state");
        this.bFm = jSONObject.optLong("timeSpend");
        this.bFC = jSONObject.optLong("loadingDuration");
        this.bFD = jSONObject.optLong("loadingDurationLimt");
        this.bFr = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            aa.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.bFf;
        if (i2 > 0) {
            aa.putValue(jSONObject, "num", i2);
        }
        int i3 = this.bFe;
        if (i3 != 0) {
            aa.putValue(jSONObject, "state", i3);
        }
        long j = this.bFm;
        if (j > 0) {
            aa.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.bFC;
        if (j2 > 0) {
            aa.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.bFD;
        if (j3 > 0) {
            aa.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        aa.putValue(jSONObject, "playerTypeInfo", this.bFr);
    }

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int bFT;
        public int bFU;

        public static a abn() {
            a aVar = new a();
            aVar.bFT = b.bFT;
            aVar.bFU = b.bFU;
            return aVar;
        }
    }

    public static class b {
        public static int bFT;
        public static int bFU;

        public static void fr(int i) {
            bFT = i;
        }

        public static void fs(int i) {
            bFU = i;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        if (TextUtils.isEmpty(this.bFS)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.bFS + '}';
    }
}
