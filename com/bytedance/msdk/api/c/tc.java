package com.bytedance.msdk.api.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.gb.np;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tc {
    private static long b = -1;
    private static long c = -1;
    private static Context d;
    private static d hc;

    public static void d(final Activity activity, final List<uo> list, final int i, final int i2) {
        d(new cb() { // from class: com.bytedance.msdk.api.c.tc.1
            @Override // com.bytedance.msdk.api.c.cb
            public void d() {
                com.bytedance.msdk.core.u.hc.c.d().d(activity, list, i, i2);
            }
        });
    }

    public static void d(cb cbVar) {
        com.bytedance.msdk.core.hc.hc().d(cbVar);
    }

    public static boolean d() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.d.mk().mq())) {
            return false;
        }
        return com.bytedance.msdk.core.hc.hc().j();
    }

    public static void d(Context context, d dVar) {
        if (b == -1) {
            b = System.currentTimeMillis();
            if (dVar != null && dVar.b()) {
                com.bytedance.msdk.d.u.b.d();
                com.bytedance.sdk.component.tt.d.d();
            }
            com.bytedance.msdk.d.u.b.hc("TMe", "call init time " + b);
            d = context;
            hc = dVar;
        }
    }

    public static long hc() {
        return b;
    }

    public static long b() {
        return c;
    }

    public static void c() {
        if (d == null || hc == null) {
            return;
        }
        if (c == -1) {
            c = System.currentTimeMillis();
            com.bytedance.msdk.d.u.b.hc("TMe", "call start up time " + c);
        }
        hc(d, hc);
        com.bytedance.msdk.an.c.hc();
    }

    private static void hc(Context context, d dVar) {
        com.bytedance.msdk.core.d.mk().b(dVar.d());
        com.bytedance.msdk.core.d.mk().b(dVar.cb());
        com.bytedance.msdk.h.hc.d.d().an();
        com.bytedance.msdk.an.b.d(dVar, context.getApplicationContext());
        com.bytedance.msdk.h.hc.d.d().h();
    }

    public static void d(an anVar) {
        com.bytedance.msdk.core.d.mk().d(anVar, false);
    }

    public static void d(String str) {
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.bytedance.msdk.core.d.mk().c(str);
    }

    public static void d(com.bytedance.sdk.openadsdk.w.b.b.c cVar) {
        com.bytedance.msdk.core.d.mk().hc().hc(com.bytedance.msdk.an.hc.u.d(cVar));
        com.bytedance.msdk.core.d.mk().s();
        com.bytedance.msdk.an.b.d(com.bytedance.msdk.an.hc.u.d(cVar));
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        if (context != null) {
            com.bytedance.msdk.gb.c.d(context, intent, null);
        }
    }

    public static void d(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permissions", iArr);
        if (context != null) {
            com.bytedance.msdk.gb.c.d(context, intent, null);
        }
    }

    public static String u() {
        return com.bytedance.msdk.hc.hc.hc();
    }

    public static void d(int i) {
        HashMap map = new HashMap();
        map.put(com.bytedance.msdk.d.d.d.u, Integer.valueOf(i));
        Map<String, com.bytedance.msdk.d.d.c> mapHc = com.bytedance.msdk.an.hc.hc.d().hc();
        if (mapHc == null || mapHc.size() == 0) {
            return;
        }
        for (com.bytedance.msdk.d.d.c cVar : com.bytedance.msdk.an.hc.hc.d().b()) {
            if (cVar != null) {
                cVar.d(map);
            }
        }
    }

    public static int d(b bVar) {
        com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d("gdt");
        if (cVarD == null) {
            return 0;
        }
        return cVarD.d(bVar);
    }

    public static boolean an() {
        return com.bytedance.msdk.core.d.mk().e();
    }

    public static void hc(String str) {
        com.bytedance.msdk.core.d.mk().u(str);
    }

    public static String h() {
        return com.bytedance.msdk.core.d.mk().cb();
    }

    public static Map<String, String> gb() {
        return com.bytedance.msdk.core.d.mk().w();
    }

    public static boolean tt() {
        return com.bytedance.msdk.core.d.mk().yi();
    }

    public static String b(String str) {
        str.hashCode();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.bytedance.msdk.gb.c.c.b();
            case "tt_pangle_preview_creative_id":
                return com.bytedance.msdk.gb.c.c.hc();
            case "tt_pangle_preview_ad_id":
                return com.bytedance.msdk.gb.c.c.d();
            default:
                return null;
        }
    }

    public static String tc() {
        return com.bytedance.msdk.core.d.mk().sy();
    }

    public static String mk() {
        return com.bytedance.msdk.core.d.mk().mq();
    }

    public static String hc(Context context) {
        return np.hc();
    }

    public static boolean d(String str, String str2) {
        return com.bytedance.msdk.an.d.d(str, str2);
    }

    public static boolean hc(String str, String str2) {
        return com.bytedance.msdk.an.d.hc(str, str2);
    }

    @Deprecated
    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.bytedance.msdk.core.d.mk().mq())) {
            return false;
        }
        return com.bytedance.msdk.core.hc.hc().b(str);
    }

    @Deprecated
    public static com.bytedance.msdk.api.c.d.hc.an.d u(String str) {
        return com.bytedance.msdk.an.hc.d.d(str);
    }

    @Deprecated
    public static com.bytedance.msdk.d.d.c an(String str) {
        return com.bytedance.msdk.an.hc.hc.d().d(str);
    }

    @Deprecated
    public static void hc(int i) {
        com.bytedance.msdk.core.hc.hc().b(i);
    }

    @Deprecated
    public static void mq() {
        com.bytedance.msdk.core.hc.hc().b(com.bytedance.msdk.h.d.d().b("if_test"));
    }

    public static Map<String, Object> uo() {
        return com.bytedance.msdk.core.d.mk().nv();
    }

    public static void d(com.bytedance.msdk.api.c.d.tt.d dVar) {
        if (!com.bytedance.msdk.an.b.hc()) {
            com.bytedance.msdk.core.d.mk().d(dVar);
        } else if (dVar != null) {
            dVar.d();
        }
    }
}
