package ms.bz.bd.c.Pgl;

import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class k0 extends pbly.pgla {
    k0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        String id;
        int rawOffset;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            id = timeZone.getID();
            try {
                rawOffset = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused) {
                rawOffset = 0;
                return id + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108})) + rawOffset;
            }
        } catch (Throwable unused2) {
            id = null;
        }
        return id + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "11a32f", new byte[]{108})) + rawOffset;
    }
}
