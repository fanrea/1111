package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ActionBarH5 extends FrameLayout implements e {
    private TextView Go;
    private a Gp;
    private View Gq;
    private TextView it;
    private AdTemplate mAdTemplate;

    public interface a {
        void O(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        B(context);
    }

    public ActionBarH5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public ActionBarH5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.Go = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.it = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.Gq = findViewById(R.id.ksad_download_bar_cover);
    }

    public final void a(AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.Gp = aVar;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.Go.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        this.it.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        setClickable(true);
        this.Gq.setClickable(true);
        new j(this.Gq, this);
        new j(this, this);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (d.eE(this.mAdTemplate)) {
            d(view, false);
        }
    }

    private void d(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).aG(view == this.Gq ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.Gp != null) {
                    ActionBarH5.this.Gp.O(z);
                }
            }
        }));
    }
}
