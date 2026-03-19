package com.bytedance.msdk.an;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.u.an;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static volatile d b;
    private static Context d;
    private static volatile d hc;

    public static void d(Context context) {
        d = context;
    }

    public static void d(long j) {
        d dVar = new d("sdk_init", j, 0L, 0, 0, null, null);
        hc = dVar;
        dVar.d();
    }

    public static void d(long j, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
        d dVar = new d(ILogConst.EVENT_SDK_INIT_END, -1L, j, i, i2, jSONObject, map);
        b = dVar;
        dVar.d();
    }

    public static boolean d() {
        return !TextUtils.isEmpty(np.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u() {
        return np.d();
    }

    private static class d {
        private final int an;
        private final String b;
        private final long c;
        private final Handler d;
        private final long gb;
        private final JSONObject h;
        private Map<String, Object> tc;
        private final int u;
        private volatile boolean hc = false;
        private int tt = 0;

        static /* synthetic */ int hc(d dVar) {
            int i = dVar.tt;
            dVar.tt = i + 1;
            return i;
        }

        public d(String str, long j, long j2, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
            this.gb = j == -1 ? System.currentTimeMillis() : j;
            this.b = str;
            this.c = j2;
            this.u = i;
            this.an = i2;
            this.h = jSONObject;
            this.tc = map;
            this.d = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.d.postDelayed(new Runnable() { // from class: com.bytedance.msdk.an.c.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.hc(d.this);
                    if (d.this.tt >= 5 || c.d()) {
                        d.this.d(1);
                    } else {
                        com.bytedance.msdk.d.u.b.d("TMe", "--==-- 重试一次 eventType:" + d.this.b + ", 重试次数：" + d.this.tt);
                        d.this.d();
                    }
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void d(int i) {
            this.d.removeCallbacksAndMessages(null);
            if (this.hc) {
                return;
            }
            this.hc = true;
            if (i == 1) {
                com.bytedance.msdk.d.u.b.d("TMe", "--==-- 最终上报：eventType:" + this.b + ", 重试次数：" + this.tt + ", did: " + c.u());
            } else if (i == 2) {
                com.bytedance.msdk.d.u.b.d("TMe", "--==-- 最终上报：eventType:" + this.b + ", 从applog回调中上报, did: " + c.u());
            }
            String str = this.b;
            char c = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != -834688111) {
                if (iHashCode == 270071285 && str.equals("sdk_init")) {
                    c = 0;
                }
            } else if (str.equals(ILogConst.EVENT_SDK_INIT_END)) {
                c = 1;
            }
            if (c == 0) {
                c.hc(this.gb);
            } else {
                if (c == 1) {
                    c.d(this.c, this.u, this.an, this.gb, this.h, this.tc);
                }
            }
        }
    }

    public static void hc() {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_start_up").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.1
            @Override // java.lang.Runnable
            public void run() {
                an.hc();
            }
        });
    }

    public static void b() {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_mediation_sdk_init").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.2
            @Override // java.lang.Runnable
            public void run() {
                an.d();
            }
        });
    }

    public static void hc(final long j) {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_sdk_init").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.3
            @Override // java.lang.Runnable
            public void run() {
                an.d(j);
            }
        });
    }

    public static void d(final long j, final int i, final int i2, final long j2, final JSONObject jSONObject, final Map<String, Object> map) {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_sdk_init_end").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.4
            @Override // java.lang.Runnable
            public void run() {
                an.d(j, i, i2, j2, jSONObject, (Map<String, Object>) map);
            }
        });
    }

    public static void d(final boolean z) {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_get_config_start").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.5
            @Override // java.lang.Runnable
            public void run() {
                an.d(z);
            }
        });
    }

    public static void d(final int i, final int i2, final long j, final boolean z, final boolean z2, final JSONObject jSONObject, final long j2, final JSONObject jSONObject2) {
        new com.bytedance.sdk.openadsdk.core.c.hc("track_get_config_final").hc(new Runnable() { // from class: com.bytedance.msdk.an.c.6
            @Override // java.lang.Runnable
            public void run() {
                an.d(i, i2, j, z, z2, jSONObject, j2, jSONObject2);
            }
        });
    }
}
