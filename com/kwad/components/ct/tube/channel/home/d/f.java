package com.kwad.components.ct.tube.channel.home.d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.tube.channel.home.c.a {
    private TextView Pc;
    private FrameLayout aTs;
    private ImageView aWg;
    private com.kwad.sdk.lib.b.c<TubeChannelResultData, TubeInfo> avY;
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.tube.channel.home.d.f.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            super.n(z, z2);
            if (f.this.aWq.aWo.mPageScene != 25 || f.this.avY.akR() == null) {
                f.this.Pc.setText(f.this.getContext().getString(R.string.ksad_tube_recommend_title));
            } else if (TextUtils.isEmpty(((TubeChannelResultData) f.this.avY.akR()).title)) {
                f.this.Pc.setText(f.this.getContext().getString(R.string.ksad_tube_enter_title));
            } else {
                f.this.Pc.setText(((TubeChannelResultData) f.this.avY.akR()).title);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aWg = (ImageView) findViewById(R.id.ksad_tube_profile_back);
        this.Pc = (TextView) findViewById(R.id.ksad_tube_profile_title);
        this.aTs = (FrameLayout) findViewById(R.id.ksad_tube_profile_title_bar);
    }

    @Override // com.kwad.components.ct.tube.channel.home.c.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.lib.b.c cVar = this.aWq.avY;
        this.avY = cVar;
        cVar.a(this.awa);
        if (this.aWq.aWo.mTubeParam.showTitleBar) {
            this.aTs.setVisibility(0);
            this.aWg.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.channel.home.d.f.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Activity activity = f.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
        } else {
            this.aTs.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        this.avY.b(this.awa);
        super.onUnbind();
    }
}
