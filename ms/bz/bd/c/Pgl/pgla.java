package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pgla {
    private final Context b;
    public final LinkedBlockingQueue<IBinder> d = new LinkedBlockingQueue<>(1024);
    ServiceConnection hc = new ServiceConnectionC0851pgla();

    /* renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    final class ServiceConnectionC0851pgla implements ServiceConnection {
        ServiceConnectionC0851pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                pgla.this.d.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pgla(Context context) {
        this.b = context;
    }

    public final void d(pblk.pblb pblbVar) throws PackageManager.NameNotFoundException {
        try {
            this.b.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "de219c", new byte[]{118, 104, com.sigmob.sdk.archives.tar.e.P, 11, 7, com.sigmob.sdk.archives.tar.e.T, 114, 87, 45, 108, 102, 102, 15, 118, 19, 100, 119, 72, 102, 108, 112, 105, 85, 68, 20, 109, 67, 109, 71}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc6ac1", new byte[]{113, 110, 72, 91, 93, com.sigmob.sdk.archives.tar.e.M, 117, 81, 41, 60, 97, 96, 11, 20, 95, com.sigmob.sdk.archives.tar.e.J, 105, 77, 105, 127, com.sigmob.sdk.archives.tar.e.Q, 66, 102, com.sigmob.sdk.archives.tar.e.H, 111, 21, 95, 102, 78, 21}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ce5541", new byte[]{113, 104, 75, 15, 10, com.sigmob.sdk.archives.tar.e.M, 117, 87, 42, 104, 97, 102, 8, 114, 30, com.sigmob.sdk.archives.tar.e.N, 112, 72, 97, 104, 119, 105, 82, 64, 25, Utf8.REPLACEMENT_BYTE, 68, 109, 64}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ace329", new byte[]{115, 110, 27, 9, 12, 61, 119, 81, 122, 110, 99, 96, com.sigmob.sdk.archives.tar.e.S, 116, 24, 62, 114, 78, com.sigmob.sdk.archives.tar.e.I, 110, 117, 111, 2, 70, 31, com.sigmob.sdk.archives.tar.e.O, 70, 107, 16, 45, 67, 116, 6, 87, 1, 43, 111, 71, 58, 119, 113, 115, 15, 99, 36, 10, 81, 71, 38, 117, 121, 98, 19})));
        if (this.b.bindService(intent, this.hc, 1)) {
            try {
                String strD = new pblb(this.d.take()).d();
                if (pblbVar != null) {
                    pblbVar.d(strD);
                }
            } catch (Exception unused2) {
            } catch (Throwable th) {
                this.b.unbindService(this.hc);
                throw th;
            }
            this.b.unbindService(this.hc);
        }
    }
}
