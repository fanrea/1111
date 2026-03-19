package com.kwad.components.ct.tube.channel.home.b.b;

import android.widget.TextView;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.tube.channel.home.b.a.b implements com.kwad.components.ct.f.b {
    private f<d> aDL;
    private TextView aVZ;
    private TextView aWa;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aVZ = (TextView) findViewById(R.id.ksad_tube_name);
        this.aWa = (TextView) findViewById(R.id.ksad_tube_desc);
        this.aDL = new f<>(this);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        g.a(this.aVZ, Kj().aZq);
        g.a(this.aWa, Kj().aZr);
    }
}
