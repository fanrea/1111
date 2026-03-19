package lk.repeackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.lk.oaid.ErrorCode;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class t implements ServiceConnection {
    public final Context a;
    public final c b;
    public final a c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    public t(Context context, c cVar, a aVar) {
        this.a = context instanceof Application ? context : context.getApplicationContext();
        this.b = cVar;
        this.c = aVar;
    }

    public static void a(Context context, Intent intent, c cVar, a aVar) {
        t tVar = new t(context, cVar, aVar);
        try {
            if (!tVar.a.bindService(intent, tVar, 1)) {
                throw new e("Service binding failed");
            }
            f.a("Service has been bound: " + intent);
        } catch (Exception e) {
            tVar.b.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    f.a("OAID acquire success: " + strA);
                    this.b.onOAIDGetComplete(strA);
                    this.a.unbindService(this);
                    f.a("Service has been unbound: " + componentName.getClassName());
                } catch (Throwable th) {
                    try {
                        this.a.unbindService(this);
                        f.a("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        f.a(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                f.a(e2);
            }
        } catch (Exception e3) {
            f.a(e3);
            this.b.onOAIDGetError(ErrorCode.STATE_OCCUR_EXCEPTION, e3);
            this.a.unbindService(this);
            f.a("Service has been unbound: " + componentName.getClassName());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        f.a("Service has been disconnected: " + componentName.getClassName());
    }
}
