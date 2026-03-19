package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private static boolean RA = false;

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.T(adInfoEP)) {
            return 0;
        }
        return a(context, adInfoEP.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    public static boolean E(AdInfo adInfo) {
        return (adInfo == null || adInfo.adConversionInfo.smallAppJumpInfo == null || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.k(adTemplate, 1);
            return 0;
        }
        Cursor cursor = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursorQuery != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bx.A(th));
                        com.kwad.sdk.core.adlog.c.k(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th2) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        throw th2;
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return 1;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void a(final JumpFrom jumpFrom, final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (qf()) {
            return;
        }
        aC(true);
        int iAbs = Math.abs(com.kwad.sdk.core.config.e.Ya());
        if (iAbs > 0) {
            bx.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.aC(false);
                    com.kwad.sdk.core.c.b.aaf();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.c(adTemplate, "wxsmallapp", 1);
                }
            }, null, iAbs * 1000);
        } else {
            aC(false);
        }
    }

    private static boolean qf() {
        return RA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aC(boolean z) {
        RA = z;
    }
}
