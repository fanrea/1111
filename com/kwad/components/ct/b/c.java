package com.kwad.components.ct.b;

import android.content.Context;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.utils.AbiUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    public static void init(Context context) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = ISLOADED;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        if (AbiUtil.isArm64(context)) {
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArm64v8aRelease-3.3.9-e8fbb3a5f8-666.apk";
            str2 = "sowebp-v8a";
            str3 = "42c0d6b58241e14cdb7d33b7a6629c7a";
        } else {
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-webpArmeabiv7aRelease-3.3.9-e8fbb3a5f8-666.apk";
            str2 = "sowebp-v7a";
            str3 = "95d8a2831a37b4c9252cc4415dd1e425";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        final String strFu = com.kwad.sdk.core.network.idc.a.aaw().fu(str);
        bVar.bje = strFu;
        bVar.enable = true;
        bVar.bjd = str2;
        bVar.version = "3.2";
        bVar.bjg = str3;
        bVar.bjh = false;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.ct.b.c.1
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.network.idc.a.aaw().a(strFu, "cdn", new DomainException(pluginError));
            }
        });
    }
}
