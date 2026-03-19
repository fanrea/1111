package com.kwad.library.solder.a;

import android.content.Context;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static com.kwad.library.b.a q(Context context, String str) {
        com.kwad.library.solder.lib.a.a aVarS = i.Po().s(context, str);
        if (aVarS != null && aVarS.isLoaded() && (aVarS instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) aVarS;
        }
        return null;
    }

    public static void a(Context context, b bVar, b.c cVar) {
        i.Po().a(context, new c(bVar), cVar);
    }

    public static void a(Context context, com.kwad.library.solder.lib.c.b bVar, b.a aVar) {
        i.Po().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }

    public static void r(Context context, String str) {
        i.Po().r(context, str);
    }
}
