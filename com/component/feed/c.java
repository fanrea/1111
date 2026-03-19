package com.component.feed;

import com.baidu.mobads.container.util.ce;
import com.component.player.AdVideoViewListener;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements AdVideoViewListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener
    public void playCompletion() {
        try {
            this.a.D = false;
            this.a.w.b("CoreVideoWrapper", com.baidu.mobads.container.components.k.b.I);
            this.a.o();
            List<String> thirdTrackers = this.a.r.getThirdTrackers(PointCategory.VCLOSE);
            int i = this.a.r.isAutoPlay() ? 0 : 1;
            double dG = this.a.x.g();
            Double.isNaN(dG);
            ce.a(dG / 1000.0d, this.a.f757K, thirdTrackers, i, 5);
            this.a.b(a.g);
            this.a.f();
            if (this.a.C != null) {
                this.a.C.playCompletion();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playFailure(String str) {
        this.a.D = false;
        this.a.o();
        this.a.w.b("CoreVideoWrapper", "playFailure");
        if (this.a.C != null) {
            this.a.C.playError();
        }
        this.a.a(a.i, str);
        List<String> thirdTrackers = this.a.r.getThirdTrackers("vplayfail");
        int i = !this.a.r.isAutoPlay() ? 1 : 0;
        double dG = this.a.x.g();
        Double.isNaN(dG);
        ce.a(dG / 1000.0d, this.a.f757K, thirdTrackers, i, 0);
        this.a.e();
    }

    @Override // com.component.player.AdVideoViewListener
    public void renderingStart() {
        if (this.a.C != null) {
            this.a.C.playRenderingStart();
        }
        this.a.r();
        if (this.a.r != null && !this.a.z) {
            this.a.z = true;
            this.a.r.recordImpression(this.a);
        }
        this.a.f757K = 0.0d;
        this.a.b(a.f);
        this.a.w.b("CoreVideoWrapper", "renderingStart");
        this.a.d();
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStart() {
        if (this.a.A == 0) {
            this.a.A = System.currentTimeMillis();
            this.a.b("play");
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playStop() {
        if (this.a.x != null) {
            long jL = this.a.x.l() / 1000;
            long jM = this.a.x.m() / 1000;
            if (jL > 0 && jL != jM) {
                this.a.b(a.e);
            }
        }
    }

    @Override // com.component.player.AdVideoViewListener
    public void playPause() {
        if (this.a.C != null) {
            this.a.C.playPause();
        }
        this.a.c();
    }

    @Override // com.component.player.AdVideoViewListener
    public void playResume() {
        if (this.a.C != null) {
            this.a.C.playResume();
        }
        this.a.r();
        this.a.b();
    }
}
