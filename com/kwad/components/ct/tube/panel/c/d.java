package com.kwad.components.ct.tube.panel.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSLinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.tube.panel.b.a implements com.kwad.components.ct.f.b {
    private f<d> aDL;
    private KSLinearLayout aXY;
    private View aXZ;
    private TextView aYa;
    private TextView aYb;
    private TextView aYc;
    private ImageView aYd;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aXY = (KSLinearLayout) findViewById(R.id.ksad_tube_pannel);
        float fA = com.kwad.sdk.c.a.a.a(getContext(), 12.0f);
        this.aXY.setRadius(fA, fA, 0.0f, 0.0f);
        this.aYa = (TextView) findViewById(R.id.ksad_tube_pannel_title_name);
        this.aYb = (TextView) findViewById(R.id.ksad_tube_pannel_title_dot);
        this.aYc = (TextView) findViewById(R.id.ksad_tube_pannel_title_episode_num);
        this.aYd = (ImageView) findViewById(R.id.ksad_tube_pannel_collapse_arrow);
        this.aXZ = findViewById(R.id.ksad_tube_pannel_divider_bottom);
        this.aDL = new f<>(this);
    }

    @Override // com.kwad.components.ct.tube.panel.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
        if (this.aXj.aPS.size() <= 1) {
            this.aXj.aXR.setVisibility(8);
        }
        Ke();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
        super.onUnbind();
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        Ke();
    }

    private void Ke() {
        g.c(this.aXY, Kj().aZc);
        g.c(this.aXZ, Kj().aZf);
        g.a(this.aYa, Kj().aZd);
        g.a(this.aYb, Kj().aZd);
        g.a(this.aYc, Kj().aZd);
        g.a(this.aYd, Kj().aZu);
        this.aXj.aXR.setTextColor(Kj().aZv);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }
}
