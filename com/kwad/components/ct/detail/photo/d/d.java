package com.kwad.components.ct.detail.photo.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.be;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends f {
    private View asU;

    public d(Context context) {
        super(context);
        initView();
    }

    @Override // com.kwad.components.ct.detail.photo.d.f
    protected final void initView() {
        this.ate = R.layout.ksad_content_alliance_bottom_panel_3;
        LayoutInflater.from(getContext()).inflate(this.ate, (ViewGroup) this, true);
        this.atg = ((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj();
        this.atb = (LinearLayout) findViewById(R.id.ksad_content_alliance_bottom_panel_layout);
        com.kwad.components.ct.f.g.r(this.atb, this.atg.aqv);
        this.atc = (LinearLayout) findViewById(R.id.ksad_photo_bottom_panel_buttons_layout);
        this.atc.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        this.atd = (Button) findViewById(R.id.ksad_photo_bottom_panel_cancel_button);
        com.kwad.components.ct.f.g.c(this.atd, this.atg.aqx);
        com.kwad.components.ct.f.g.a(this.atd, this.atg.aqw);
        this.atd.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.d.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    d.this.Aj();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.d.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    d.this.Aj();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        View viewFindViewById = findViewById(R.id.ksad_space);
        if (viewFindViewById != null && com.kwad.sdk.core.config.e.XN()) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.d.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.atf++;
                    if (d.this.atf > 10) {
                        com.kwad.sdk.utils.o.a(d.this.getContext(), "ksad_debug_deviceId_and_gid", "did:" + be.getDeviceId() + "——————egid:" + ag.aoE());
                        ac.ae(d.this.getContext(), "hello");
                        d.this.atf = 0;
                    }
                }
            });
        }
        this.asU = findViewById(R.id.ksad_content_ec_container);
    }

    @Override // com.kwad.components.ct.detail.photo.d.f
    protected final Presenter a(h hVar) {
        e(hVar.mAdTemplate);
        return super.a(hVar);
    }

    private void e(CtAdTemplate ctAdTemplate) {
        String strBd = com.kwad.components.ct.response.a.a.bd(ctAdTemplate);
        if (!"".equals(strBd) && strBd != null) {
            this.asU.setVisibility(0);
            ((TextView) findViewById(R.id.ksad_content_ec_bottom_text)).setText("分享商品最高赚" + strBd + "元");
        } else {
            this.asU.setVisibility(8);
        }
    }
}
