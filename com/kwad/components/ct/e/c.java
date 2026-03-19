package com.kwad.components.ct.e;

import com.kwad.components.ct.response.a.d;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.scene.EntryPackage;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends n {
    public int aTA;
    public int aTB;
    public int aTC;
    public int aTD;
    public int aTE;
    public long aTF;
    public long aTG;
    public int aTH;
    public int aTI;
    public int aTJ;
    public String aTK;
    public String aTL;
    public long aTM;
    public long aTN;
    public int aTO;
    public int aTP;
    public boolean aTQ;
    public int aTR;
    public String aTS;
    public String aTT;
    public int aTU;
    public int aTV;
    public long aTW;
    public int aTX;
    public long aTY;
    public long aTZ;
    public long aTv;
    public long aTw;
    public long aTx;
    public int aTy;
    public int aTz;
    public int aUa;
    public int aUb;
    public int aUc;
    public JSONArray aUd;
    public String aUe;
    public int aUf;
    public String aUg;
    public int aUh;
    public int aUi;
    public double aUj;
    public String aUk;
    public int aUl;
    public int aUm;
    public int closeType;
    public String coverUrl;
    public String entryId;
    public String episodeName;
    public int episodeNumber;
    public transient CtAdTemplate mAdTemplate;
    public int preloadType;
    public String recoExt;
    public String tabName;
    public long trendId;
    public long tubeId;
    public String tubeName;

    public c(long j) {
        this(j, null);
    }

    public c(long j, AdTemplate adTemplate) {
        this(j, adTemplate, (String) null);
    }

    public c(long j, AdTemplate adTemplate, String str) {
        super(j, adTemplate, str);
        this.aTz = 0;
        this.aTA = 0;
        this.aTB = -1;
        this.aTI = -1;
        this.aTJ = 0;
        this.aTR = -1;
        this.aTY = -1L;
        this.aTZ = -1L;
        this.aUf = 0;
        if (adTemplate != null) {
            this.mAdTemplate = com.kwad.components.ct.response.a.a.ba(adTemplate);
        }
    }

    public c(String str, String str2, boolean z) {
        super(str, str2, z);
        this.aTz = 0;
        this.aTA = 0;
        this.aTB = -1;
        this.aTI = -1;
        this.aTJ = 0;
        this.aTR = -1;
        this.aTY = -1L;
        this.aTZ = -1L;
        this.aUf = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.n
    /* renamed from: JT, reason: merged with bridge method [inline-methods] */
    public c JU() {
        super.JU();
        return this;
    }

    @Override // com.kwad.sdk.core.report.n
    public final void aZ(AdTemplate adTemplate) {
        super.aZ(adTemplate);
        if (adTemplate != null) {
            ap(com.kwad.components.ct.response.a.a.ba(adTemplate));
        }
    }

    private void ap(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate != null) {
            if (this.realShowType == 1) {
                this.bEO = com.kwad.components.ct.response.a.c.f((PhotoInfo) ctAdTemplate.photoInfo).longValue();
                this.authorId = com.kwad.components.ct.response.a.c.e(ctAdTemplate.photoInfo);
                this.recoExt = com.kwad.components.ct.response.a.c.l((PhotoInfo) ctAdTemplate.photoInfo);
                this.tubeId = com.kwad.components.ct.response.a.c.t(ctAdTemplate.photoInfo);
                this.tubeName = com.kwad.components.ct.response.a.c.w(ctAdTemplate.photoInfo);
                this.aTQ = com.kwad.components.ct.response.a.c.B(ctAdTemplate.photoInfo);
                this.episodeName = com.kwad.components.ct.response.a.c.x(ctAdTemplate.photoInfo);
                this.episodeNumber = com.kwad.components.ct.response.a.c.z(ctAdTemplate.photoInfo);
                this.trendId = com.kwad.components.ct.response.a.c.H(ctAdTemplate.photoInfo);
                this.aTS = com.kwad.components.ct.response.a.c.I(ctAdTemplate.photoInfo);
                if (ctAdTemplate.mPreloadData != null) {
                    this.preloadType = ctAdTemplate.mPreloadData.isPreload ? 1 : 0;
                } else {
                    this.preloadType = 0;
                }
            } else if (this.realShowType == 5) {
                this.aUl = d.k(com.kwad.components.ct.response.a.a.az(ctAdTemplate));
            }
        }
        if (this.urlPackage != null) {
            EntryPackage entryPackageFR = com.kwad.sdk.core.scene.b.abP().fR(this.urlPackage.identity);
            this.entryPageSource = entryPackageFR.entryPageSource;
            this.entryId = entryPackageFR.entryId;
            this.bEU = com.kwad.sdk.core.scene.b.abP().fQ(this.urlPackage.identity);
        }
    }

    @Override // com.kwad.sdk.core.report.n, com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aUa = jSONObject.optInt("adHorizontalFeedType");
        this.aUb = jSONObject.optInt("videoPlayMode");
        this.aUc = jSONObject.optInt("autoReplayTimes");
        this.aTB = jSONObject.optInt("playerControlledType", -1);
        this.aTI = jSONObject.optInt("reportType");
        this.aTY = jSONObject.optLong("relatedFromPhotoId", -1L);
        this.aTZ = jSONObject.optLong("relatedContentSourceType", -1L);
    }

    @Override // com.kwad.sdk.core.report.n, com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        int i = this.aTB;
        if (i != -1) {
            aa.putValue(jSONObject, "playerControlledType", i);
        }
        int i2 = this.aTI;
        if (i2 != -1) {
            aa.putValue(jSONObject, "reportType", i2);
        }
        long j = this.aTY;
        if (j != -1) {
            aa.putValue(jSONObject, "relatedFromPhotoId", j);
        }
        long j2 = this.aTZ;
        if (j2 != -1) {
            aa.putValue(jSONObject, "relatedContentSourceType", j2);
        }
        aa.putValue(jSONObject, "adHorizontalFeedType", this.aUa);
        aa.putValue(jSONObject, "videoPlayMode", this.aUb);
        aa.putValue(jSONObject, "autoReplayTimes", this.aUc);
    }
}
