package com.kwad.components.ct.tube.channel.home.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.channel.home.c.a {
    private View aWD;
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.tube.channel.home.d.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            super.n(z, z2);
            if (!z || b.this.aWq.aFU.isEmpty()) {
                return;
            }
            TubeChannelResultData tubeChannelResultData = (TubeChannelResultData) b.this.aWq.avY.akR();
            String str = tubeChannelResultData != null ? tubeChannelResultData.recommendTubeChannel.channelInfo.channelName : null;
            if (TextUtils.isEmpty(str)) {
                str = "全部剧场";
            }
            b.this.mf.setText(str);
            b.this.aWD.setVisibility(0);
        }
    };
    private TextView mf;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_tube_channel_header_title_layout, false);
        this.aWD = viewA;
        this.mf = (TextView) viewA.findViewById(R.id.ksad_tube_channel_title);
    }

    @Override // com.kwad.components.ct.tube.channel.home.c.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aWD.setVisibility(8);
        this.aWq.aFW.addHeaderView(this.aWD);
        this.aWq.avY.a(this.awa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aWq.avY.b(this.awa);
    }
}
