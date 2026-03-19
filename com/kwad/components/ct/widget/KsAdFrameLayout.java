package com.kwad.components.ct.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAdFrameLayout extends FrameLayout {
    private final List<GestureDetector> baM;

    public KsAdFrameLayout(Context context) {
        this(context, null);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baM = new ArrayList();
    }

    public final void a(GestureDetector gestureDetector) {
        if (gestureDetector == null || this.baM.contains(gestureDetector)) {
            return;
        }
        this.baM.add(gestureDetector);
    }

    public final void b(GestureDetector gestureDetector) {
        if (gestureDetector != null) {
            this.baM.remove(gestureDetector);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        Iterator<GestureDetector> it = this.baM.iterator();
        while (it.hasNext()) {
            zDispatchTouchEvent = it.next().onTouchEvent(motionEvent) || zDispatchTouchEvent;
        }
        return zDispatchTouchEvent;
    }
}
