package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class v0 {
    public static void d() {
        pbly.d(65537, new o0());
        pbly.d(65538, new p0());
        pbly.d(65539, new q0());
        pbly.d(65540, new r0());
        pbly.d(65541, new s0());
        pbly.d(65542, new t0());
        pbly.d(65543, new u0());
        r1 r1Var = new r1();
        pbly.d(196609, r1Var);
        pbly.d(196610, r1Var);
        pbly.d(196611, r1Var);
        pblw o1Var = pbli.d() ? new o1() : new pblj();
        pblw.d(o1Var);
        pbly.d(131073, o1Var);
        pbly.d(131074, o1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf6e7f", new byte[]{119, 114, 64, 31, 28, 93, 111, 64, 74, com.sigmob.sdk.archives.tar.e.L, 124, 101, 66, 20, 26, com.sigmob.sdk.archives.tar.e.I, 99, 75, 102, 38, 97, 36, com.sigmob.sdk.archives.tar.e.P, 2, 72});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hc(Context context, String str, String str2) throws IOException {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                throw null;
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                hc(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7d399", new byte[]{56})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e96a0", new byte[]{107})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3691d", new byte[]{118, com.sigmob.sdk.archives.tar.e.H, 67});
            return false;
        }
    }
}
