package com.bytedance.msdk.an.hc;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.an.d.k;
import com.bytedance.msdk.an.d.mq;
import com.bytedance.msdk.an.d.tc;
import com.bytedance.msdk.an.d.uo;
import com.kwad.sdk.api.model.AdnName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    protected com.bytedance.msdk.core.an.hc b;
    private boolean gb;
    private boolean h;
    private static final com.bytedance.msdk.core.an.d c = new com.bytedance.msdk.core.an.d();
    private static Map<String, Pair<Boolean, String>> u = new ConcurrentHashMap();
    private static Map<String, com.bytedance.msdk.an.d.b> an = new ConcurrentHashMap();
    protected final AtomicBoolean d = new AtomicBoolean(false);
    protected final AtomicBoolean hc = new AtomicBoolean(false);

    public static void d(String str, Pair<Boolean, String> pair) {
        u.put(str, pair);
    }

    public static int d() {
        return u.size();
    }

    protected d() {
    }

    public static d hc() {
        return new d();
    }

    public static synchronized void b() {
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.an.hc.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                for (Map.Entry entry : d.u.entrySet()) {
                    if (entry.getValue() != null) {
                        if (((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                            if (com.bytedance.msdk.core.hc.hc().b((String) entry.getKey())) {
                                com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                            } else {
                                com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                            }
                        } else {
                            com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                        }
                    }
                }
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
            }
        });
    }

    public static com.bytedance.msdk.core.an.d c() {
        return c;
    }

    public static String d(Map<String, Object> map, String str) {
        return c.d(com.bytedance.msdk.core.hc.getContext(), map, str);
    }

    public static Map<String, Object> hc(Map<String, Object> map, String str) {
        return c.hc(com.bytedance.msdk.core.hc.getContext(), map, str);
    }

    public static com.bytedance.msdk.api.c.d.hc.an.d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.d(str);
    }

    protected void d(Context context) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.an.hc.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.u();
                d.this.an();
                d.this.d.set(true);
                d.this.cb();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.bytedance.msdk.d.u.an.b(runnable);
        }
    }

    protected void hc(final Context context) {
        tc();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.an.hc.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.mq();
                d.this.h();
                d.this.gb();
                d.this.e();
                d.this.tt();
                d.this.mk();
                d.uo();
                d.k();
                com.bytedance.msdk.an.hc.d(context);
                d.this.hc.set(true);
                d.this.cb();
            }
        });
    }

    protected void u() {
        com.bytedance.msdk.an.d.b bVarB = b("klevin");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void an() {
        com.bytedance.msdk.an.d.b bVarB = b("mintegral");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void h() {
        com.bytedance.msdk.an.d.b bVarB = b(AdnName.BAIDU);
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void gb() {
        com.bytedance.msdk.an.d.b bVarB = b("pangle");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void tt() {
        com.bytedance.msdk.an.d.b bVarB = b("admob");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void tc() {
        yo();
    }

    private void yo() {
        com.bytedance.msdk.an.d.b bVarB = b("gdt");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void mk() {
        com.bytedance.msdk.an.d.b bVarB = b("sigmob");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    protected void mq() {
        com.bytedance.msdk.an.d.b bVarB = b("ks");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    public static void uo() {
        com.bytedance.msdk.an.d.b bVarB = b("unity");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    public static void k() {
        com.bytedance.msdk.an.d.b bVarB = b("xiaomi");
        if (bVarB != null) {
            bVarB.an();
        }
    }

    public void d(Context context, boolean z, boolean z2, com.bytedance.msdk.core.an.hc hcVar) {
        this.b = hcVar;
        this.d.set(false);
        this.hc.set(false);
        this.h = z;
        this.gb = z2;
        b(context);
    }

    protected void b(Context context) {
        hc(context);
        d(context);
    }

    protected void e() {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.an.hc.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.b != null) {
                    d.this.b.d();
                }
            }
        });
    }

    protected void cb() {
        if (!this.h && this.gb && this.d.get() && this.hc.get()) {
            com.bytedance.msdk.an.d.d();
            b();
        }
    }

    public static void hc(String str) throws ExecutionException, InterruptedException {
        final com.bytedance.msdk.an.d.b bVarB;
        if (TextUtils.equals("pangle", str) || (bVarB = b(str)) == null) {
            return;
        }
        if ((TextUtils.equals("mintegral", str) || TextUtils.equals("klevin", str)) && !com.bytedance.msdk.d.u.an.u()) {
            if (bVarB.u()) {
                return;
            }
            com.bytedance.msdk.d.u.an.hc(new Runnable() { // from class: com.bytedance.msdk.an.hc.d.5
                @Override // java.lang.Runnable
                public void run() {
                    bVarB.gb();
                }
            });
            return;
        }
        bVarB.gb();
    }

    private static synchronized com.bytedance.msdk.an.d.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.an.d.b bVarTt = an.get(str);
        if (bVarTt != null) {
            return bVarTt;
        }
        if (com.bytedance.msdk.core.hc.hc().d(str) == null) {
            return null;
        }
        switch (str) {
            case "pangle":
            case "pangle_custom":
                bVarTt = tc.tt();
                break;
            case "gdt":
                bVarTt = new com.bytedance.msdk.an.d.u();
                break;
            case "baidu":
                bVarTt = new com.bytedance.msdk.an.d.hc();
                break;
            case "ks":
                bVarTt = new com.bytedance.msdk.an.d.h();
                break;
            case "klevin":
                bVarTt = new com.bytedance.msdk.an.d.an();
                break;
            case "mintegral":
                bVarTt = new com.bytedance.msdk.an.d.gb();
                break;
            case "admob":
                bVarTt = new com.bytedance.msdk.an.d.d();
                break;
            case "sigmob":
                bVarTt = new mq();
                break;
            case "unity":
                bVarTt = new uo();
                break;
            case "xiaomi":
                bVarTt = new k();
                break;
        }
        if (bVarTt != null) {
            an.put(str, bVarTt);
        }
        return bVarTt;
    }
}
