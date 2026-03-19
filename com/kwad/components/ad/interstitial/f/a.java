package com.kwad.components.ad.interstitial.f;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private ComplianceTextView nV;
    private OrientationEventListener nW;
    private KsAutoCloseView nX;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nV = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.nX = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) amf();
        b(cVar);
        a(cVar);
    }

    private void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.mN.getContext()) { // from class: com.kwad.components.ad.interstitial.f.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                a.this.b(cVar);
            }
        };
        this.nW = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.nW.enable();
        } else {
            this.nW.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        i(this.nV);
        if (!aq.isOrientationPortrait()) {
            com.kwad.sdk.c.a.a.b(this.nX, 0, 0, 0, 0);
        } else {
            com.kwad.sdk.c.a.a.b(this.nX, 0, com.kwad.sdk.c.a.a.a(getContext(), 25.0f), 0, 0);
        }
        this.nV.setVisibility(0);
        this.nV.setAdTemplate(cVar.mAdTemplate);
    }

    private void i(View view) {
        int iA = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        int iA2 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.a.a.b(view, iA2, iA, iA2, 0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.nW;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
