package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView AY;
    private TextView AZ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.AY = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.AZ = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.AY.setVisibility(8);
        this.AZ.setVisibility(8);
    }

    private void jQ() {
        String strEC = com.kwad.sdk.core.response.b.d.eC(this.vb.mAdTemplate);
        if (this.vb.mScreenOrientation == 1) {
            this.AZ.setVisibility(8);
            this.AY.setText(strEC);
            this.AY.setVisibility(0);
            this.AY.setOnClickListener(this);
        } else {
            this.AY.setVisibility(8);
            this.AZ.setText(strEC);
            this.AZ.setVisibility(0);
            this.AZ.setOnClickListener(this);
        }
        dt();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.AY || view == this.AZ) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.vb.mAdTemplate).b(this.vb.mApkDownloadHelper).aq(false).aG(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.jR();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    private void dt() {
        com.kwad.sdk.core.adlog.c.b(this.vb.mAdTemplate, 17, this.vb.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR() {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, "native_id", "endTopBar", new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(39), this.vb.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.vb.tt.db();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jS() {
        if (this.vb.tV) {
            return;
        }
        jQ();
    }
}
