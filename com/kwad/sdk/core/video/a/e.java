package com.kwad.sdk.core.video.a;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private static boolean abE = false;
    private static final AtomicBoolean bIA = new AtomicBoolean(false);
    private static final AtomicBoolean bIB = new AtomicBoolean(false);
    private static int bIC = 0;
    private static AtomicBoolean bIy = null;
    private static int bIz = -1;

    public static void fU(String str) {
        try {
            AtomicBoolean atomicBoolean = bIA;
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            S(m.arl(), str);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static int acH() {
        return bIC;
    }

    public static boolean acI() {
        AtomicBoolean atomicBoolean = bIy;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        bIy = new AtomicBoolean(true);
        try {
            if (Class.forName("com.kwai.video.player.KsMediaMeta") != null) {
                bIy = new AtomicBoolean(true);
                return true;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            bIy = new AtomicBoolean(false);
        }
        return bIy.get();
    }

    public static boolean Wo() {
        return bIB.get() || com.kwad.framework.a.a.OS.booleanValue();
    }

    private static void S(final Context context, final String str) {
        String str2;
        String str3;
        String str4;
        HashMap<String, String> map = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            map.put("libaegon.so", "c256c0d7f79ad4d47db61cb8e8ab142a");
            map.put("libhodor.so", "a61edf93bc5abc7799c5444ccbaf140b");
            map.put("libkwaiplayer.so", "cf71bcc476b2b25e2e62b541275ad78c");
            map.put("libc++_shared.so", "dcd68cd059cb06a9596ba6839c2e8858");
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArm64v8aRelease-3.3.44-e8fbb3a5f8-666.apk";
            str3 = "kwaiplayer-v8a";
            str4 = "bf333731f64a09f853637ae4ca2406be";
        } else {
            map.put("libaegon.so", "bdac6eea0d25da98061c21234f3b20c5");
            map.put("libhodor.so", "d997935a035d00a67dc46e26427b8bf9");
            map.put("libkwaiplayer.so", "2ba24f9d0a6e786af477ed1e2dad148b");
            map.put("libc++_shared.so", "e3fdbf82716c2cb9b666a3880ab94003");
            str2 = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/so/ks_so-kwaiPlayerArmeabiv7aRelease-3.3.44-e8fbb3a5f8-666.apk";
            str3 = "kwaiplayer-v7a";
            str4 = "8cee8a5c6ea62206b6a159b49dedbbb5";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.bje = com.kwad.sdk.core.network.idc.a.aaw().fu(str2);
        bVar.enable = true;
        bVar.bjd = str3;
        bVar.version = "3.3.53";
        bVar.bjh = true;
        bVar.bjg = str4;
        bVar.bjj = map;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.core.video.a.e.1
            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
                LP();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                acJ();
            }

            private void LP() {
                com.kwad.sdk.core.d.c.d("KwaiPlayHelper", "onPostLoad");
                try {
                    e.T(context, str);
                    e.bIB.set(true);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    e.bIB.set(false);
                }
            }

            private static void acJ() {
                com.kwad.sdk.core.d.c.d("KwaiPlayHelper", "onFail");
                e.bIB.set(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Context context, String str) {
        boolean z = false;
        com.kwad.sdk.core.video.a.a.a.acK().m(context, 0);
        KSVodPlayerCoreInitConfig.updatePlayerConfig(str);
        KSVodPlayerCoreInitConfig.init(context);
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null && fVar.TP()) {
            z = true;
        }
        if (z) {
            KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.a.e.2
                @Override // com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader.ILogger
                public final void logTaskEvent(String str2, String str3) {
                    com.kwad.sdk.core.video.a.a.a.ag(str2, str3);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        b bVar;
        b bVar2;
        try {
            if (Wo() && z2 && acI()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                bIC = 2;
                dVar.cB(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                bIC = 1;
                bVar2 = bVar3;
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!abE) {
                abE = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar4 = new b();
            bIC = 1;
            z4 = true;
            bVar = bVar4;
        }
        int iA = av.a(Wo(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ(), z2, acI(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.aa("KwaiPlayHelper", "player v=" + Integer.toBinaryString(iA));
        if (bIz != iA) {
            bIz = iA;
            fB(iA);
        }
        return bVar;
    }

    private static void fB(int i) {
        n nVar = new n(10212L);
        nVar.bFr = i;
        g.a(nVar);
    }
}
