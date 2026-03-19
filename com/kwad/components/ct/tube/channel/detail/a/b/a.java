package com.kwad.components.ct.tube.channel.detail.a.b;

import android.view.View;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.ChannelDetailParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.channel.detail.a.a.a implements View.OnClickListener {
    private ChannelDetailParam aVX;
    private TubeInfo aVY;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        getRootView().setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aVX = ((com.kwad.components.ct.tube.channel.detail.a.a.b) this.cdN).aVU;
        this.aVY = (TubeInfo) ((com.kwad.components.ct.tube.channel.detail.a.a.b) this.cdN).cdM;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ct.tube.d.b.a(getActivity(), this.aVX.mEntryScene, this.aVX.mKSTubeParam, this.aVY);
        com.kwad.components.ct.e.b.JK().b(((com.kwad.components.ct.tube.channel.detail.a.a.b) this.cdN).mSceneImpl, this.aVY);
    }
}
