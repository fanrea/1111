package com.kwad.components.ct.detail.photo.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private ViewGroup aqG;
    private com.kwad.sdk.widget.swipe.a aqH = new com.kwad.sdk.widget.swipe.b() { // from class: com.kwad.components.ct.detail.photo.a.c.1
        @Override // com.kwad.sdk.widget.swipe.b, com.kwad.sdk.widget.swipe.a
        public final void j(float f) {
            c.this.i(f);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aqG = (ViewGroup) findViewById(R.id.ksad_video_bottom_container);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        i(this.aop.aok.getSourceType() == 0 ? 1.0f : 0.0f);
        this.aop.aot.add(this.aqH);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aot.remove(this.aqH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f) {
        this.aqG.setAlpha(f);
        this.aqG.setVisibility(f == 0.0f ? 8 : 0);
    }
}
