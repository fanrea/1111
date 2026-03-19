package com.kwad.components.ct.tube.history.c;

import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.history.b.a {
    private TextView Pc;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pc = (TextView) findViewById(R.id.ksad_history_detail_title);
    }

    @Override // com.kwad.components.ct.tube.history.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Pc.setText("观看记录");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
