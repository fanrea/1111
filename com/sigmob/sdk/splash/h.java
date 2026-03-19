package com.sigmob.sdk.splash;

import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.r;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h implements r {
    public static final String a = "SplashAdViewAbilitySession";

    private void a(BaseAdUnit adUnit, String event, String sub, final HashMap<String, String> options) {
        ac.a(event, sub, adUnit, new ac.a() { // from class: com.sigmob.sdk.splash.h$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                h.a(options, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap map, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(map)) {
                pointEntitySigmob.getOptions().putAll(map);
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, int duration, int endTime) {
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a9 A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:3:0x0004, B:7:0x0017, B:10:0x001f, B:13:0x0027, B:16:0x002f, B:19:0x0039, B:31:0x0053, B:33:0x005c, B:37:0x0069, B:40:0x00b4, B:41:0x00e0, B:46:0x0121, B:48:0x01a9, B:49:0x01d6, B:53:0x0208, B:55:0x0254, B:56:0x026a, B:50:0x01da, B:52:0x01e6, B:42:0x00e4, B:44:0x00f0, B:45:0x0112, B:57:0x0274, B:58:0x027b), top: B:63:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01da A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:3:0x0004, B:7:0x0017, B:10:0x001f, B:13:0x0027, B:16:0x002f, B:19:0x0039, B:31:0x0053, B:33:0x005c, B:37:0x0069, B:40:0x00b4, B:41:0x00e0, B:46:0x0121, B:48:0x01a9, B:49:0x01d6, B:53:0x0208, B:55:0x0254, B:56:0x026a, B:50:0x01da, B:52:0x01e6, B:42:0x00e4, B:44:0x00f0, B:45:0x0112, B:57:0x0274, B:58:0x027b), top: B:63:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0254 A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:3:0x0004, B:7:0x0017, B:10:0x001f, B:13:0x0027, B:16:0x002f, B:19:0x0039, B:31:0x0053, B:33:0x005c, B:37:0x0069, B:40:0x00b4, B:41:0x00e0, B:46:0x0121, B:48:0x01a9, B:49:0x01d6, B:53:0x0208, B:55:0x0254, B:56:0x026a, B:50:0x01da, B:52:0x01e6, B:42:0x00e4, B:44:0x00f0, B:45:0x0112, B:57:0x0274, B:58:0x027b), top: B:63:0x0004 }] */
    @Override // com.sigmob.sdk.base.common.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r10, java.lang.String r11, int r12) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.splash.h.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, int):boolean");
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, boolean isForceShow, int playHeadMillis) {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean b(BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, "ad_close");
        a(adUnit, "ad_close", null, null);
        return true;
    }
}
