package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class p0 extends pbly.pgla {
    p0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        Context contextHc = pblv.d().hc();
        return contextHc != null ? contextHc.getPackageName() : "";
    }
}
