package com.kwad.components.ct.tube.channel.home.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.tube.channel.home.c.a implements com.kwad.components.ct.f.b {
    private TextView Pc;
    private com.kwad.components.ct.f.f<e> aDL;
    private ImageView aWg;
    private View apY;
    private View mRootView;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mRootView = getRootView();
        this.aWg = (ImageView) findViewById(R.id.ksad_tube_profile_back);
        this.Pc = (TextView) findViewById(R.id.ksad_tube_profile_title);
        this.apY = findViewById(R.id.ksad_tube_profile_divider);
        this.aDL = new com.kwad.components.ct.f.f<>(this);
    }

    @Override // com.kwad.components.ct.tube.channel.home.c.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
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
        com.kwad.components.ct.f.g.c(this.mRootView, Kj().aZl);
        com.kwad.components.ct.f.g.a(this.aWg, Kj().aZw);
        com.kwad.components.ct.f.g.a(this.Pc, Kj().aZm);
        com.kwad.components.ct.f.g.c(this.apY, Kj().aZn);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }
}
