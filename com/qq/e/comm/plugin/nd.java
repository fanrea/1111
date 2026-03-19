package com.qq.e.comm.plugin;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.FrameMetrics;
import android.view.Window;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class nd extends g0 implements Window.OnFrameMetricsAvailableListener {
    private static final String j = "nd";
    private final Handler i;

    @Override // com.qq.e.comm.plugin.g0
    String b() {
        return j;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        if (new FrameMetrics(frameMetrics).getMetric(9) == 1) {
            return;
        }
        a((int) (r4.getMetric(8) / this.b));
    }

    public nd(Activity activity, long j2) {
        super(activity, j2);
        this.i = new Handler(Looper.getMainLooper());
    }

    @Override // com.qq.e.comm.plugin.g0, com.qq.e.comm.plugin.jk
    public void start() {
        super.start();
        this.a.getWindow().addOnFrameMetricsAvailableListener(this, this.i);
    }

    @Override // com.qq.e.comm.plugin.g0
    protected void c() {
        try {
            this.a.getWindow().removeOnFrameMetricsAvailableListener(this);
        } catch (IllegalArgumentException unused) {
            b();
        }
    }
}
