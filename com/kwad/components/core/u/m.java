package com.kwad.components.core.u;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m {
    public static boolean d(AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.b.b.dR(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            return com.kwad.sdk.core.config.e.YQ();
        }
        return false;
    }

    public static void f(Context context, AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(context).ao(true).aC(adTemplate));
    }
}
