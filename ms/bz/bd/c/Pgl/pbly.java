package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pbly {
    public static final /* synthetic */ int d = 0;
    private static final SparseArray<pgla> hc = new SparseArray<>();

    public static abstract class pgla {
        public Object d(int i, int i2, long j, String str, Object obj) throws Throwable {
            return d(j, str, obj);
        }

        protected Object d(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object d(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = hc.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c7cf03", new byte[]{125, 37, 80, 17, 0, 32, 101, 86, 119, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.J, 60, 3, 82, 6, 42, 118, 23, 62, Utf8.REPLACEMENT_BYTE, 118}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.d(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void d(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = hc;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f3c10f", new byte[]{com.sigmob.sdk.archives.tar.e.J, 34, 80, 77, 14, 117, 37, 16, com.sigmob.sdk.archives.tar.e.O, 100, 121, 113, 2, 64, 8, com.sigmob.sdk.archives.tar.e.R, 118, 6, com.sigmob.sdk.archives.tar.e.O, 115, 57}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }
}
