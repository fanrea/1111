package com.kwad.tachikoma.v;

import android.content.Context;
import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends com.tk.core.component.f {
    private a Fs;

    public interface a {
        boolean dispatchTouchEvent(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.tk.core.component.f, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent;
        a aVar = this.Fs;
        return (aVar == null || !(zDispatchTouchEvent = aVar.dispatchTouchEvent(motionEvent))) ? super.dispatchTouchEvent(motionEvent) : zDispatchTouchEvent;
    }

    public final void a(a aVar) {
        this.Fs = aVar;
    }
}
