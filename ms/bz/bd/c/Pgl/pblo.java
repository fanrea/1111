package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblo {
    private final Context b;
    public final LinkedBlockingQueue<IBinder> d = new LinkedBlockingQueue<>(1024);
    ServiceConnection hc = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                pblo.this.d.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pblo(Context context) {
        this.b = context;
    }

    public final void d(pblk.pblb pblbVar) throws PackageManager.NameNotFoundException {
        int i = Build.VERSION.SDK_INT;
        if (i != 28 && i < 33) {
            try {
                this.b.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8dffb", new byte[]{116, com.sigmob.sdk.archives.tar.e.M, 26, 92, 81, 96, 100, 14, com.sigmob.sdk.archives.tar.e.H, Utf8.REPLACEMENT_BYTE, 57, com.sigmob.sdk.archives.tar.e.J, 0, 27, 93}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61cd07", new byte[]{36, 60, 29, 94, 26, 47, com.sigmob.sdk.archives.tar.e.I, 25, 33, 122, 40, 35, 21, 30, 11, 37, 35, 25, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.I, 105, 28, 32, com.sigmob.sdk.archives.tar.e.M, 33, 9, 17, 35, 13, 7, 2, 1, 38, 57, 44, 5}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0f2f2", new byte[]{113, 61, 24, 8, 81, com.sigmob.sdk.archives.tar.e.H, 97, 6, com.sigmob.sdk.archives.tar.e.J, 107, 60, 58, 2, 79, 93}));
            if (this.b.bindService(intent, this.hc, 1)) {
                try {
                    String strD = new pblp(this.d.take()).d();
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
}
