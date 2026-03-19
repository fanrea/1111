package ca.da.da;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* compiled from: ServiceBlockBinder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class v<SERVICE, RESULT> {
    public final CountDownLatch a = new CountDownLatch(1);
    public final Intent b;
    public final b<SERVICE, RESULT> c;
    public final Context d;

    /* compiled from: ServiceBlockBinder.java */
    public class a implements ServiceConnection {
        public final CountDownLatch a;
        public final b<SERVICE, RESULT> b;
        public SERVICE c;

        public a(v vVar, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.a = countDownLatch;
            this.b = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = m.j;
            String str2 = "ServiceBlockBinder#onServiceConnected " + componentName;
            try {
                this.c = this.b.a(iBinder);
                try {
                    this.a.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    String str3 = m.j;
                    try {
                        this.a.countDown();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    try {
                        this.a.countDown();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th2;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String str = m.j;
            String str2 = "ServiceBlockBinder#onServiceDisconnected" + componentName;
            try {
                this.a.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ServiceBlockBinder.java */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t) throws Exception;
    }

    public v(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.d = context;
        this.b = intent;
        this.c = bVar;
    }

    public RESULT a() {
        Throwable th;
        v<SERVICE, RESULT>.a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        try {
            aVar = new a(this, this.a, this.c);
            this.d.bindService(this.b, aVar, 1);
            this.a.await();
            try {
                return this.c.a((b<SERVICE, RESULT>) aVar.c);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    a(aVar);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
    }

    public final void a(v<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
