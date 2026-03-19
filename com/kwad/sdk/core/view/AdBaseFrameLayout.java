package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.widget.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdBaseFrameLayout extends FrameLayout implements h, i {
    private static final aj.a aDV = new aj.a();
    private List<View.OnTouchListener> bJS;
    private g bJT;

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.bJS = new ArrayList();
        this.bJT = new g();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJS = new ArrayList();
        this.bJT = new g();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJS = new ArrayList();
        this.bJT = new g();
    }

    @Override // com.kwad.sdk.core.view.h
    public g getWindowFocusChangeHelper() {
        return this.bJT;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z);
        this.bJT.l(this, z);
    }

    public final void a(View.OnTouchListener onTouchListener) {
        if (this.bJS.contains(onTouchListener)) {
            return;
        }
        this.bJS.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.bJS.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.bJS.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            aj.a aVar = aDV;
            aVar.ac(getWidth(), getHeight());
            aVar.p(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aDV.q(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.i
    public aj.a getTouchCoords() {
        return aDV;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            com.kwad.sdk.service.d.gatherException(th);
        }
    }
}
