package com.baidu.mobads.container.g;

import com.baidu.mobads.container.util.bv;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements h {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ i b;

    n(i iVar, JSONObject jSONObject) {
        this.b = iVar;
        this.a = jSONObject;
    }

    @Override // com.baidu.mobads.container.g.h
    public void a() {
        if (!this.b.addMixInteractView()) {
            if ((this.b.mLimitRegionClick || this.b.mDisplayClickButton) && !this.b.hasSlide()) {
                this.b.addMantle();
            }
            this.b.addSlideView();
            this.b.addActionView();
            this.b.addShakeView();
        }
        this.b.doAddProgressView();
        this.b.addBubbleView();
        this.b.addAtmosphereView();
        this.b.addAppSmallLogo();
        this.b.addLawText();
        this.b.addDspId(this.b.mAdContainerCxt.v(), 0);
        if (this.b.f && !this.b.mPopDialogIfDl) {
            this.b.addDownloadDescT(this.a, bv.a(this.b.mAppContext, 13.0f));
        }
        com.baidu.mobads.container.d.b.a().a(new o(this));
    }
}
