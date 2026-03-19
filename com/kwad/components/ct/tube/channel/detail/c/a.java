package com.kwad.components.ct.tube.channel.detail.c;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.tube.channel.detail.b.a {
    private ImageView aWg;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aWg = (ImageView) findViewById(R.id.ksad_channel_detail_back);
    }

    @Override // com.kwad.components.ct.tube.channel.detail.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aWg.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.channel.detail.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Activity activity = a.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                com.kwad.components.ct.e.b.JK().h(a.this.aVW.mSceneImpl);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
