package com.baidu.mobads.container;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.s.g;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad implements g.a {
    final /* synthetic */ k a;

    ad(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.mobads.container.s.g.a
    public void a(float f, float f2) {
        this.a.mClickTracker.a(this.a.l, f, f2);
        this.a.mClickTracker.a("splash_multiple_interactions_view");
        this.a.mClickTracker.b("splash_multiple_interactions_view");
        this.a.splashAdClick("shake", j.a.SPLASH_MULTIPLE_INTERACTIONS_VIEW.c());
        this.a.sendSplashShakeLog("onAdMixInterShake");
    }

    @Override // com.baidu.mobads.container.s.g.a
    public void a(View view, MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.a.mClickTracker.a(this.a.l, 1, motionEvent, motionEvent2);
        this.a.mClickTracker.a("splash_multiple_interactions_view");
        this.a.mClickTracker.b("splash_multiple_interactions_view");
        this.a.splashAdClick(ILogConst.DRAW_ENTER_TYPE_SLIDE, j.a.SPLASH_MULTIPLE_INTERACTIONS_VIEW.c());
        this.a.sendSplashShakeLog("onAdMixInterSlide");
    }

    @Override // com.baidu.mobads.container.s.g.a
    public void b(View view, MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.a.mClickTracker.a(this.a.l, 0, motionEvent, motionEvent2);
        this.a.mClickTracker.a("splash_multiple_interactions_view");
        this.a.mClickTracker.b("splash_multiple_interactions_view");
        this.a.splashAdClick("click", j.a.SPLASH_MULTIPLE_INTERACTIONS_VIEW.c());
        this.a.sendSplashShakeLog("onAdMixInterClick");
    }
}
