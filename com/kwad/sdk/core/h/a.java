package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static C0588a bIb;
    private static boolean bIc;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean bId = true;

    /* renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    public static class C0588a extends com.kwad.sdk.core.response.a.a {
        public List<String> bIe;
        public int bIf;
        public List<String> bIg;
        public List<String> bIh;
    }

    public static void acs() {
        h.execute(new bh() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C0588a unused = a.bIb = new C0588a();
                    boolean unused2 = a.bIc = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UA();
                    String strUB = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UB();
                    if (a.bIc && !TextUtils.isEmpty(strUB)) {
                        a.bIb.parseJson(new JSONObject(strUB));
                        a.act();
                        return;
                    }
                    boolean unused3 = a.bId = a.bIc;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void act() {
        bId = true;
        if (bIb == null) {
            return;
        }
        fy(acu());
        ag.n("ksadsdk_tk_switch", "tk_config", bId);
    }

    private static void fy(int i) {
        for (int i2 = 0; i2 < Integer.toBinaryString(i).length(); i2++) {
            if (((1 << i2) & i) != 0) {
                bId = false;
                fz(i2);
                if (bId) {
                    return;
                }
            }
        }
    }

    private static void fz(int i) {
        if (i == 0) {
            if (bIb.bIg.contains(bs.aqb())) {
                return;
            }
            bId = true;
        } else if (i == 1) {
            if (bIb.bIf < bs.aql()) {
                bId = true;
            }
        } else if (i == 2) {
            if (bIb.bIe.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            bId = true;
        } else if (i == 3 && !bIb.bIh.contains(bs.aqa())) {
            bId = true;
        }
    }

    private static int acu() {
        int i = !bIb.bIg.isEmpty() ? 1 : 0;
        int i2 = bIb.bIf != 0 ? 2 : 0;
        return ((i ^ i2) ^ (!bIb.bIe.isEmpty() ? 4 : 0)) ^ (bIb.bIh.isEmpty() ? 0 : 8);
    }

    public static boolean acv() {
        if (mHasInit.get()) {
            return bId;
        }
        return ag.o("ksadsdk_tk_switch", "tk_config", true);
    }
}
