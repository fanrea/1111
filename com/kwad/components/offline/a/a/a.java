package com.kwad.components.offline.a.a;

import android.content.Context;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.AdLiveOfflineCompoImpl;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static final AtomicBoolean bbg = new AtomicBoolean(false);
    private static final String bbh = ah.format("lib%s.so", "c++_shared");
    private static final String bbi = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_KWAI_PLAYER);
    private static final String bbj = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_KSTE);
    private static final String bbk = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_HODOR);
    private static final String bbl = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_AEGON);

    public static void a(Context context, final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = bbg;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> map = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            map.put(bbh, "dcd68cd059cb06a9596ba6839c2e8858");
            map.put(bbi, "cf71bcc476b2b25e2e62b541275ad78c");
            map.put(bbj, "ebb56fa9c5701350497e281c2446660f");
            map.put(bbk, "a61edf93bc5abc7799c5444ccbaf140b");
            map.put(bbl, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            map.put(bbh, "e3fdbf82716c2cb9b666a3880ab94003");
            map.put(bbi, "2ba24f9d0a6e786af477ed1e2dad148b");
            map.put(bbj, "71a9baa45905a6f0e527e5a2e06e8808");
            map.put(bbk, "d997935a035d00a67dc46e26427b8bf9");
            map.put(bbl, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        b bVar = new b();
        com.kwad.library.b.a aVarQ = com.kwad.library.solder.a.a.q(context, "com.kwad.components.adLive");
        c.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + aVarQ);
        if (aVarQ instanceof com.kwad.library.b.a) {
            bVar.bjm = aVarQ.Pe();
        }
        bVar.bje = com.kwad.sdk.core.network.idc.a.aaw().fu(str);
        bVar.enable = true;
        bVar.bjd = str2;
        bVar.version = "3.3.44.3";
        bVar.bjj = map;
        bVar.bjg = str3;
        bVar.bjh = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.a.a.a.1
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                LP();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void LP() {
                soLoadListener.onLoaded();
            }

            private void a(PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }
}
