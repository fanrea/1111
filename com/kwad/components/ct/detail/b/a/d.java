package com.kwad.components.ct.detail.b.a;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.b {
    private RelativeLayout ayM;
    private View ayN;
    private boolean ayO = false;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f12if;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.ayO = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f12if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.ayM = (RelativeLayout) findViewById(R.id.ksad_video_bottom_container);
        this.ayN = findViewById(R.id.ksad_bottom_shadow);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        Activity activity = this.aop.aoy.getActivity();
        if (!com.kwad.sdk.c.a.a.r(activity) || this.ayO) {
            return;
        }
        j(activity);
    }

    private void j(Activity activity) {
        final int iQ = com.kwad.sdk.c.a.a.q(activity);
        final Point pointBw = com.kwad.sdk.c.a.a.bw(activity);
        this.f12if.post(new bh() { // from class: com.kwad.components.ct.detail.b.a.d.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int[] iArr = new int[2];
                d.this.f12if.getLocationOnScreen(iArr);
                int i = pointBw.y - iArr[1];
                if (i < 0 || i >= iQ) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = d.this.ayN.getLayoutParams();
                layoutParams.height += iQ;
                d.this.ayN.setLayoutParams(layoutParams);
                d.this.ayM.setPadding(0, 0, 0, iQ);
                d.a(d.this, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
