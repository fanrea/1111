package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xg extends FrameLayout {
    private long a;
    private a b;

    /* compiled from: A */
    public interface a {
        void a();
    }

    public xg(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - this.a > 1000) {
                this.a = jElapsedRealtime;
                this.b.a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
