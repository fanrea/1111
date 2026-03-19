package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class s extends pbly.pgla {
    s() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object d(long j, String str, Object obj) throws Throwable {
        Context contextHc = pblv.d().hc();
        if (contextHc != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) contextHc.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f067d0", new byte[]{116, 61, 75, 77, 94, 36, 113, 24, 113, 110, 99, 43}));
                Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6c5def", new byte[]{32, 100, 82, com.sigmob.sdk.archives.tar.e.I, 89, 101, 60, 84, 97, 26, 34, 117, 81, 31, 72, 122, 28, com.sigmob.sdk.archives.tar.e.P, 98, 59}), new Class[0]);
                declaredMethod.setAccessible(true);
                NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                if (networkInfo != null) {
                    Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "20fc26", new byte[]{42, 33, com.sigmob.sdk.archives.tar.e.L, 1, 12, 40, 61, 16, com.sigmob.sdk.archives.tar.e.M, Utf8.REPLACEMENT_BYTE, 38}), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                }
            } catch (Throwable unused) {
            }
        }
        return Boolean.FALSE;
    }
}
