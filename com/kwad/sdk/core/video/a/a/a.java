package com.kwad.sdk.core.video.a.a;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.k;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends com.kwad.sdk.core.report.b<c, b> {
    private static a bIE = new a();
    private static volatile boolean bED = false;

    @Override // com.kwad.sdk.core.report.b
    public final /* synthetic */ f aj(List list) {
        return an(list);
    }

    private a() {
    }

    public static a acK() {
        return bIE;
    }

    @Override // com.kwad.sdk.core.report.b
    public final void m(Context context, int i) {
        if (bED) {
            return;
        }
        super.m(context, i);
        bED = true;
    }

    public static void ag(final String str, final String str2) {
        bIE.a(new k<c>() { // from class: com.kwad.sdk.core.video.a.a.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.report.k
            /* renamed from: acL, reason: merged with bridge method [inline-methods] */
            public c abf() {
                return new c(str, str2);
            }
        });
    }

    private static b an(List<c> list) {
        return new b(list);
    }
}
