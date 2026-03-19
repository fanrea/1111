package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.e {
    private boolean HN;
    private com.kwad.components.ad.splashscreen.d IG;
    private TextView Ja;
    private KsShakeView Jd;
    private ViewGroup Jj;
    private com.kwad.sdk.core.g.d iQ;
    private Vibrator iS;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                o.this.HX.Hz = SystemClock.elapsedRealtime() - o.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.iS = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.Jj = (ViewGroup) viewStub.inflate();
        } else {
            this.Jj = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.Ja = (TextView) this.Jj.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.Jj.findViewById(R.id.ksad_shake_view);
        this.Jd = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        this.IG = com.kwad.components.ad.splashscreen.d.a(this.HX.mAdTemplate, com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate), this.HX.mApkDownloadHelper, 2);
        this.HN = com.kwad.sdk.core.response.b.d.eE(this.HX.mAdTemplate);
        new com.kwad.sdk.widget.j(this.Jd.getContext(), this.Jd, this);
        this.HX.a(this);
        TextView textView = this.Ja;
        if (textView != null) {
            textView.setText(this.IG.lE());
        }
        KsShakeView ksShakeView = this.Jd;
        if (ksShakeView != null) {
            ksShakeView.aq(this.IG.lF());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ms() {
        if (this.Jj == null || this.HX == null) {
            return;
        }
        this.Jj.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(185);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mt() {
        float fDI = com.kwad.sdk.core.response.b.b.dI(this.HX.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fDI);
            this.iQ = dVar2;
            dVar2.a(this);
            return;
        }
        dVar.K(fDI);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mu() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bW(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mv() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fR() {
        this.Jd.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.o.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                o.this.Jd.nB();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        TextView textView = this.Ja;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
            } else {
                textView.setText("或点击" + str);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        if (this.HX != null) {
            this.HX.b(this);
        }
        KsShakeView ksShakeView = this.Jd;
        if (ksShakeView != null) {
            ksShakeView.nC();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void d(final double d) throws Resources.NotFoundException {
        boolean zPe = com.kwad.components.core.e.c.b.pe();
        if (!this.HX.Hk.wO() || zPe) {
            return;
        }
        this.Jd.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (o.this.HX != null) {
                    o.this.HX.a(1, o.this.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.o(d);
                        }
                    });
                }
                o.this.Jd.nB();
            }
        });
        bx.a(getContext(), this.iS);
        mv();
    }

    @Override // com.kwad.sdk.core.g.b
    public final void ci() {
        com.kwad.sdk.core.adlog.c.cq(this.HX.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.Jd) || this.HX == null || this.HX.mAdTemplate == null || !com.kwad.sdk.core.response.b.b.eo(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate))) {
            return;
        }
        this.HX.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.b.b.eo(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate)) && this.HX != null) {
            this.HX.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.HN);
        if (this.HN && this.HX != null) {
            this.HX.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
    }
}
