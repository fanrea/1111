package ms.bz.bd.c.Pgl;

import java.util.Arrays;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class v extends pbly.pgla {
    v() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object d(long j, String str, Object obj) throws Throwable {
        Throwable thHc = p1.d().hc();
        return thHc != null ? Arrays.toString(thHc.getStackTrace()) : "";
    }
}
