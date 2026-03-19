package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView lR;
    private String lS;
    private long lT;
    private o lv = new o() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.k(j2);
        }
    };
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lR = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.lT = com.kwad.sdk.core.response.b.d.eA(this.mAdTemplate);
        String strEB = com.kwad.sdk.core.response.b.d.eB(this.mAdTemplate);
        this.lS = strEB;
        if (TextUtils.isEmpty(strEB)) {
            return;
        }
        this.mApkDownloadHelper = this.vb.mApkDownloadHelper;
        this.vb.tu.a(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.lS)) {
            return;
        }
        this.vb.tu.b(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.lR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        if (j >= this.lT) {
            ds();
        }
    }

    private void ds() {
        if (this.lR.getVisibility() == 0) {
            return;
        }
        this.lR.setText(com.kwad.sdk.core.response.b.d.eB(this.mAdTemplate));
        this.lR.setVisibility(0);
        this.lR.setOnClickListener(this);
        dt();
    }

    private void dt() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.vb.mReportExtData);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.lR) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aF(40).aE(1).aq(false).aq(this.vb.gM()).aG(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(40), this.vb.mReportExtData);
        this.vb.tt.db();
    }
}
