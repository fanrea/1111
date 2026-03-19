package ms.bz.bd.c.Pgl;

import java.util.Locale;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class l0 extends pbly.pgla {
    l0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pblv.d().hc().getResources().getConfiguration().locale;
            str2 = locale.getLanguage() + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5fed00", new byte[]{27})) + locale.getCountry();
        } catch (Throwable unused) {
            str2 = null;
        }
        return q1.d(str2);
    }
}
