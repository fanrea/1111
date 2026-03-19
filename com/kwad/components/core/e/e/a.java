package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment RF;
    private final View RG;
    private a.C0469a RH;

    public a(Context context, DialogFragment dialogFragment, a.C0469a c0469a) {
        super(context);
        this.RF = dialogFragment;
        this.RH = c0469a;
        m.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.RG = findViewById(R.id.ksad_second_confirm_root_view);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        Presenter presenterBI = bI();
        presenterBI.ak(this.RG);
        presenterBI.K(qg());
    }

    private static Presenter bI() {
        Presenter presenter = new Presenter();
        presenter.d(new d());
        return presenter;
    }

    private c qg() {
        c cVar = new c();
        cVar.RF = this.RF;
        cVar.RH = this.RH;
        return cVar;
    }
}
