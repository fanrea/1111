package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends a {
    private LinearLayout UQ;
    private TextView UR;
    private ImageView US;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        rz();
    }

    private void rz() {
        this.UQ = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.Vx.mPageTitle)) {
            this.UQ.setVisibility(8);
            return;
        }
        this.UR = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.US = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.UQ.setVisibility(8);
            }
        });
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate);
        boolean zBI = com.kwad.sdk.core.response.b.a.bI(adInfoEP);
        String strBE = com.kwad.sdk.core.response.b.a.bE(adInfoEP);
        if (zBI) {
            this.UQ.setVisibility(0);
            this.UR.setText(strBE);
            this.UR.setSelected(true);
        } else {
            this.UQ.setVisibility(8);
        }
        this.Vx.a(rA());
    }

    private KsAdWebView.c rA() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void rB() {
                if (e.this.Vx.rh() && e.this.UQ.getVisibility() == 0) {
                    e.this.UQ.setVisibility(8);
                }
            }
        };
    }
}
