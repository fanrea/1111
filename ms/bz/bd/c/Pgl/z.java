package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class z extends pbly.pgla {
    z() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object d(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context contextHc = pblv.d().hc();
            if (contextHc != null) {
                return Boolean.valueOf((contextHc.getApplicationInfo() == null || (contextHc.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
