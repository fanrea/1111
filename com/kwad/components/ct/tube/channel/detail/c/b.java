package com.kwad.components.ct.tube.channel.detail.c;

import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.channel.detail.b.a {
    private TextView Pc;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Pc = (TextView) findViewById(R.id.ksad_channel_detail_title);
    }

    @Override // com.kwad.components.ct.tube.channel.detail.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Pc.setText(this.aVW.aVU.mChannelInfo.channelName);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
