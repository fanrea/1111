package com.kwad.components.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.AdLiveOfflineCompoImpl;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import com.kwad.so.BuildConfig;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static final AtomicBoolean bbg = new AtomicBoolean(false);
    private static final String bbh = ah.format("lib%s.so", "c++_shared");
    private static final String bbl = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_AEGON);
    private static final String bbs = ah.format("lib%s.so", "cjson");
    private static final String bbt = ah.format("lib%s.so", "AemonPlayer");
    private static final String bbu = ah.format("lib%s.so", "ffmpeg");
    private static final String bbk = ah.format("lib%s.so", AdLiveOfflineCompoImpl.SO_HODOR);
    private static final String bbv = ah.format("lib%s.so", "kpwebrtc");
    private static final String bbw = ah.format("lib%s.so", "ksaudioprocesslib-dl");
    private static final String bbx = ah.format("lib%s.so", "ksaudioprocesslib");
    private static final String bby = ah.format("lib%s.so", "ksp2p");
    private static final String bbz = ah.format("lib%s.so", "kwaiplayer_dva");
    private static final String bbA = ah.format("lib%s.so", "RtcMediaTransport");
    private static final String bbB = ah.format("lib%s.so", "slp2p");
    private static final String bbC = ah.format("lib%s.so", "xyvodsdk");
    private static final String bbD = ah.format("lib%s.so", "cpu-infov1");
    private static final String bbE = ah.format("lib%s.so", "yuv");

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
            map.put(bbl, "333cc7399bdac5e0c5594b20fef820b9");
            map.put(bbs, "c776ddaa8d6e4bdc42051fa566df692d");
            map.put(bbt, "39366cae51a7cebda67a8a6cfc509e55");
            map.put(bbh, "5fb2bd6653d0f3e74745fb74d24b4047");
            map.put(bbu, "c5c427bd691e4b3948e3c50bbba9e759");
            map.put(bbk, "8195262f0da1a21a997b98e958f49397");
            map.put(bbv, "231f59d578548d008b04ab5023510621");
            map.put(bbw, "ab8bc42a8460e95846de5436a8cef356");
            map.put(bbx, "9f64c805ca3695e9b4c05bb293607c88");
            map.put(bby, "7e86a5b800f7799a2e8f3edd1e3a46fd");
            map.put(bbz, "a1f4a38699090782e4793929370b0274");
            map.put(bbA, "5fcb2ca4dfeb0e4d0e5343e66edb7d0a");
            map.put(bbB, "1be34a5640da785cb7a99a8e457a5370");
            map.put(bbC, "3e376cbc66cbc489f92c90518177ba5d");
            map.put(bbD, "c27a219c9d3f7aaec8617a34c4646075");
            map.put(bbE, "4ec281a4abfdbb7119143fb26857e102");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adWaynePlayer/ks_so-adWaynePlayerArm64v8aRelease-3.3.76-e8fbb3a5f8-666.apk";
            str2 = "adWaynePlayer-v8a";
            str3 = "ef09635a47f800d04957d70650017b2d";
        } else {
            map.put(bbl, "20fe1d4701c4cd5975ba148b94c36793");
            map.put(bbs, "547873311402f6dfc28bd27f310ab680");
            map.put(bbt, "1ddb288b9d26e6c93b1e5dc6594180e2");
            map.put(bbh, "bf209aecc73c55eb87318d5a64c76478");
            map.put(bbu, "8a3f3ac0cbd9b2819674788538768a8f");
            map.put(bbk, "22a0687c583a3b0886e79e827a3b018e");
            map.put(bbv, "e70414e3787126ad16ce663466c1beff");
            map.put(bbw, "cc1342476e392378be4ea4b6f0621e86");
            map.put(bbx, "09987f7cbe19016fc049929ee7306930");
            map.put(bby, "722371b2d3caca321c6d0a3ec1b6b4ff");
            map.put(bbz, "677277694e40939f144ae464464f9407");
            map.put(bbA, "cfc492113e7dd7b377dde2e94ad3675f");
            map.put(bbB, "dafb194f4e5ab3a797aaf61933d8f05e");
            map.put(bbC, "2744330ddd8fcf3e83766adcaf04d23b");
            map.put(bbD, "b7af666efe7df5f8cbeac671cd7b1353");
            map.put(bbE, "e4887fcd52a2cebbd06c9d51a01cbee7");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adWaynePlayer/ks_so-adWaynePlayerArmeabiv7aRelease-3.3.76-e8fbb3a5f8-666.apk";
            str2 = "adWaynePlayer-v7a";
            str3 = "e54d58329c045aa8e9b0a08fceedb939";
        }
        b bVar = new b();
        com.kwad.library.b.a aVarQ = com.kwad.library.solder.a.a.q(context, IAdWaynePlayerOfflineCompo.PACKAGE_NAME);
        c.d("AdWaynePlayerSoLoadHelper", "adWaynePlayerOfflineCompoPlugin: " + aVarQ);
        if (aVarQ instanceof com.kwad.library.b.a) {
            bVar.bjm = aVarQ.Pe();
        }
        bVar.bje = com.kwad.sdk.core.network.idc.a.aaw().fu(str);
        bVar.enable = true;
        bVar.bjd = str2;
        bVar.version = BuildConfig.VERSION_NAME;
        bVar.bjj = map;
        bVar.bjg = str3;
        bVar.bjh = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.b.a.a.1
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
