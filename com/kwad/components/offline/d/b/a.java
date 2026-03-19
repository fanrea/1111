package com.kwad.components.offline.d.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.tachikoma.TkOfflineCompoImpl;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static long bcB;
    private static final AtomicBoolean bbg = new AtomicBoolean(false);
    private static final String bcv = ah.format("lib%s.so", TkOfflineCompoImpl.SO_TK_RUNTIME);
    private static final String bcw = ah.format("lib%s.so", TkOfflineCompoImpl.SO_TK_RUNTIME_LITE);
    private static final String bcx = ah.format("lib%s.so", TkOfflineCompoImpl.SO_TK_V8);
    private static final String bcy = ah.format("lib%s.so", TkOfflineCompoImpl.SO_TK_V8_LITE);
    private static final String bcz = ah.format("lib%s.so", TkOfflineCompoImpl.SO_FB);
    private static final String bcA = ah.format("lib%s.so", TkOfflineCompoImpl.SO_YOGA);
    private static final String bbh = ah.format("lib%s.so", "c++_shared");
    private static Boolean bcC = null;

    public static boolean useTkLite() {
        if (bcC == null) {
            bcC = Boolean.valueOf(!e.a(c.bxy));
        }
        return bcC.booleanValue();
    }

    public static void a(Context context, final SoLoadListener soLoadListener) {
        String strXO;
        String str;
        String str2;
        AtomicBoolean atomicBoolean = bbg;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> map = new HashMap<>();
        boolean zUseTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            strXO = e.XP();
            if (TextUtils.isEmpty(strXO)) {
                strXO = zUseTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_3358";
            }
            str = zUseTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = zUseTkLite ? "0e2d6748c990aa021d01521b6926a5d1" : "581986671ff8549adfa5bcc94410a6d5";
            if (zUseTkLite) {
                map.put(bcw, "0666493e16b18f08ec178a949c41ce30");
                map.put(bcy, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                map.put(bcv, "a72b02a82df72cd82a3acace986099ad");
                map.put(bcx, "7316cd8d074b04e6cb21486288d314ce");
            }
            map.put(bcz, "31f065607e6da6b741330d1df0b35460");
            map.put(bcA, "76308532f64b68fd5a930c42cceec22b");
            map.put(bbh, "2e989e1c8d777ce169376feb637530e9");
        } else {
            strXO = e.XO();
            if (TextUtils.isEmpty(strXO)) {
                strXO = zUseTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_3358";
            }
            str = zUseTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = zUseTkLite ? "e9821df3990aca6fc2cd6b5b71c5a1df" : "16335fa1eb7d19586a6be6aa74778b5b";
            if (zUseTkLite) {
                map.put(bcw, "cb8a97957aa4cb944a27f4353be3384c");
                map.put(bcy, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                map.put(bcv, "75ae8eff358638dcddad68117cbbc494");
                map.put(bcx, "519ba633e88efafb8fbd536d800da734");
            }
            map.put(bcz, "eff11bebb8a3c872fa30b0484b460d12");
            map.put(bcA, "2c6f402c6a565d2e6912b0013fa59380");
            map.put(bbh, "2ce4deb75b884953f20ab2e6e149be98");
        }
        b bVar = new b();
        bVar.bje = com.kwad.sdk.core.network.idc.a.aaw().fu(strXO);
        bVar.enable = true;
        bVar.bjd = str;
        bVar.version = zUseTkLite ? "3.3.60-lite" : "3.3.60";
        bVar.bjh = false;
        bVar.bjg = str2;
        bVar.bjj = map;
        com.kwad.library.b.a aVarQ = com.kwad.library.solder.a.a.q(context, ITkOfflineCompo.PACKAGE_NAME);
        com.kwad.sdk.core.d.c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + aVarQ);
        if (aVarQ instanceof com.kwad.library.b.a) {
            bVar.bjm = aVarQ.Pe();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.d.b.a.1
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
                LP();
            }

            private void LP() {
                soLoadListener.onLoaded();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.PB()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.c cVar) {
                super.e(cVar);
                soLoadListener.onPreUpdate();
                long unused = a.bcB = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.PB()).setThreadPoolCoreSize(cVar.Pv().Pi().PJ()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.PB()).setDownloadTime(SystemClock.elapsedRealtime() - a.bcB).setDownloadState(1).setThreadPoolCoreSize(cVar.Pv().Pi().PJ()).toJson());
                }
            }
        });
    }
}
