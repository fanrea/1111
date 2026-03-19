package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblk {
    private final pblb d;

    public interface pblb {
        void d(String str);
    }

    final class pgla implements Runnable {
        final /* synthetic */ Context d;

        pgla(Context context) {
            this.d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b94f7c", new byte[]{82, 8, 114, 33})).equals(pblk.d(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.d).d(pblk.this.d);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1b423b", new byte[]{8, 85, 102, 113, 41, 92})).equals(pblk.d(pblk.this).toUpperCase())) {
                    new pblo(this.d).d(pblk.this.d);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ceb2eb", new byte[]{93, 87, 33, 105})).equals(pblk.d(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "652279", new byte[]{8, 25, 100, 118, 36, 27, 6})).equals(pblk.d(pblk.this).toUpperCase())) {
                    b1 b1Var = new b1(this.d);
                    b1Var.d(pblk.this.d);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e50fbb", new byte[]{78, 3, 102})).equals(pblk.d(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8661bd", new byte[]{15, 17, 119, 119, 112, 86, 20, 36})).equals(pblk.d(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.d() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa8dcf", new byte[]{68, 80, 126, 57})).equals(pblk.d(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.hc() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22b542", new byte[]{16, 17, 60, 114, 62, 11, 22})).equals(pblk.d(pblk.this).toUpperCase())) {
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f871ad", new byte[]{91, 31, 106, 106, 104, 92})).equals(pblk.d(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "601731", new byte[]{10, 29, 118, 108, 32, 9, 7, com.sigmob.sdk.archives.tar.e.H})).equals(pblk.d(pblk.this).toUpperCase())) {
                    pbls pblsVar = new pbls(this.d);
                    pblsVar.d(pblk.this.d);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public pblk(pblb pblbVar) {
        this.d = pblbVar;
    }

    private static String d(String str) throws ClassNotFoundException {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "efe468", new byte[]{117, 106, 18, 82, 6, 38, 98, 9, 59, 119, 58, 87, 15, com.sigmob.sdk.archives.tar.e.Q, 29, 42, 107, 119, 38, 107, 100, 97, 4, 84, 0, 42, 117}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "051d61", new byte[]{38, com.sigmob.sdk.archives.tar.e.J, 86}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dc923d", new byte[]{96, 111, 65, 72, 3, 100, 105}));
        } catch (Exception unused) {
            return null;
        }
    }

    static String d(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean d() throws ClassNotFoundException {
        String strD = d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "945b58", new byte[]{58, 57, 8, 20, 31, 38, com.sigmob.sdk.archives.tar.e.N, 17, 42, com.sigmob.sdk.archives.tar.e.L, 58, com.sigmob.sdk.archives.tar.e.f789K, 67, 27, 15, 97, com.sigmob.sdk.archives.tar.e.N, 20, 102, com.sigmob.sdk.archives.tar.e.O, 36}));
        return !TextUtils.isEmpty(strD) && strD.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fb5fb1", new byte[]{81, 82, 99, com.sigmob.sdk.archives.tar.e.O, 112, 3, 74, 112}));
    }

    private void hc(Context context) {
        new com.bytedance.sdk.component.tc.c.b(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    public static boolean hc() throws ClassNotFoundException {
        String strD = d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7a200", new byte[]{com.sigmob.sdk.archives.tar.e.T, 58, 92, 85, 28, com.sigmob.sdk.archives.tar.e.J, 110, com.sigmob.sdk.archives.tar.e.S, 32, 112, 122, com.sigmob.sdk.archives.tar.e.I, 7, 69, 27}));
        return (TextUtils.isEmpty(strD) || strD.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "338385", new byte[]{com.sigmob.sdk.archives.tar.e.O, Utf8.REPLACEMENT_BYTE, 64, 73, 8, com.sigmob.sdk.archives.tar.e.M, 62}))) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(android.content.Context r13) throws android.content.pm.PackageManager.NameNotFoundException, android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblk.d(android.content.Context):void");
    }
}
