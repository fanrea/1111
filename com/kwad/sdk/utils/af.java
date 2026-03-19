package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class af {
    private static AtomicInteger cmg = new AtomicInteger(0);
    private static volatile boolean cmh = false;
    private static volatile boolean cmi;

    private static int aoj() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int iUp = hVar.Up();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "config mode:" + iUp);
        return iUp;
    }

    private static void aok() {
        if (cmh) {
            return;
        }
        cmg.set(aon());
        cmi = bp.o("kssdk_kv_mode", "downgrade", false);
        cmh = true;
    }

    public static void az(final String str, final String str2) {
        h.execute(new bh() { // from class: com.kwad.sdk.utils.af.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    int iC = bp.c("ksadsdk_kv_perf", str, 0);
                    if (TextUtils.isEmpty(str2)) {
                        bp.aE("ksadsdk_kv_perf", str);
                    } else {
                        bp.b("ksadsdk_kv_perf", str, iC + 1);
                    }
                } catch (Exception e) {
                    bp.aE("ksadsdk_kv_perf", str);
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        });
    }

    public static void aA(final String str, final String str2) {
        h.execute(new bh() { // from class: com.kwad.sdk.utils.af.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                SharedPreferences sharedPreferencesIH = bp.iH("ksadsdk_kv_perf");
                if (sharedPreferencesIH != null && sharedPreferencesIH.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bp.b("ksadsdk_kv_perf_failed", str, bp.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bp.b("ksadsdk_kv_perf_success", str, bp.c("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    public static void aol() {
        if (aoo() || aoj() == 0) {
            return;
        }
        h.execute(new bh() { // from class: com.kwad.sdk.utils.af.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.utils.b.a aVarAom = af.aom();
                if (aVarAom == null) {
                    return;
                }
                af.c(aVarAom);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(aVarAom);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.kwad.sdk.utils.b.a aVar) {
        if (aVar.cpp / (aVar.cpp + aVar.cpq) > 0.10000000149011612d) {
            cmi = true;
            com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "need downgrade");
            bp.n("kssdk_kv_mode", "downgrade", true);
        }
        if (cmi) {
            aor();
        }
    }

    public static com.kwad.sdk.utils.b.a aom() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences sharedPreferencesIH = bp.iH("ksadsdk_kv_perf");
        if (sharedPreferencesIH == null) {
            return null;
        }
        try {
            all = sharedPreferencesIH.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next().getValue()).intValue();
        }
        aVar.cpo = iIntValue;
        SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            editorEdit.putInt(it2.next().getKey(), 0);
        }
        editorEdit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesIH = bp.iH("ksadsdk_kv_perf_failed");
        int iIntValue = 0;
        if (sharedPreferencesIH != null) {
            Map<String, ?> all = sharedPreferencesIH.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    iIntValue += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.cpp = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        aVar.cpp = 0;
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences sharedPreferencesIH = bp.iH("ksadsdk_kv_perf_success");
        int iIntValue = 0;
        if (sharedPreferencesIH != null) {
            Map<String, ?> all = sharedPreferencesIH.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    iIntValue += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.cpq = iIntValue;
            SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        aVar.cpq = 0;
    }

    private static int aon() {
        int iC = bp.c("kssdk_kv_mode", ILogConst.Keys.KEY_MODE, 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "local mode:" + iC);
        return iC;
    }

    static void ht(int i) {
        bp.b("kssdk_kv_mode", ILogConst.Keys.KEY_MODE, i);
    }

    private static boolean aoo() {
        aok();
        return cmg.get() == 0;
    }

    private static boolean iq(String str) {
        return i.a.bqv.contains(str);
    }

    public static boolean ir(String str) {
        boolean z = aoo() || !iq(str);
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "shouldUseModeSp:" + z);
        return z;
    }

    private static boolean aop() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static int aoq() {
        aok();
        int iAoj = (cmi || !aop()) ? 0 : aoj();
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "targetMode:" + iAoj);
        return iAoj;
    }

    public static void aor() {
        aok();
        int i = cmg.get();
        int iAoq = aoq();
        boolean z = i != iAoq;
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(iAoq);
        }
    }

    private static void transfer(int i) {
        if (i == 0) {
            aos();
        } else if (i == 1) {
            aot();
        }
    }

    private static void aos() {
        h.execute(new bh() { // from class: com.kwad.sdk.utils.af.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                Context context;
                try {
                    context = ag.getContext();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                Iterator it = i.a.bqv.iterator();
                while (it.hasNext()) {
                    af.ag(context, (String) it.next());
                }
                af.ht(0);
                af.cmg.set(0);
            }
        });
    }

    private static void aot() {
        com.kwad.sdk.core.d.c.d("Ks_UnionHelper", "transferToKv");
        h.execute(new bh() { // from class: com.kwad.sdk.utils.af.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    Context context = ag.getContext();
                    if (context != null) {
                        Iterator it = i.a.bqv.iterator();
                        while (it.hasNext()) {
                            af.af(context, (String) it.next());
                        }
                        af.ht(1);
                        af.cmg.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void af(Context context, String str) throws IOException {
        SharedPreferences sharedPreferencesIH;
        com.kwad.sdk.utils.a.c cVarAN = com.kwad.sdk.utils.a.e.aN(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (sharedPreferencesIH = bp.iH(str)) == null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (cVarAN.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences sharedPreferencesIH2 = bp.iH(str);
        if (sharedPreferencesIH2 == null) {
            cVarAN.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        cVarAN.putAll(sharedPreferencesIH2.getAll());
        cVarAN.putBoolean("sp_to_kv_transfer_flag", true);
        bp.aE(str, "kv_to_sp_transfer_flag");
        a(str, cVarAN);
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) throws IOException {
        if (i.a.bqw.contains(str)) {
            return;
        }
        cVar.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ag(Context context, String str) throws IOException {
        SharedPreferences sharedPreferencesIH = bp.iH(str);
        if (sharedPreferencesIH == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesIH.edit();
            if (editorEdit != null) {
                editorEdit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (sharedPreferencesIH.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.a.c cVarAN = com.kwad.sdk.utils.a.e.aN(context, str);
        Map<String, Object> all = cVarAN.getAll();
        if (all.isEmpty()) {
            bp.n(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        bp.a(str, all);
        bp.n(str, "kv_to_sp_transfer_flag", true);
        cVarAN.remove("sp_to_kv_transfer_flag");
        cVarAN.release();
    }
}
