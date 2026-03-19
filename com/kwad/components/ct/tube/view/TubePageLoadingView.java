package com.kwad.components.ct.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.components.ct.f.b;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.widget.KSPageLoadingView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubePageLoadingView extends KSPageLoadingView implements b {
    private f<TubePageLoadingView> aDL;

    public TubePageLoadingView(Context context) {
        super(context);
    }

    public TubePageLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TubePageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ct.widget.KSPageLoadingView
    public final boolean d(AttributeSet attributeSet) {
        return d.Kb().wR() != 1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.aDL = new f<>(this);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        this.aZB = d.Kb().wR() != 1;
        Ke();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        d.Kb().b(this.aDL);
        super.af();
    }
}
