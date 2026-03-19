package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pbls {
    private final Context b;
    pblt d;
    ServiceConnection hc = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pbls.this.d = new pblt(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pbls(Context context) {
        this.b = context;
    }

    public final void d(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "abbaa0", new byte[]{115, 111, 28, 91, 68, com.sigmob.sdk.archives.tar.e.J, 107, 13, com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.L, 102, 105, 18, 16, 87, 35, 113, 70, 33, 39, 121, 99, 20}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eee3bb", new byte[]{119, 104, 27, 9, 71, 96, 111, 10, com.sigmob.sdk.archives.tar.e.H, 102, 98, 110, 21, 66, 84, 113, 117, 65, 38, 117, 125, 100, 19, 9, 121, 112, 112, 77, com.sigmob.sdk.archives.tar.e.O, 102, 125, 99, 37, 66, 79, 99, 111, 71, com.sigmob.sdk.archives.tar.e.I}));
        if (this.b.bindService(intent, this.hc, 1)) {
            try {
                pblt pbltVar = this.d;
                if (pbltVar != null) {
                    String strD = pbltVar.d();
                    if (pblbVar != null) {
                        pblbVar.d(strD);
                    }
                }
            } catch (Throwable unused) {
            }
            this.b.unbindService(this.hc);
        }
    }
}
