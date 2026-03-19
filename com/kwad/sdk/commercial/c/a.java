package com.kwad.sdk.commercial.c;

import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.eV(adTemplate);
        this.llsid = e.eM(adTemplate);
        this.posId = e.eI(adTemplate);
        AdInfo adInfoEP = e.eP(adTemplate);
        this.campaignType = com.kwad.sdk.core.response.b.a.dC(adInfoEP);
        this.ocpcActionType = com.kwad.sdk.core.response.b.a.dD(adInfoEP);
        this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dE(adInfoEP);
        this.adOperationType = com.kwad.sdk.core.response.b.a.aU(adInfoEP);
        this.webUriSourceType = com.kwad.sdk.core.response.b.a.dF(adInfoEP);
        AdMatrixInfo.MatrixTemplate matrixTemplateBu = d.bu(adTemplate);
        if (matrixTemplateBu != null) {
            this.templateId = matrixTemplateBu.templateId;
            this.templateVersion = String.valueOf(matrixTemplateBu.templateVersionCode);
            this.tkPublishType = matrixTemplateBu.publishType;
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }
}
