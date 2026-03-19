package com.tencent.turingfd.sdk.ams.au;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.turingfd.sdk.ams.au.Cthrow;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Orange extends Cif {
    public final String b;
    public final Durian c;

    public Orange(Window.Callback callback, String str, Durian durian) {
        super(callback);
        this.b = str;
        this.c = durian;
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Cif, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Pegasus pegasus;
        Durian durian = this.c;
        String str = this.b;
        Cthrow.Cdo cdo = (Cthrow.Cdo) durian;
        if (!cdo.a.get()) {
            synchronized (Pegasus.i) {
                pegasus = Pegasus.k;
                if (pegasus == null) {
                    pegasus = new Pegasus();
                } else {
                    Pegasus.k = pegasus.a;
                    Pegasus.j--;
                    pegasus.a = null;
                }
            }
            pegasus.b = str;
            pegasus.c = motionEvent.getAction();
            pegasus.d = motionEvent.getDeviceId();
            pegasus.e = motionEvent.getToolType(0);
            pegasus.f = motionEvent.getPressure();
            pegasus.g = motionEvent.getSize();
            pegasus.h = System.currentTimeMillis();
            cdo.b.obtainMessage(2, pegasus).sendToTarget();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
