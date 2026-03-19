package com.kwad.components.core.webview.tachikoma.d;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends Presenter {
    private FrameLayout aac;
    private o aai;
    private e ahi;
    protected b ajp;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aac = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        b bVar = (b) amf();
        this.ajp = bVar;
        e eVar = bVar.ahi;
        this.ahi = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.d.1
                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void he() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void hm() {
                }
            });
        }
        o oVarA = this.ajp.ajs.a(null);
        this.aai = oVarA;
        if (oVarA == null) {
            this.ajp.ajr.callbackPageStatus(false, null);
            this.ahi.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.aai.getView();
        view.setLayoutParams(layoutParams);
        this.aac.addView(view);
        this.aai.render();
        this.ajp.ajr.callbackPageStatus(true, null);
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
