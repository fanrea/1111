package com.kwad.components.ct.horizontal.news.c;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.horizontal.news.b.a {
    private KSPageLoadingView aFX;
    private final com.kwad.components.ct.horizontal.news.f aNS = new com.kwad.components.ct.horizontal.news.f() { // from class: com.kwad.components.ct.horizontal.news.c.f.2
        @Override // com.kwad.components.ct.horizontal.news.f
        public final void HV() {
            f.this.aFX.Fi();
        }

        @Override // com.kwad.components.ct.horizontal.news.f
        public final void aN() {
            f.this.aFX.hide();
        }

        @Override // com.kwad.components.ct.horizontal.news.f
        public final void HW() {
            if (ao.isNetworkConnected(f.this.aFX.getContext())) {
                f.this.aFX.cd(true);
            } else {
                f.this.aFX.cc(false);
            }
        }
    };
    private final KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.horizontal.news.c.f.3
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            f.this.Io();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KSPageLoadingView kSPageLoadingView = (KSPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.aFX = kSPageLoadingView;
        kSPageLoadingView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.horizontal.news.c.f.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aNz.aNK.add(this.aNS);
        this.aFX.setRetryClickListener(this.asf);
        this.aFX.Fi();
        this.aFX.setScene(this.aNz.mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aNz.aNK.remove(this.aNS);
        this.aFX.setRetryClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        Iterator<KSPageLoadingView.a> it = this.aNz.aNL.iterator();
        while (it.hasNext()) {
            it.next().zP();
        }
    }
}
