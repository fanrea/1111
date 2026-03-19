package ms.bz.bd.c.Pgl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pbli {
    public static boolean d() {
        return d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b84a93", new byte[]{112, com.sigmob.sdk.archives.tar.e.M, 74, 91, 4, 61, 117, 28, 97, com.sigmob.sdk.archives.tar.e.H, 125, 57, 66, 91, 0, com.sigmob.sdk.archives.tar.e.N, 96, 20, 114, 62, 97, com.sigmob.sdk.archives.tar.e.I, 9, 22, 9, com.sigmob.sdk.archives.tar.e.N, 100, 87, 118, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.R, com.sigmob.sdk.archives.tar.e.O, 72, 27, 15, com.sigmob.sdk.archives.tar.e.H, 110, 11, 43, 1, 116, com.sigmob.sdk.archives.tar.e.N, 116, com.sigmob.sdk.archives.tar.e.I, 45, 9, 110, 23, 108, 37, 124, 40, 114, 1, 15, 40, 114}));
    }

    private static boolean d(String... strArr) {
        boolean z;
        boolean z2 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        return z2;
    }
}
