package com.kwad.components.ct.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends RefreshLayout {
    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    protected final View IE() {
        return null;
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (f.isFullScreen()) {
            setRefreshInitialOffset((-com.kwad.sdk.c.a.a.getStatusBarHeight(context)) - com.kwad.sdk.c.a.a.a(context, 30.0f));
        }
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    protected void a(AttributeSet attributeSet) {
        m.a(getContext(), R.layout.ksad_content_alliance_shoot_refresh_view, this, true);
        this.aSi = findViewById(R.id.ksad_slide_shoot_refresh_view);
        this.aSi.setVisibility(8);
        if (this.aSi instanceof d) {
            this.aSj = (d) this.aSi;
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    @Override // com.kwad.components.ct.refreshview.RefreshLayout
    protected b GR() {
        return new a(getContext());
    }

    public final void i(MotionEvent motionEvent) {
        if (isRefreshing()) {
            return;
        }
        super.onInterceptTouchEvent(motionEvent);
    }

    public final void j(MotionEvent motionEvent) {
        if (isRefreshing()) {
            return;
        }
        super.onTouchEvent(motionEvent);
    }
}
