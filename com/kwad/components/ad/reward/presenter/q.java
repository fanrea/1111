package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends b {
    private float xP;
    private r xR;
    private KsToastView xY;
    private Runnable yb;
    private boolean xZ = false;
    private boolean ya = false;
    private boolean yc = false;
    private boolean xS = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            q.this.xY.setVisibility(8);
        }
    };

    static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.yc = true;
        return true;
    }

    public q(r rVar) {
        this.xR = rVar;
    }

    public final void iP() {
        if (this.ya) {
            return;
        }
        iM();
        this.ya = true;
        this.xY.setVisibility(0);
        this.xY.ai(3);
        iR();
        bx.a(this.yb, null, com.alipay.sdk.m.u.b.a);
    }

    public final void iQ() {
        this.ya = false;
        this.xY.setVisibility(8);
    }

    private synchronized void iM() {
        if (this.xS) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.vb.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(192).aV(this.vb.tu.getPlayDuration()));
        this.xS = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xP = com.kwad.components.ad.reward.a.b.hJ();
        this.xZ = com.kwad.components.ad.reward.a.b.hK() && com.kwad.components.ad.reward.a.b.hL();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.xY == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.xY = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.xY.setVisibility(8);
                    com.kwad.components.ad.reward.a.gl().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.vb.b(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        iS();
        this.vb.c(this.mPlayEndPageListener);
    }

    private void iR() {
        this.yb = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.yc) {
                    return;
                }
                if (q.this.xY != null) {
                    q.this.xY.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.gl().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void iS() {
        bx.d(this.yb);
        this.yb = null;
    }
}
