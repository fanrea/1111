package com.kwad.components.ct.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.refreshview.b;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeRefreshLayout extends RefreshLayout {
    public TubeRefreshLayout(Context context) {
        super(context);
    }

    public TubeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public final View IE() {
        return com.kwad.sdk.c.a.a.a((ViewGroup) this, R.layout.ksad_tube_refresh_view, false);
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    public final b GR() {
        return new com.kwad.components.ct.refreshview.a(getContext());
    }
}
