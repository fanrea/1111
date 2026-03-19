package com.kwad.components.core.e.e;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends b implements View.OnClickListener {
    private TextView RJ;
    private TextView RK;
    private TextView vB;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vB = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.RJ = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.RK = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.RI.RH.pp() == 1) {
            this.vB.setText("即将打开" + com.kwad.sdk.core.response.b.a.cA(this.mAdInfo));
        } else if (this.RI.RH.pp() == 2) {
            this.vB.setText("即将打开第三方页面");
        }
        com.kwad.sdk.c.a.a.a(this, this.RJ, this.RK);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.RI.RH.am(true);
        this.RI.RF.dismiss();
        if (view == this.RJ) {
            com.kwad.components.core.e.d.a.a(this.RI.RH);
            com.kwad.sdk.core.adlog.c.r(this.RI.RH.getAdTemplate(), 230);
        } else if (view == this.RK) {
            com.kwad.sdk.core.adlog.c.r(this.RI.RH.getAdTemplate(), 231);
        }
    }
}
