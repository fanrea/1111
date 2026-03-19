package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b1 {
    private String b;
    private c1 c;
    ServiceConnection d;
    private final Context hc;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.c = new c1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            b1.this.c = null;
        }
    }

    public b1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c4be4c", new byte[]{93, 3, 56, com.sigmob.sdk.archives.tar.e.M});
        this.d = new pgla();
        this.hc = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(ms.bz.bd.c.Pgl.c1 r25, java.lang.String r26) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.b1.d(ms.bz.bd.c.Pgl.c1, java.lang.String):java.lang.String");
    }

    public final void d(pblk.pblb pblbVar) {
        boolean z;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0444b4", new byte[]{2, com.sigmob.sdk.archives.tar.e.O, 73, 78, 82, com.sigmob.sdk.archives.tar.e.O, 115, 7, 112, 106, 97, 57, 73, 0, 112, 34, 58, 27, 81, 108, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.f789K, 70, 68}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "549818", new byte[]{39, 57, 71, 2, 6, 42, 47, 1, 105, com.sigmob.sdk.archives.tar.e.R, 106, 57, 90, 73, 0, 38, com.sigmob.sdk.archives.tar.e.J}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0bf234", new byte[]{34, 111, 24, 8, 4, 38, 42, 87, com.sigmob.sdk.archives.tar.e.N, 114, 111, 111, 5, 67, 2, 42, com.sigmob.sdk.archives.tar.e.O, 13, 30, 102, 36, 110, 1, 79, 10, 58, 0, 70, 37, 116, 40, 99, 16})));
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e59a2", new byte[]{35, 100, 82, 68, 81, 43, 126, 71, 107, 100, 108, 111, 67, 84, 74, 36, 32, 10, 107, 121, 39, 105, 79, 73, 16, 10, 0, 97, 74, 86, 11, 67, 121, 126, 123, 23, 6, 109, 71, com.sigmob.sdk.archives.tar.e.P}));
        boolean z2 = false;
        try {
            if (this.hc.bindService(intent, this.d, 1)) {
                try {
                    try {
                        SystemClock.sleep(com.alipay.sdk.m.u.b.a);
                    } catch (Throwable unused) {
                        z = true;
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a140b", new byte[]{45, 115});
                            if (!z) {
                                return;
                            }
                        } finally {
                            if (z) {
                                this.hc.unbindService(this.d);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
                c1 c1Var = this.c;
                if (c1Var != null) {
                    String strD = d(c1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c527fe", new byte[]{93, 2, 104, com.sigmob.sdk.archives.tar.e.T}));
                    if (pblbVar != null) {
                        pblbVar.d(strD);
                    }
                }
                z2 = true;
            }
            if (!z2) {
            }
        } catch (Throwable unused3) {
            z = false;
        }
    }
}
