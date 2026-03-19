package com.kwad.components.core.t.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends Presenter {
    private FrameLayout aac;
    private com.kwad.components.core.t.a.b aaf;
    private o aai;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aaf = (com.kwad.components.core.t.a.b) amf();
        this.aac = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.aai = this.aaf.ZW.a(null);
        this.aaf.Th.add(new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.core.t.b.b.1
            @Override // com.kwad.components.core.n.a.a
            public final void c(f fVar) {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void d(f fVar) {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hc() {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hd() {
                if (b.this.aaf.ZV != null) {
                    b.this.aaf.ZV.callbackDismiss();
                }
            }
        });
        if (this.aai == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.aai.getView();
            view.setLayoutParams(layoutParams);
            this.aac.addView(view);
            this.aai.bindActivity(getActivity());
            this.aai.render();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    public final boolean onBackPressed() {
        o oVar = this.aai;
        return oVar != null && oVar.onBackPressed();
    }
}
