package com.bytedance.d.hc.d;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends FileObserver {
    private volatile boolean b;
    private final b d;
    private final int hc;

    public d(b bVar, String str, int i) {
        super(str, i);
        this.hc = 5000;
        this.b = true;
        if (bVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.d = bVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.b && i == 8 && !TextUtils.isEmpty(str) && str.contains(Config.TRACE_PART) && this.d != null) {
            this.b = false;
            this.d.d(200, "/data/anr/".concat(String.valueOf(str)), 80);
            new C0187d(5000).start();
        }
    }

    /* renamed from: com.bytedance.d.hc.d.d$d, reason: collision with other inner class name */
    private final class C0187d extends com.bytedance.sdk.component.tc.c.b {
        private int hc;

        C0187d(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.hc = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.hc);
            d.this.b = true;
        }
    }
}
