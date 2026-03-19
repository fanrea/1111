package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static C0574a buK;

    /* renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    public static class C0574a extends com.kwad.sdk.core.response.a.a {
        public List<String> buL;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static void a(AdTemplate adTemplate, boolean z, b bVar) {
        if (eq(bVar.buE)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(c.Wz().dW(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.001d).b(d.bt(adTemplate)).V("ad_sdk_track_performance", "status").w(bVar));
    }

    public static void n(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.WM().es(4).et(i).er(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.b.d(c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(1.0d).b(d.bt(adTemplate)).V("ad_sdk_macro_check_performance", "error_name").w(com.kwad.sdk.commercial.i.a.WJ().ej(str).el(str2).em(str3).ek(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.WM().es(1).et(i).er(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.WM().es(2).et(i).er(str).eu(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.WM().es(3).et(i).er(str).es(str2).setErrorCode(i2).setErrorMsg(str3).eu(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean eq(String str) {
        C0574a c0574aWK;
        List<String> list;
        if (TextUtils.isEmpty(str) || (c0574aWK = WK()) == null || (list = c0574aWK.buL) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static C0574a WK() {
        String strUy = ((h) ServiceProvider.get(h.class)).Uy();
        if (!TextUtils.isEmpty(strUy)) {
            buK = (C0574a) aa.b(strUy, new com.kwad.sdk.core.c<C0574a>() { // from class: com.kwad.sdk.commercial.j.a.1
                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b Le() {
                    return WL();
                }

                private static C0574a WL() {
                    return new C0574a();
                }
            });
        }
        return buK;
    }
}
