package com.baidu.mobads.container.x.a;

import com.baidu.mobads.container.adrequest.n;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.ce;
import com.component.player.AdVideoViewListener;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements AdVideoViewListener {
    final /* synthetic */ a a;
    private boolean b = false;

    j(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        this.a.closeAd("completion");
        this.a.clickSkip = true;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.closeAd("video_onError");
        if (this.a.c != null) {
            com.baidu.mobads.container.adrequest.j jVar = this.a.d;
            double dG = this.a.c.g();
            Double.isNaN(dG);
            double d = this.a.b;
            Double.isNaN(d);
            ce.a(jVar, dG / 1000.0d, d / 1000.0d, 0);
            this.a.a(com.component.feed.a.i, str);
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        try {
            if (!this.b) {
                ce.c(this.a.d, this.a.mAdContainerCxt, 1);
                this.b = true;
                if (!this.a.addMixInteractView()) {
                    if ((this.a.mLimitRegionClick || this.a.mDisplayClickButton) && !this.a.hasSlide()) {
                        this.a.addMantle();
                    }
                    this.a.addSlideView();
                    this.a.addActionView();
                    this.a.addShakeView();
                }
                this.a.addBubbleView();
                this.a.addAtmosphereView();
                this.a.doAddProgressView();
                if (this.a.c != null && this.a.mProgressView != null) {
                    this.a.mProgressView.a(this.a.c.h());
                }
                this.a.a();
                this.a.addAppSmallLogo();
                this.a.addLawText();
                this.a.addDspId(this.a.mAdContainerCxt.v(), 0);
                JSONObject originJsonObject = this.a.mAdContainerCxt.q().getOriginJsonObject();
                if (this.a.f && !this.a.mPopDialogIfDl) {
                    this.a.addDownloadDescT(originJsonObject, bv.a(this.a.mAppContext, 13.0f));
                }
                this.a.a(com.component.feed.a.f, "");
            } else {
                this.a.mAdContainerCxt.v().requestLayout();
            }
            this.a.b();
            com.component.player.c cVar = this.a.c;
            cVar.getLayoutParams().width = -1;
            cVar.getLayoutParams().height = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStart() {
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStop() {
        n.e(this.a.mAdContainerCxt.q(), "splash_comps", this.a.mSNameMsgs.toString());
        com.baidu.mobads.container.v.a.a(this.a.mAdContainerCxt, 0, true, 4, 415, this.a.showRecord, "0");
    }

    @Override // com.component.player.AdVideoViewListener
    public void playPause() {
        this.a.h();
    }

    @Override // com.component.player.AdVideoViewListener
    public void playResume() {
        this.a.g();
    }
}
