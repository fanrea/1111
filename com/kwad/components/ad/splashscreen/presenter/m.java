package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView IA;
    private com.kwad.components.ad.splashscreen.d IG;
    private View IV;
    private KsRotateView IW;
    private TextView IX;
    private com.kwad.sdk.core.g.c iR;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.IV = viewStub.inflate();
        } else {
            this.IV = findViewById(R.id.ksad_rotate_root);
        }
        this.IX = (TextView) findViewById(R.id.ksad_rotate_text);
        this.IA = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.IW = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        AdTemplate adTemplate = this.HX.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.IG = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfoEP, this.HX.mApkDownloadHelper, 1);
        TextView textView = this.IX;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dS(adInfoEP));
        }
        TextView textView2 = this.IA;
        if (textView2 != null) {
            textView2.setText("或点击" + this.IG.lE());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ms() {
        if (this.IV == null || this.HX == null) {
            return;
        }
        this.IV.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 184, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(184);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mt() {
        AdMatrixInfo.RotateInfo rotateInfoDJ = com.kwad.sdk.core.response.b.b.dJ(this.HX.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(rotateInfoDJ);
            this.iR = cVar2;
            cVar2.a(this);
            return;
        }
        cVar.b(rotateInfoDJ);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mu() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bW(mz());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mv() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bX(mz());
        }
    }

    private Context mz() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.IV) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fR() {
        KsRotateView ksRotateView = this.IW;
        if (ksRotateView == null) {
            return;
        }
        ksRotateView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                m.this.IW.fR();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        TextView textView = this.IA;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
            } else {
                textView.setText("或点击" + str);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        rootView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (m.this.HX != null) {
                    m.this.HX.Hz = SystemClock.elapsedRealtime() - m.this.mStartTime;
                }
            }
        });
        if (this.HX != null) {
            this.HX.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotatePresenter", "onUnbind");
        if (this.HX != null) {
            this.HX.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void r(final String str) {
        boolean zWO = this.HX.Hk.wO();
        boolean zPe = com.kwad.components.core.e.c.b.pe();
        if (!zWO || zPe) {
            return;
        }
        this.IW.nA();
        if (this.HX != null) {
            this.HX.a(1, mz(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.eK(str);
                }
            });
        }
        mx();
        mv();
    }

    @Override // com.kwad.sdk.core.g.a
    public final void cj() {
        com.kwad.sdk.core.adlog.c.cq(this.HX.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bX(mz());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.HX.c(1, mz(), 162, 1);
    }
}
