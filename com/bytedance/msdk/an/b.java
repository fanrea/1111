package com.bytedance.msdk.an;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.msdk.core.hc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.gb;
import com.bytedance.msdk.gb.he;
import com.bytedance.msdk.gb.rf;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.core.fs.d;
import com.bytedance.sdk.openadsdk.core.tc;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static long an = 0;
    private static boolean b = false;
    private static long h;
    private static long hc;
    private static AtomicBoolean c = new AtomicBoolean(false);
    static Runnable d = new Runnable() { // from class: com.bytedance.msdk.an.b.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.d.u.b.d("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) an.an()).getQueue().size());
            an.d(b.d, 5000L);
        }
    };
    private static final ComponentCallbacks u = new ComponentCallbacks() { // from class: com.bytedance.msdk.an.b.3
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.bytedance.msdk.core.u.d.d.d().hc();
        }
    };

    interface hc {
        public static final String d = fs.d() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long d() {
        return hc;
    }

    public static boolean hc() {
        return b;
    }

    private static void uo() {
        com.bytedance.msdk.api.c.d.tt.d dVarWl;
        if (!b || (dVarWl = com.bytedance.msdk.core.d.mk().wl()) == null) {
            return;
        }
        dVarWl.d();
        com.bytedance.msdk.core.d.mk().d((com.bytedance.msdk.api.c.d.tt.d) null);
    }

    private static void d(boolean z) {
        b = z;
        uo();
    }

    public static void d(com.bytedance.msdk.api.c.d dVar, Context context) {
        d(context);
        d(dVar);
        hc(context);
    }

    private static void hc(final Context context) {
        com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        d(true);
        hc = SystemClock.elapsedRealtime();
        e();
        c.d(context.getApplicationContext());
        gb.d().b();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pre_time", jElapsedRealtime - hc);
        } catch (Throwable unused) {
        }
        w();
        try {
            jSONObject.put("cfg_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable unused2) {
        }
        b(context);
        com.bytedance.msdk.core.hc.hc().d(true, jSONObject, new com.bytedance.msdk.core.an.hc() { // from class: com.bytedance.msdk.an.b.1
            @Override // com.bytedance.msdk.core.an.hc
            public void d() {
                com.bytedance.msdk.core.hc.hc().d((com.bytedance.msdk.core.an.hc) null);
                an.c(new Runnable() { // from class: com.bytedance.msdk.an.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.u.b.hc(com.bytedance.msdk.core.hc.getContext());
                        b.hc(context, b.hc);
                        b.k();
                    }
                });
                b.rf();
            }
        });
        yo();
    }

    private static void b(Context context) {
        com.bytedance.msdk.u.b.d(context);
        com.bytedance.msdk.u.b.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Context context, long j) {
        if (!c.d()) {
            com.bytedance.msdk.d.u.b.d("TMe", "-----==---- 延时上报sdk_init");
            c.d(j);
        } else {
            com.bytedance.msdk.d.u.b.d("TMe", "-----==---- 正常上报sdk_init");
            c.hc(j);
        }
    }

    private static void d(com.bytedance.msdk.api.c.d dVar) throws ClassNotFoundException {
        com.bytedance.msdk.core.d.mk().d(dVar.e());
        com.bytedance.msdk.core.d.mk().d(System.currentTimeMillis());
        com.bytedance.msdk.core.d.mk().b(dVar.d());
        com.bytedance.msdk.core.d.mk().an(dVar.hc());
        com.bytedance.msdk.core.d.mk().b(dVar.cb());
        com.bytedance.msdk.core.d.mk().u(dVar.an().b());
        com.bytedance.msdk.core.d.mk().an(dVar.an().c());
        com.bytedance.msdk.core.d.mk().d(dVar.an().hc());
        com.bytedance.msdk.core.d.mk().d(dVar.an().u());
        com.bytedance.msdk.core.d.mk().d(dVar.an().an());
        com.bytedance.msdk.core.d.mk().c(dVar.an().d());
        com.bytedance.msdk.core.d.mk().c(dVar.c());
        com.bytedance.msdk.core.d.mk().hc(dVar.u());
        com.bytedance.msdk.core.d.mk().u(dVar.an().h());
        com.bytedance.msdk.core.d.mk().d(dVar.an().gb());
        com.bytedance.msdk.core.d.mk().d(dVar.tt(), true);
        com.bytedance.msdk.core.d.mk().h(dVar.an().tt());
        com.bytedance.msdk.core.d.mk().hc(dVar.tc());
        com.bytedance.msdk.core.d.mk().b(dVar.k());
        com.bytedance.msdk.core.d.mk().h(dVar.mk());
        com.bytedance.msdk.core.d.mk().gb(dVar.mq());
        com.bytedance.msdk.core.d.mk().d(dVar.uo());
        com.bytedance.msdk.core.d.mk().tt(dVar.h().hc());
        com.bytedance.msdk.core.d.mk().gb(dVar.h().d());
        com.bytedance.msdk.core.d.mk().tc(dVar.h().b());
        com.bytedance.msdk.core.d.mk().mk(dVar.h().c());
        if (dVar.k() != null) {
            try {
                com.bytedance.msdk.core.d.mk().d((List<String>) dVar.k().get("primeRitList"));
            } catch (Throwable unused) {
            }
        }
        if (dVar.gb() != null) {
            com.bytedance.msdk.core.d.mk().hc(dVar.gb().d());
        }
    }

    public static void d(SparseArray<Object> sparseArray) {
        for (com.bytedance.msdk.d.d.c cVar : com.bytedance.msdk.an.hc.hc.d().b()) {
            if (cVar != null) {
                try {
                    cVar.d(com.bytedance.msdk.core.d.mk().j(), sparseArray);
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
    }

    public static String b() {
        try {
            com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d("pangle");
            return cVarD != null ? cVarD.b() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void d(Context context) {
        if (context != null) {
            com.bytedance.msdk.core.hc.d(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        Application applicationD = hc.d.d();
        if (applicationD == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "lowMemoryListener注册失败, app = null");
            return;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = u;
        applicationD.unregisterComponentCallbacks(componentCallbacks);
        applicationD.registerComponentCallbacks(componentCallbacks);
    }

    private static void e() {
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "AppStateListener开始注册");
        com.bytedance.sdk.openadsdk.core.fs.d dVarC = tc.w().c();
        if (dVarC != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "AppStateListener注册成功");
            dVarC.d(new d.hc() { // from class: com.bytedance.msdk.an.b.4
                public void d() {
                    if (tc.w().us()) {
                        return;
                    }
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- AppStateListener on foreground");
                    long unused = b.an = SystemClock.elapsedRealtime();
                    com.bytedance.msdk.core.hc.d.b();
                }

                public void hc() {
                    if (tc.w().us()) {
                        return;
                    }
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- AppStateListener on background");
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = jElapsedRealtime - b.an;
                    com.bytedance.msdk.u.an.hc(j);
                    com.bytedance.msdk.core.d.mk().hc(j);
                    com.bytedance.msdk.u.hc.hc.d = true;
                    if (jElapsedRealtime - b.h < com.alipay.sdk.m.u.b.a) {
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "badkground too frequently ms: " + (jElapsedRealtime - b.h));
                        return;
                    }
                    if (com.bytedance.msdk.u.b.hc()) {
                        long unused = b.h = jElapsedRealtime;
                        if (!he.d(com.bytedance.msdk.core.hc.getContext())) {
                            b.cb();
                        } else {
                            com.bytedance.msdk.u.b.b();
                        }
                    }
                }
            });
        }
        if (com.bytedance.msdk.core.d.mk().uo()) {
            try {
                com.bytedance.msdk.core.hc.getContext().registerReceiver(new d(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), hc.d, null);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cb() {
        if (com.bytedance.msdk.core.hc.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(fs.d());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.bytedance.msdk.core.hc.getContext().sendBroadcast(intent, hc.d);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    private static class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || tc.w().us()) {
                return;
            }
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (he.d(context)) {
                        com.bytedance.msdk.u.b.b();
                    } else {
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        }
    }

    public static void c() {
        Context context;
        if (c.get()) {
            return;
        }
        com.bytedance.msdk.d.u.b.hc("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + com.bytedance.msdk.core.hc.hc().s());
        if (com.bytedance.msdk.core.hc.hc().s() && (context = com.bytedance.msdk.core.hc.getContext()) != null) {
            try {
                com.bytedance.msdk.c.hc.d().hc().d(context, true, new com.bytedance.msdk.c.d(context));
            } catch (Exception unused) {
            }
            c.set(true);
        }
    }

    public static void u() {
        com.bytedance.msdk.core.hc.hc().hc(1);
        if (!c.get()) {
            c();
        }
        Context context = com.bytedance.msdk.core.hc.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.msdk.d.u.b.hc("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
            com.bytedance.msdk.c.hc.d().hc().d(context, false);
        } catch (Exception unused) {
        }
    }

    private static void w() {
        try {
            com.bytedance.msdk.core.hc.hc().d(true);
        } catch (Throwable th) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    private static void yo() {
        com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc()).d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rf() {
        if (com.bytedance.msdk.core.hc.hc().zw()) {
            jh();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.an.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.jh();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jh() {
        if (com.bytedance.msdk.core.hc.hc().us()) {
            Map<String, String> mapZ = com.bytedance.msdk.core.hc.hc().z();
            com.bytedance.msdk.u.an.d((com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, rf.d(), 1);
            com.bytedance.msdk.u.an.d(rf.d(mapZ));
        }
    }
}
