package com.baidu.mobads.container;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.s.al;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements al.a {
    final /* synthetic */ k a;

    u(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.mobads.container.s.al.a
    public void a(View view, boolean z, MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.a.mClickTracker.a(view, !z ? 1 : 0, motionEvent, motionEvent2);
        this.a.splashAdClick(ILogConst.DRAW_ENTER_TYPE_SLIDE, j.a.SPLASH_ACTION_VIEW.c());
    }
}
